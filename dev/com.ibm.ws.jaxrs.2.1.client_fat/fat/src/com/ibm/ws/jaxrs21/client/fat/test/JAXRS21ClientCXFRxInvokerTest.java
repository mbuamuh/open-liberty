/*******************************************************************************
 * Copyright (c) 2020, 2022 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.jaxrs21.client.fat.test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.ibm.websphere.simplicity.ShrinkHelper;

import componenttest.annotation.Server;
import componenttest.custom.junit.runner.FATRunner;
import componenttest.topology.impl.LibertyServer;

@RunWith(FATRunner.class)
public class JAXRS21ClientCXFRxInvokerTest extends JAXRS21AbstractTest {
    @Server("jaxrs21.client.JAXRS21ClientCXFRxInvokerTest")
    public static LibertyServer server;

    private static final String bookstorewar = "jaxrs21bookstore";

    private final static String cxfRxInvokerTarget = "jaxrs21bookstore/CXFRxInvokerTestServlet";

    private static final String reactivex = "lib/";

    private static final String cxf = "lib/";


    @BeforeClass
    public static void setup() throws Exception {


        WebArchive app = ShrinkHelper.buildDefaultApp(bookstorewar, "com.ibm.ws.jaxrs21.fat.JAXRS21bookstore");

        app.addAsLibraries(new File(reactivex).listFiles());
        app.addAsLibraries(new File(cxf).listFiles());
        ShrinkHelper.exportDropinAppToServer(server, app);


        // Make sure we don't fail because we try to start an
        // already started server
        try {
            server.startServer(true);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    @AfterClass
    public static void tearDown() throws Exception {
        server.stopServer("SRVE9967W");
    }

    @Before
    public void preTest() {
        serverRef = server;
    }

    @After
    public void afterTest() {
        serverRef = null;
    }

    @Test
    public void testObservableRxInvoker_get1() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testObservableRxInvoker_get1", p, "Good book");
    }

    @Test
    public void testFlowableRxInvoker_get1() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testFlowableRxInvoker_get1", p, "Good book");
    }

    @Test
    public void testObservableRxInvoker_get2WithClass() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testObservableRxInvoker_get2WithClass", p, "Good book");
    }

    @Test
    public void testFlowableRxInvoker_get2WithClass() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testFlowableRxInvoker_get2WithClass", p, "Good book");
    }

    @Test
    public void testObservableRxInvoker_get3WithGenericType() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testObservableRxInvoker_get3WithGenericType", p, "true");
    }

    @Test
    public void testFlowableRxInvoker_get3WithGenericType() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testFlowableRxInvoker_get3WithGenericType", p, "true");
    }

    @Test
    public void testObservableRxInvoker_get5WithZip() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testObservableRxInvoker_get5WithZip", p, "Good book");
    }

    @Test
    public void testFlowableRxInvoker_get5WithZip() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testFlowableRxInvoker_get5WithZip", p, "Good book");
    }

    @Test
    public void testObservableRxInvoker_post1() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testObservableRxInvoker_post1", p, "Test book");
    }

    @Test
    public void testFlowableRxInvoker_post1() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testFlowableRxInvoker_post1", p, "Test book");
    }

    @Test
    public void testObservableRxInvoker_post2WithClass() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testObservableRxInvoker_post2WithClass", p, "Test book2");
    }

    @Test
    public void testFlowableRxInvoker_post2WithClass() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testFlowableRxInvoker_post2WithClass", p, "Test book2");
    }

    @Test
    public void testObservableRxInvoker_post3WithGenericType() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testObservableRxInvoker_post3WithGenericType", p, "Test book3");
    }

    @Test
    public void testFlowableRxInvoker_post3WithGenericType() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testFlowableRxInvoker_post3WithGenericType", p, "Test book3");
    }

    @Test
    public void testObservableRxInvoker_post5WithZip() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testObservableRxInvoker_post5WithZip", p, "Test book6");
    }

    @Test
    public void testFlowableRxInvoker_post5WithZip() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testFlowableRxInvoker_post5WithZip", p, "Test book6");
    }

    @Test
    public void testObservableRxInvokerOnError() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testObservableRxInvokerOnError", p, "true");
    }

    @Test
    public void testFlowableRxInvokerOnError() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testFlowableRxInvokerOnError", p, "true");
    }

    @Test
    public void testObservableRxInvoker_getCbReceiveTimeout() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testObservableRxInvoker_getCbReceiveTimeout", p, "Timeout as expected");
    }

    @Test
    public void testObservableRxInvoker_getIbmReceiveTimeout() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testObservableRxInvoker_getIbmReceiveTimeout", p, "Timeout as expected");
    }

    @Test
    public void testFlowableRxInvoker_getCbReceiveTimeout() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testFlowableRxInvoker_getCbReceiveTimeout", p, "Timeout as expected");
    }

    @Test
    public void testFlowableRxInvoker_getIbmReceiveTimeout() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testFlowableRxInvoker_getIbmReceiveTimeout", p, "Timeout as expected");
    }

    @Test
    public void testObservableRxInvoker_getCbConnectionTimeout() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testObservableRxInvoker_getCbConnectionTimeout", p, "Timeout as expected");
    }

    @Test
    public void testObservableRxInvoker_getIbmConnectionTimeout() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testObservableRxInvoker_getIbmConnectionTimeout", p, "Timeout as expected");
    }

    @Test
    public void testFlowableRxInvoker_getCbConnectionTimeout() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testFlowableRxInvoker_getCbConnectionTimeout", p, "Timeout as expected");
    }

    @Test
    public void testFlowableRxInvoker_getIbmConnectionTimeout() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testFlowableRxInvoker_getIbmConnectionTimeout", p, "Timeout as expected");
    }

    @Test
    public void testObservableRxInvoker_postCbReceiveTimeout() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testObservableRxInvoker_postCbReceiveTimeout", p, "Timeout as expected");
    }

    @Test
    public void testObservableRxInvoker_postIbmReceiveTimeout() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testObservableRxInvoker_postIbmReceiveTimeout", p, "Timeout as expected");
    }

    @Test
    public void testFlowableRxInvoker_postCbReceiveTimeout() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testFlowableRxInvoker_postCbReceiveTimeout", p, "Timeout as expected");
    }

    @Test
    public void testFlowableRxInvoker_postIbmReceiveTimeout() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testFlowableRxInvoker_postIbmReceiveTimeout", p, "Timeout as expected");
    }

    @Test
    public void testObservableRxInvoker_postCbConnectionTimeout() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testObservableRxInvoker_postCbConnectionTimeout", p, "Timeout as expected");
    }

    @Test
    public void testObservableRxInvoker_postIbmConnectionTimeout() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testObservableRxInvoker_postIbmConnectionTimeout", p, "Timeout as expected");
    }

    @Test
    public void testFlowableRxInvoker_postCbConnectionTimeout() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testFlowableRxInvoker_postCbConnectionTimeout", p, "Timeout as expected");
    }

    @Test
    public void testFlowableRxInvoker_postIbmConnectionTimeout() throws Exception {
        Map<String, String> p = new HashMap<String, String>();
        this.runTestOnServer(cxfRxInvokerTarget, "testFlowableRxInvoker_postIbmConnectionTimeout", p, "Timeout as expected");
    }
}
