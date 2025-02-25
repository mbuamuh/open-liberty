/*******************************************************************************
 * Copyright (c) 2021 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package io.openliberty.restfulWS.introspector;

import java.io.PrintWriter;
import java.util.Map;
import java.util.WeakHashMap;
import javax.servlet.ServletConfig;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

import com.ibm.wsspi.logging.Introspector;

@Component(service = { Introspector.class, RESTfulEndpointLoggingIntrospector.class },
           immediate = true,
           configurationPolicy = ConfigurationPolicy.IGNORE,
           property = "service.vendor=IBM")
public class ResteasyEndpointIntrospector implements Introspector, RESTfulEndpointLoggingIntrospector {

    private static final Map<ServletConfig, StringBuffer> applicationEndpoints = new WeakHashMap<ServletConfig, StringBuffer>();

    @Override
    public String getIntrospectorName() {
        return "ResteasyEndpointIntrospector";
    }

    @Override
    public String getIntrospectorDescription() {
        return "Log the RESTful endpoints for each Application.";
    }

    @Override
    public void introspect(PrintWriter out) throws Exception {
        for (ServletConfig app : applicationEndpoints.keySet()) {
            out.print(applicationEndpoints.get(app));
        }
    }

    @Override
    public void addEndpoints(ServletConfig servletConfig, StringBuffer sb) {
        applicationEndpoints.put(servletConfig, sb);
    }
}
