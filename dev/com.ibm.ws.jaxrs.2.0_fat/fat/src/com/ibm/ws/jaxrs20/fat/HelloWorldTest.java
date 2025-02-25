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
package com.ibm.ws.jaxrs20.fat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.ibm.websphere.simplicity.ShrinkHelper;

import componenttest.annotation.Server;
import componenttest.custom.junit.runner.FATRunner;
import componenttest.rules.repeater.JakartaEE10Action;
import componenttest.rules.repeater.JakartaEE9Action;
import componenttest.topology.impl.LibertyServer;

@RunWith(FATRunner.class)
public class HelloWorldTest {

    @Server("com.ibm.ws.jaxrs.fat.helloworld")
    public static LibertyServer server;

    private static final String hellowar = "helloworld";

    @BeforeClass
    public static void setUp() throws Exception {
        ShrinkHelper.defaultDropinApp(server, hellowar, "com.ibm.ws.jaxrs.fat.helloworld");

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
        if (server != null) {
            server.stopServer("SRVE0315E", "SRVE0777E");
        }
    }

    private int getPort() {
        return server.getHttpDefaultPort();
    }

    private String getHost() {
        return server.getHostname();
    }

    @Test
    public void testSimple() throws IOException {
        runGetMethod(200, "/helloworld/rest/helloworld", "Hello World");
    }

    @Test
    public void testSimpleRegEx() throws IOException {
        // This test was added for issue 11893:  A Path containing a regex encased in parenthese
        // would result in extraneous values being generated by the Matcher.
        runGetMethod(200, "/helloworld/rest/helloworld/1234567t/test", "Hello World!:1234567t:test");
        runGetMethod(200, "/helloworld/rest/helloworld/1234567890e/test", "Hello World!:1234567890e:test");
        assertEquals(404, runGetMethodInvalidPath("/helloworld/rest/helloworld/123456t/test"));

    }

    /**
     * Tests that JAX-RS engine can map a request URL containing encoded
     * and non-encoded characters to the proper target destination
     *
     * @throws IOException
     */
    @Test
    public void testSimpleWithEncodedURL() throws IOException {
        runGetMethod(200, "/helloworld/apppathrest!/helloworld", "Hello World");
        runGetMethod(200, "/helloworld/apppathrest%21/helloworld", "Hello World");
    }

    @Test
    public void testInvalidCharset() throws Exception {
        int status = runPostMethodInvalidCharset("/helloworld/rest/helloworld");
        // the spec doesn't mention charsets in terms of matching to resources...
        // RESTEasy says an invalid charset is a client error, and returns 400
        // CXF says it doesn't match any resource methods and returns 415
        if (JakartaEE9Action.isActive()) {
            assertEquals(400, status);
        } else {
            // The 3.1 specification introduces a defaultExceptionmapper with the following:
            // "A JAX-RS implementation MUST include a default exception mapping provider that
            // implements ExceptionMapper<Throwable> and which SHOULD set the response status to 500."
            if (JakartaEE10Action.isActive()) {
                assertEquals(500, status);
            } else {
                assertEquals(415, status);
            }
        }
    }

    private StringBuilder runGetMethod(int exprc, String requestUri, String testOut)
                    throws IOException {
        URL url = new URL("http://" + getHost() + ":" + getPort() + requestUri);
        int retcode;
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        try {
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setUseCaches(false);
            con.setRequestMethod("GET");

            retcode = con.getResponseCode();

            InputStream is = con.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String sep = System.getProperty("line.separator");
            StringBuilder lines = new StringBuilder();
            for (String line = br.readLine(); line != null; line = br
                            .readLine())
                lines.append(line).append(sep);

            if (lines.indexOf(testOut) < 0)
                fail("Missing success message in output. " + lines);

            if (retcode != exprc)
                fail("Bad return Code from Get. Expected " + exprc + "Got"
                     + retcode);

            return lines;
        } finally {
            con.disconnect();
        }
    }
    private int runGetMethodInvalidPath(String requestUri)
                    throws IOException {
        URL url = new URL("http://" + getHost() + ":" + getPort() + requestUri);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        try {
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setUseCaches(false);
            con.setRequestMethod("GET");

            return con.getResponseCode();
        } finally {
            con.disconnect();
        }
    }

    private int runPostMethodInvalidCharset(String requestUri)
                    throws IOException {
        URL url = new URL("http://" + getHost() + ":" + getPort() + requestUri);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        try {
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setUseCaches(false);
            con.setRequestProperty("Content-Type", "text/plain; charset=invalid");
            con.setRequestMethod("POST");
            con.getOutputStream().write("Hello World!".getBytes());

            return con.getResponseCode();
        } finally {
            con.disconnect();
        }
    }

}