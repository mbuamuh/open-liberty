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
package io.openliberty.org.apache.jasper.expressionLanguage50.fat.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.ibm.websphere.simplicity.ShrinkHelper;
import io.openliberty.el50.fat.basic.servlets.EL50BasicTestsServlet;

import componenttest.annotation.Server;
import componenttest.annotation.TestServlet;
import componenttest.custom.junit.runner.FATRunner;
import componenttest.topology.impl.LibertyServer;
import componenttest.topology.utils.FATServletClient;

/**
 * Tests to ensure Expression Language 5.0 basic changes are covered by testing
 */
@RunWith(FATRunner.class)
public class EL50BasicTests extends FATServletClient {

    @Server("expressionLanguage50_basicServer")
    @TestServlet(servlet = EL50BasicTestsServlet.class, contextRoot = "EL50Basic")
    public static LibertyServer elServer;

    @BeforeClass
    public static void setup() throws Exception {
        ShrinkHelper.defaultDropinApp(elServer, "EL50Basic.war", "io.openliberty.el50.fat.basic.servlets");

        elServer.startServer(EL50BasicTests.class.getSimpleName() + ".log");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        // Stop the server
        if (elServer != null && elServer.isStarted()) {
            elServer.stopServer();
        }
    }
}
