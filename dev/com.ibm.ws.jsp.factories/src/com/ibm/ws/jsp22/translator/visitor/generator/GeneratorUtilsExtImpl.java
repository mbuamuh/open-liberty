/*******************************************************************************
 * Copyright (c) 2017, 2022 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
//  Revisions:
//  Defect PI59436 03/22/2015   hmpadill    EL expressions returning null in EL 3.0 could produce NPE

package com.ibm.ws.jsp22.translator.visitor.generator;

import java.util.Iterator;

import com.ibm.ws.jsp.JspCoreException;
import com.ibm.ws.jsp.translator.utils.FunctionSignature;
import com.ibm.ws.jsp.translator.visitor.generator.GeneratorUtils;
import com.ibm.ws.jsp.translator.visitor.generator.GeneratorUtilsExt;
import com.ibm.ws.jsp.translator.visitor.generator.JavaCodeWriter;
import com.ibm.ws.jsp.translator.visitor.validator.ValidateResult;
import com.ibm.ws.jsp.PagesVersionHandler;

public class GeneratorUtilsExtImpl implements GeneratorUtilsExt {

	public GeneratorUtilsExtImpl() {}

	@Override
	public void generateELFunctionCode(JavaCodeWriter writer,
			ValidateResult validatorResult) throws JspCoreException {

        writer.println("private static org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap = null;");

        if (validatorResult.getValidateFunctionMapper().getFnMap().size() > 0) { //LIDB4147-9

            writer.println();
            writer.println("static {");
            writer.println("_jspx_fnmap = org.apache.jasper.runtime.ProtectedFunctionMapper.getInstance();");

            for (Iterator itr = validatorResult.getValidateFunctionMapper().getFnMap().keySet().iterator(); itr.hasNext();) {  //LIDB4147-9
                String fnQName = (String) itr.next();
                String fnPrefix = fnQName.substring(0, fnQName.indexOf(':'));
                String fnName = fnQName.substring(fnQName.indexOf(':')+1);

                writer.print("_jspx_fnmap.mapFunction(");
                writer.print(GeneratorUtils.quote(fnPrefix));
                writer.print(", ");
                writer.print(GeneratorUtils.quote(fnName));
                writer.print(", ");
                FunctionSignature functionSignature = validatorResult.getValidateFunctionMapper().getSignature(fnQName);
                writer.print(functionSignature.getFunctionClassName() + ".class, ");
                writer.print(GeneratorUtils.quote(functionSignature.getMethodName()));
                writer.print(", ");
                Class[] args = functionSignature.getParameterTypes();
                if (args != null) {
                    writer.print("new Class[] {");
                    for (int j = 0; j < args.length; j++) {
                        if (args[j].isArray()) {
                            writer.print("java.lang.reflect.Array.newInstance("+args[j].getComponentType().getName() + ".class, 0).getClass()");
                        }
                        else {
                            writer.print(args[j].getName() + ".class");
                        }
                        if (j < (args.length - 1)) {
                            writer.print(", ");
                        }
                    }
                    writer.print("} ");
                }
                else {
                    writer.print("null");
                }
                writer.print(");");
                writer.println();
            }
            writer.println("}");
            writer.println();
        }

	}

	@Override
    public String getClassFileVersion() {
        return PagesVersionHandler.LOADED_SPEC_LEVEL;
    }

    //PI59436 start
    @Override
    public String interpreterCall(
            boolean isTagFile,
            String expression,
            Class expectedType,
            String fnmapvar,
            boolean XmlEscape,
            String pageContextVar) {  //PK65013

            /*
             * Determine which context object to use.
             */
            String jspCtxt = null;
            if (isTagFile)
                jspCtxt = "getJspContext()";
            else
                jspCtxt = pageContextVar;

            /*
                 * Determine whether to use the expected type's textual name
             * or, if it's a primitive, the name of its correspondent boxed
             * type.
                 */
            String targetType = GeneratorUtils.getClassType(expectedType);
            String primitiveConverterMethod = GeneratorUtils.getPrimitiveConverterMethod(expectedType);

            if (primitiveConverterMethod != null) {
                XmlEscape = false;
            }

            /*
                 * Build up the base call to the interpreter.
                 */
            // XXX - We use a proprietary call to the interpreter for now
            // as the current standard machinery is inefficient and requires
            // lots of wrappers and adapters.  This should all clear up once
            // the EL interpreter moves out of JSTL and into its own project.
            // In the future, this should be replaced by code that calls
            // ExpressionEvaluator.parseExpression() and then cache the resulting
            // expression objects.  The interpreterCall would simply select
            // one of the pre-cached expressions and evaluate it.
            // Note that PageContextImpl implements VariableResolver and
            // the generated Servlet/SimpleTag implements FunctionMapper, so
            // that machinery is already in place (mroth).
            StringBuffer call =
                new StringBuffer(
                    "("
                        + targetType
                        + ") "
                        + "org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate"
                        + "("
                        + GeneratorUtils.handleEscapes(GeneratorUtils.quote(expression))
                        + ", "
                        + targetType
                        + ".class, "
                        + "(PageContext)"
                        + jspCtxt
                        + ", "
                        + fnmapvar
                        + ", "
                        + XmlEscape
                        + ")");

            /*
                 * Add the primitive converter method if we need to.
                 */
            if (primitiveConverterMethod != null) {
                call.insert(0, "(");
                call.append(")." + primitiveConverterMethod + "()");
            }

            return call.toString();
        }
        //PI59436 end

}
