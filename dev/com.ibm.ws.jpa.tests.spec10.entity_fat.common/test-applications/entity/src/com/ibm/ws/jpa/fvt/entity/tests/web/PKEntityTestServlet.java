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

import com.ibm.ws.jpa.fvt.entity.testlogic.PKEntityTestLogic;
import com.ibm.ws.testtooling.testinfo.JPAPersistenceContext;
import com.ibm.ws.testtooling.testinfo.JPAPersistenceContext.PersistenceContextType;
import com.ibm.ws.testtooling.testinfo.JPAPersistenceContext.PersistenceInjectionType;
import com.ibm.ws.testtooling.vehicle.web.JPADBTestServlet;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/PKEntityTestServlet")
public class PKEntityTestServlet extends JPADBTestServlet {
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
        testClassName = PKEntityTestLogic.class.getName();

        jpaPctxMap.put("test-jpa-resource-amjta",
                       new JPAPersistenceContext("test-jpa-resource-amjta", PersistenceContextType.APPLICATION_MANAGED_JTA, PersistenceInjectionType.FIELD, "amjtaEmf"));
        jpaPctxMap.put("test-jpa-resource-amrl",
                       new JPAPersistenceContext("test-jpa-resource-amrl", PersistenceContextType.APPLICATION_MANAGED_RL, PersistenceInjectionType.FIELD, "amrlEmf"));
        jpaPctxMap.put("test-jpa-resource-cmts",
                       new JPAPersistenceContext("test-jpa-resource-cmts", PersistenceContextType.CONTAINER_MANAGED_TS, PersistenceInjectionType.FIELD, "cmtsEm"));
    }

    @Test
    public void jpa10_Entity_PKEntity_Byte_Ano_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_Byte_Ano_AMJTA_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityByte");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_Byte_XML_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_Byte_XML_AMJTA_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityByte");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_Byte_Ano_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_Byte_Ano_AMRL_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityByte");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_Byte_XML_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_Byte_XML_AMRL_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityByte");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_Byte_Ano_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_Byte_Ano_CMTS_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityByte");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_Byte_XML_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_Byte_XML_CMTS_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityByte");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_ByteWrapper_Ano_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_ByteWrapper_Ano_AMJTA_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityByteWrapper");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_ByteWrapper_XML_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_ByteWrapper_XML_AMJTA_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityByteWrapper");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_ByteWrapper_Ano_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_ByteWrapper_Ano_AMRL_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityByteWrapper");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_ByteWrapper_XML_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_ByteWrapper_XML_AMRL_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityByteWrapper");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_ByteWrapper_Ano_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_ByteWrapper_Ano_CMTS_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityByteWrapper");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_ByteWrapper_XML_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_ByteWrapper_XML_CMTS_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityByteWrapper");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_Char_Ano_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_Char_Ano_AMJTA_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityChar");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_Char_XML_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_Char_XML_AMJTA_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityChar");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_Char_Ano_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_Char_Ano_AMRL_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityChar");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_Char_XML_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_Char_XML_AMRL_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityChar");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_Char_Ano_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_Char_Ano_CMTS_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityChar");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_Char_XML_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_Char_XML_CMTS_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityChar");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_CharWrapper_Ano_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_CharWrapper_Ano_AMJTA_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityCharWrapper");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_CharWrapper_XML_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_CharWrapper_XML_AMJTA_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityCharWrapper");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_CharWrapper_Ano_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_CharWrapper_Ano_AMRL_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityCharWrapper");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_CharWrapper_XML_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_CharWrapper_XML_AMRL_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityCharWrapper");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_CharWrapper_Ano_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_CharWrapper_Ano_CMTS_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityCharWrapper");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_CharWrapper_XML_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_CharWrapper_XML_CMTS_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityCharWrapper");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_Int_Ano_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_Int_Ano_AMJTA_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityInt");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_Int_XML_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_Int_XML_AMJTA_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityInt");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_Int_Ano_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_Int_Ano_AMRL_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityInt");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_Int_XML_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_Int_XML_AMRL_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityInt");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_Int_Ano_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_Int_Ano_CMTS_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityInt");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_Int_XML_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_Int_XML_CMTS_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityInt");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_IntWrapper_Ano_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_IntWrapper_Ano_AMJTA_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityIntWrapper");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_IntWrapper_XML_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_IntWrapper_XML_AMJTA_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityIntWrapper");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_IntWrapper_Ano_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_IntWrapper_Ano_AMRL_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityIntWrapper");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_IntWrapper_XML_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_IntWrapper_XML_AMRL_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityIntWrapper");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_IntWrapper_Ano_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_IntWrapper_Ano_CMTS_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityIntWrapper");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_IntWrapper_XML_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_IntWrapper_XML_CMTS_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityIntWrapper");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_Long_Ano_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_Long_Ano_AMJTA_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityLong");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_Long_XML_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_Long_XML_AMJTA_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityLong");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_Long_Ano_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_Long_Ano_AMRL_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityLong");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_Long_XML_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_Long_XML_AMRL_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityLong");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_Long_Ano_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_Long_Ano_CMTS_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityLong");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_Long_XML_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_Long_XML_CMTS_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityLong");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_LongWrapper_Ano_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_LongWrapper_Ano_AMJTA_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityLongWrapper");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_LongWrapper_XML_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_LongWrapper_XML_AMJTA_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityLongWrapper");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_LongWrapper_Ano_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_LongWrapper_Ano_AMRL_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityLongWrapper");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_LongWrapper_XML_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_LongWrapper_XML_AMRL_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityLongWrapper");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_LongWrapper_Ano_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_LongWrapper_Ano_CMTS_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityLongWrapper");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_LongWrapper_XML_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_LongWrapper_XML_CMTS_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityLongWrapper");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_Short_Ano_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_Short_Ano_AMJTA_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityShort");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_Short_XML_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_Short_XML_AMJTA_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityShort");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_Short_Ano_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_Short_Ano_AMRL_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityShort");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_Short_XML_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_Short_XML_AMRL_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityShort");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_Short_Ano_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_Short_Ano_CMTS_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityShort");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_Short_XML_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_Short_XML_CMTS_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityShort");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_ShortWrapper_Ano_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_ShortWrapper_Ano_AMJTA_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityShortWrapper");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_ShortWrapper_XML_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_ShortWrapper_XML_AMJTA_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityShortWrapper");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_ShortWrapper_Ano_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_ShortWrapper_Ano_AMRL_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityShortWrapper");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_ShortWrapper_XML_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_ShortWrapper_XML_AMRL_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityShortWrapper");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_ShortWrapper_Ano_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_ShortWrapper_Ano_CMTS_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityShortWrapper");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_ShortWrapper_XML_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_ShortWrapper_XML_CMTS_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityShortWrapper");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_String_Ano_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_String_Ano_AMJTA_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityString");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_String_XML_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_String_XML_AMJTA_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityString");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_String_Ano_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_String_Ano_AMRL_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityString");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_String_XML_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_String_XML_AMRL_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityString");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_String_Ano_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_String_Ano_CMTS_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityString");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_String_XML_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_String_XML_CMTS_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityString");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_JavaSqlDate_Ano_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_JavaSqlDate_Ano_AMJTA_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityJavaSqlDate");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_JavaSqlDate_XML_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_JavaSqlDate_XML_AMJTA_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityJavaSqlDate");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_JavaSqlDate_Ano_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_JavaSqlDate_Ano_AMRL_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityJavaSqlDate");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_JavaSqlDate_XML_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_JavaSqlDate_XML_AMRL_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityJavaSqlDate");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_JavaSqlDate_Ano_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_JavaSqlDate_Ano_CMTS_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityJavaSqlDate");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_JavaSqlDate_XML_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_JavaSqlDate_XML_CMTS_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityJavaSqlDate");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_JavaUtilDate_Ano_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_JavaUtilDate_Ano_AMJTA_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityJavaUtilDate");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_JavaUtilDate_XML_AMJTA_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_JavaUtilDate_XML_AMJTA_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amjta";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityJavaUtilDate");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_JavaUtilDate_Ano_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_JavaUtilDate_Ano_AMRL_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityJavaUtilDate");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_JavaUtilDate_XML_AMRL_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_JavaUtilDate_XML_AMRL_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-amrl";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityJavaUtilDate");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_JavaUtilDate_Ano_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_JavaUtilDate_Ano_CMTS_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "PKEntityJavaUtilDate");

        executeTest(testName, testMethod, testResource, properties);
    }

    @Test
    public void jpa10_Entity_PKEntity_JavaUtilDate_XML_CMTS_Web() throws Exception {
        final String testName = "jpa10_Entity_PKEntity_JavaUtilDate_XML_CMTS_Web";
        final String testMethod = "testPKEntity001";
        final String testResource = "test-jpa-resource-cmts";

        HashMap<String, java.io.Serializable> properties = new HashMap<String, java.io.Serializable>();
        properties.put("EntityName", "XMLPKEntityJavaUtilDate");

        executeTest(testName, testMethod, testResource, properties);
    }

}
