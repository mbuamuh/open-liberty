/*******************************************************************************
 * Copyright (c) 2022 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.tra.ann;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionDefinition;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.ManagedConnection;
import javax.security.auth.Subject;

import com.ibm.ejs.ras.Tr;
import com.ibm.ejs.ras.TraceComponent;
import com.ibm.tra.SimpleRAImpl;
import com.ibm.tra.outbound.base.ConnectionFactoryBase;
import com.ibm.tra.outbound.base.ConnectionRequestInfoBase;

@ConnectionDefinition(
                      connectionFactory = com.ibm.tra.outbound.base.ConnectionFactoryBase.class,
                      connectionFactoryImpl = com.ibm.tra.outbound.impl.J2CConnectionFactory.class,
                      connection = com.ibm.tra.outbound.base.ConnectionBase.class,
                      connectionImpl = com.ibm.tra.outbound.impl.J2CConnection.class)
public class ConnDefsAnnNonMCF1 { // F743-15626.1 validation ignores lack of MCF ancestry. 

    @SuppressWarnings("unused")
    private static final String className = "ConnDefsAnnNonMCF1";

    private static final TraceComponent tc = Tr.register(ConnDefsAnnNonMCF1.class, SimpleRAImpl.RAS_GROUP, null);

    // Eliminate CTOR for JB validation.
    // (F743-15626.1: Validation works, but does not cause installRAR to fail). 
    //private ConnDefAnnNonJB1() {
    //  super();
    //  DebugTracer.printClassLoaderInfo(className,this);
    //  DebugTracer.printStackDump(className,new Exception());
    //}
    //ConnDefsAnnNonMCF1() {
    //  super();
    //  DebugTracer.printClassLoaderInfo(className,this);
    //  DebugTracer.printStackDump(className,new Exception());
    //}

    public Object createConnectionFactory() throws ResourceException {
        final String methodName = "createConnectionFactory";
        Tr.entry(tc, methodName);

        ConnectionFactoryBase cf = null; //new J2CConnectionFactory( this, new ConnectionManagerBase() );

        Tr.exit(tc, methodName, cf);
        return cf;
    }

    public ManagedConnection createManagedConnection(Subject subj, ConnectionRequestInfo reqInfo) throws ResourceException {
        final String methodName = "createManagedConnection";
        Tr.entry(tc, methodName, new Object[] { subj, reqInfo });

        @SuppressWarnings("unused")
        ConnectionRequestInfoBase myReqInfo = null;
        if (reqInfo != null && reqInfo instanceof ConnectionRequestInfoBase)
            myReqInfo = (ConnectionRequestInfoBase) reqInfo;
        else
            throw new ResourceException("Invalid ConnectionRequestInfo.");

        ManagedConnection mc = null; //new J2CManagedConnection( this, myReqInfo );

        Tr.exit(tc, methodName, mc);
        return mc;
    }
}
