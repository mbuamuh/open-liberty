/*******************************************************************************
 * Copyright (c) 2019 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ws.jpa.olgh8294.ejb;

import javax.annotation.PostConstruct;
import javax.servlet.annotation.WebServlet;

import org.junit.Test;

import com.ibm.ws.jpa.olgh8294.testlogic.JPATestOLGH8294Logic;
import com.ibm.ws.testtooling.testinfo.JPAPersistenceContext;
import com.ibm.ws.testtooling.testinfo.JPAPersistenceContext.PersistenceContextType;
import com.ibm.ws.testtooling.testinfo.JPAPersistenceContext.PersistenceInjectionType;
import com.ibm.ws.testtooling.vehicle.web.EJBDBTestVehicleServlet;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/TestOLGH8294_EJB_SFEx_Servlet")
public class TestOLGH8294_EJB_SFEx_Servlet extends EJBDBTestVehicleServlet {

    @PostConstruct
    private void initFAT() {
        testClassName = JPATestOLGH8294Logic.class.getName();
        ejbJNDIName = "ejb/OLGH8294SFExEJB";

        jpaPctxMap.put("test-jpa-resource-cmex",
                       new JPAPersistenceContext("test-jpa-resource-cmex", PersistenceContextType.CONTAINER_MANAGED_ES, PersistenceInjectionType.JNDI, "java:comp/env/jpa/OLGH8294_CMEX"));
    }

    @Test
    public void jpa_eclipselink_testCOALESCE_EJB_SFEx_CMTS_Web() throws Exception {
        final String testName = "jpa_eclipselink_testCOALESCE_EJB_SFEx_CMTS_Web";
        final String testMethod = "testCOALESCE_ForceBindJPQLParameters";
        final String testResource = "test-jpa-resource-cmex";
        executeTest(testName, testMethod, testResource);
    }

    @Test
    public void jpa_eclipselink_testABS_EJB_SFEx_CMTS_Web() throws Exception {
        final String testName = "jpa_eclipselink_testABS_EJB_SFEx_CMTS_Web";
        final String testMethod = "testABS_ForceBindJPQLParameters";
        final String testResource = "test-jpa-resource-cmex";
        executeTest(testName, testMethod, testResource);
    }

    @Test
    public void jpa_eclipselink_testCONCAT_EJB_SFEx_CMTS_Web() throws Exception {
        final String testName = "jpa_eclipselink_testCONCAT_EJB_SFEx_CMTS_Web";
        final String testMethod = "testCONCAT_ForceBindJPQLParameters";
        final String testResource = "test-jpa-resource-cmex";
        executeTest(testName, testMethod, testResource);
    }

    @Test
    public void jpa_eclipselink_testEXISTS_EJB_SFEx_CMTS_Web() throws Exception {
        final String testName = "jpa_eclipselink_testEXISTS_EJB_SFEx_CMTS_Web";
        final String testMethod = "testEXISTS_ForceBindJPQLParameters";
        final String testResource = "test-jpa-resource-cmex";
        executeTest(testName, testMethod, testResource);
    }

    @Test
    public void jpa_eclipselink_testNUMERICALEXPRESSION_EJB_SFEx_CMTS_Web() throws Exception {
        final String testName = "jpa_eclipselink_testNUMERICALEXPRESSION_EJB_SFEx_CMTS_Web";
        final String testMethod = "testNUMERICALEXPRESSION_ForceBindJPQLParameters";
        final String testResource = "test-jpa-resource-cmex";
        executeTest(testName, testMethod, testResource);
    }

    @Test
    public void jpa_eclipselink_testIN_EJB_SFEx_CMTS_Web() throws Exception {
        final String testName = "jpa_eclipselink_testIN_EJB_SFEx_CMTS_Web";
        final String testMethod = "testIN_ForceBindJPQLParameters";
        final String testResource = "test-jpa-resource-cmex";
        executeTest(testName, testMethod, testResource);
    }

    @Test
    public void jpa_eclipselink_testLIKE_EJB_SFEx_CMTS_Web() throws Exception {
        final String testName = "jpa_eclipselink_testLIKE_EJB_SFEx_CMTS_Web";
        final String testMethod = "testLIKE_ForceBindJPQLParameters";
        final String testResource = "test-jpa-resource-cmex";
        executeTest(testName, testMethod, testResource);
    }

    @Test
    public void jpa_eclipselink_testSUBSTR_EJB_SFEx_CMTS_Web() throws Exception {
        final String testName = "jpa_eclipselink_testSUBSTR_EJB_SFEx_CMTS_Web";
        final String testMethod = "testSUBSTR_ForceBindJPQLParameters";
        final String testResource = "test-jpa-resource-cmex";
        executeTest(testName, testMethod, testResource);
    }
}
