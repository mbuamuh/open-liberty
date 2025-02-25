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

package com.ibm.ws.jpa.fvt.entity.tests.web;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.servlet.annotation.WebServlet;

import org.junit.Test;

import com.ibm.ws.jpa.fvt.entity.testlogic.PKGeneratorTestLogic;
import com.ibm.ws.testtooling.testinfo.JPAPersistenceContext;
import com.ibm.ws.testtooling.testinfo.JPAPersistenceContext.PersistenceContextType;
import com.ibm.ws.testtooling.testinfo.JPAPersistenceContext.PersistenceInjectionType;
import com.ibm.ws.testtooling.vehicle.web.JPADBTestServlet;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/PKGeneratorTestServlet")
public class PKGeneratorTestServlet extends JPADBTestServlet {
    // Container Managed Transaction Scope
    @PersistenceContext(unitName = "ENTITY_JTA")
    private EntityManager cmtsEm;

    // Application Managed JTA
    @PersistenceUnit(unitName = "ENTITY_JTA")
    private EntityManagerFactory amjtaEmf;

    // Application Managed Resource-Local
    @PersistenceUnit(unitName = "ENTITY_RL")
    private EntityManagerFactory amrlEmf;

    @PostConstruct
    private void initFAT() {
        testClassName = PKGeneratorTestLogic.class.getName();

        jpaPctxMap.put("test-jpa-resource-amjta",
                       new JPAPersistenceContext("test-jpa-resource-amjta", PersistenceContextType.APPLICATION_MANAGED_JTA, PersistenceInjectionType.FIELD, "amjtaEmf"));
        jpaPctxMap.put("test-jpa-resource-amrl",
                       new JPAPersistenceContext("test-jpa-resource-amrl", PersistenceContextType.APPLICATION_MANAGED_RL, PersistenceInjectionType.FIELD, "amrlEmf"));
        jpaPctxMap.put("test-jpa-resource-cmts",
                       new JPAPersistenceContext("test-jpa-resource-cmts", PersistenceContextType.CONTAINER_MANAGED_TS, PersistenceInjectionType.FIELD, "cmtsEm"));
    }

    @Test
    public void jpa10_Entity_PKGenerator_Auto_Ano_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_Auto_Ano_AMJTA_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKGenAutoEntity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_Auto_XML_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_Auto_XML_AMJTA_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKGenAutoEntity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_Auto_Ano_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_Auto_Ano_AMRL_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKGenAutoEntity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_Auto_XML_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_Auto_XML_AMRL_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKGenAutoEntity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_Auto_Ano_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_Auto_Ano_CMTS_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKGenAutoEntity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_Auto_XML_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_Auto_XML_CMTS_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKGenAutoEntity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_Identity_Ano_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_Identity_Ano_AMJTA_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKGenIdentityEntity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_Identity_XML_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_Identity_XML_AMJTA_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKGenIdentityEntity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_Identity_Ano_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_Identity_Ano_AMRL_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKGenIdentityEntity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_Identity_XML_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_Identity_XML_AMRL_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKGenIdentityEntity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_Identity_Ano_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_Identity_Ano_CMTS_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKGenIdentityEntity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_Identity_XML_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_Identity_XML_CMTS_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKGenIdentityEntity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_TableType1_Ano_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_TableType1_Ano_AMJTA_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKGenTableType1Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_TableType1_XML_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_TableType1_XML_AMJTA_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKGenTableType1Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_TableType1_Ano_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_TableType1_Ano_AMRL_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKGenTableType1Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_TableType1_XML_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_TableType1_XML_AMRL_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKGenTableType1Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_TableType1_Ano_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_TableType1_Ano_CMTS_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKGenTableType1Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_TableType1_XML_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_TableType1_XML_CMTS_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKGenTableType1Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_TableType2_Ano_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_TableType2_Ano_AMJTA_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKGenTableType2Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_TableType2_XML_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_TableType2_XML_AMJTA_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKGenTableType2Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_TableType2_Ano_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_TableType2_Ano_AMRL_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKGenTableType2Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_TableType2_XML_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_TableType2_XML_AMRL_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKGenTableType2Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_TableType2_Ano_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_TableType2_Ano_CMTS_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKGenTableType2Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_TableType2_XML_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_TableType2_XML_CMTS_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKGenTableType2Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_TableType3_Ano_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_TableType3_Ano_AMJTA_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKGenTableType3Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_TableType3_XML_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_TableType3_XML_AMJTA_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKGenTableType3Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_TableType3_Ano_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_TableType3_Ano_AMRL_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKGenTableType3Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_TableType3_XML_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_TableType3_XML_AMRL_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKGenTableType3Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_TableType3_Ano_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_TableType3_Ano_CMTS_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKGenTableType3Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_TableType3_XML_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_TableType3_XML_CMTS_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKGenTableType3Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_TableType4_Ano_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_TableType4_Ano_AMJTA_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKGenTableType4Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_TableType4_XML_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_TableType4_XML_AMJTA_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKGenTableType4Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_TableType4_Ano_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_TableType4_Ano_AMRL_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKGenTableType4Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_TableType4_XML_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_TableType4_XML_AMRL_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKGenTableType4Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_TableType4_Ano_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_TableType4_Ano_CMTS_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKGenTableType4Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKGenerator_TableType4_XML_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_TableType4_XML_CMTS_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKGenTableType4Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

//    @Test
    public void jpa10_Entity_PKGenerator_SequenceType1_Ano_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_SequenceType1_Ano_AMJTA_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-amjta";

        if (getDbProductName().toLowerCase().contains("derby")) {
            // Derby doesn't support sequences, so do not run.
            return;
        }

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKGenSequenceType1Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

//    @Test
    public void jpa10_Entity_PKGenerator_SequenceType1_XML_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_SequenceType1_XML_AMJTA_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-amjta";

        if (getDbProductName().toLowerCase().contains("derby")) {
            // Derby doesn't support sequences, so do not run.
            return;
        }

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKGenSequenceType1Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

//    @Test
    public void jpa10_Entity_PKGenerator_SequenceType1_Ano_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_SequenceType1_Ano_AMRL_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-amrl";

        if (getDbProductName().toLowerCase().contains("derby")) {
            // Derby doesn't support sequences, so do not run.
            return;
        }

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKGenSequenceType1Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

//    @Test
    public void jpa10_Entity_PKGenerator_SequenceType1_XML_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_SequenceType1_XML_AMRL_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-amrl";

        if (getDbProductName().toLowerCase().contains("derby")) {
            // Derby doesn't support sequences, so do not run.
            return;
        }

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKGenSequenceType1Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

//    @Test
    public void jpa10_Entity_PKGenerator_SequenceType1_Ano_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_SequenceType1_Ano_CMTS_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-cmts";

        if (getDbProductName().toLowerCase().contains("derby")) {
            // Derby doesn't support sequences, so do not run.
            return;
        }

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKGenSequenceType1Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

//    @Test
    public void jpa10_Entity_PKGenerator_SequenceType1_XML_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_SequenceType1_XML_CMTS_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-cmts";

        if (getDbProductName().toLowerCase().contains("derby")) {
            // Derby doesn't support sequences, so do not run.
            return;
        }

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKGenSequenceType1Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

//    @Test
    public void jpa10_Entity_PKGenerator_SequenceType2_Ano_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_SequenceType2_Ano_AMJTA_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-amjta";

        if (getDbProductName().toLowerCase().contains("derby")) {
            // Derby doesn't support sequences, so do not run.
            return;
        }

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKGenSequenceType2Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

//    @Test
    public void jpa10_Entity_PKGenerator_SequenceType2_XML_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_SequenceType2_XML_AMJTA_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-amjta";

        if (getDbProductName().toLowerCase().contains("derby")) {
            // Derby doesn't support sequences, so do not run.
            return;
        }

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKGenSequenceType2Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

//    @Test
    public void jpa10_Entity_PKGenerator_SequenceType2_Ano_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_SequenceType2_Ano_AMRL_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-amrl";

        if (getDbProductName().toLowerCase().contains("derby")) {
            // Derby doesn't support sequences, so do not run.
            return;
        }

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKGenSequenceType2Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

//    @Test
    public void jpa10_Entity_PKGenerator_SequenceType2_XML_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_SequenceType2_XML_AMRL_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-amrl";

        if (getDbProductName().toLowerCase().contains("derby")) {
            // Derby doesn't support sequences, so do not run.
            return;
        }

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKGenSequenceType2Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

//    @Test
    public void jpa10_Entity_PKGenerator_SequenceType2_Ano_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_SequenceType2_Ano_CMTS_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-cmts";

        if (getDbProductName().toLowerCase().contains("derby")) {
            // Derby doesn't support sequences, so do not run.
            return;
        }

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKGenSequenceType2Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

//    @Test
    public void jpa10_Entity_PKGenerator_SequenceType2_XML_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKGenerator_SequenceType2_XML_CMTS_Web";
        final String testMethod = "testPKGenerator001";
        final String testResource = "test-jpa-resource-cmts";

        if (getDbProductName().toLowerCase().contains("derby")) {
            // Derby doesn't support sequences, so do not run.
            return;
        }

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKGenSequenceType2Entity");

        executeTest(testName, testMethod, testResource, properties);
    }

}
