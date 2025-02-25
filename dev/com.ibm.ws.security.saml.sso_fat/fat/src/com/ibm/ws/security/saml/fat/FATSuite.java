/*******************************************************************************
 * Copyright (c) 2014, 2022 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.security.saml.fat;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ibm.ws.security.fat.common.actions.SecurityTestFeatureEE9RepeatAction;
import com.ibm.ws.security.fat.common.actions.SecurityTestRepeatAction;
import com.ibm.ws.security.saml.fat.IDPInitiated.BasicIDPInitiatedTests;
import com.ibm.ws.security.saml.fat.SPInitiated.BasicSolicitedSPInitiatedTests;
import com.ibm.ws.security.saml.fat.SPInitiated.BasicUnsolicitedSPInitiatedTests;

import componenttest.rules.repeater.EmptyAction;
import componenttest.rules.repeater.RepeatTests;

@RunWith(Suite.class)
@SuiteClasses({

                BasicIDPInitiatedTests.class,
                BasicSolicitedSPInitiatedTests.class,
                BasicUnsolicitedSPInitiatedTests.class

})
public class FATSuite {
    /*
     * Run EE9 tests in LITE mode and run all tests in FULL mode.
     */
    @ClassRule
    public static RepeatTests repeat = RepeatTests.with(new EmptyAction().liteFATOnly())
                    .andWith(new SecurityTestRepeatAction().onlyOnWindows().fullFATOnly())
                    .andWith(new SecurityTestFeatureEE9RepeatAction().notOnWindows().fullFATOnly());

    @BeforeClass
    public static void setup() throws Exception {
/*
 * Force the tests to use local LDAP server
 */
        System.setProperty("fat.test.really.use.local.ldap", "true");
    }

}
