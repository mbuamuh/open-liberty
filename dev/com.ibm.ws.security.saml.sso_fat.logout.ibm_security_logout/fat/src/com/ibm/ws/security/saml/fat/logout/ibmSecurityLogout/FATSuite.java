/*******************************************************************************
 * Copyright (c) 2018, 2022 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.security.saml.fat.logout.ibmSecurityLogout;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ibm.ws.security.fat.common.AlwaysRunAndPassTest;
import com.ibm.ws.security.fat.common.actions.SecurityTestFeatureEE9RepeatAction;
import com.ibm.ws.security.fat.common.actions.SecurityTestRepeatAction;
import com.ibm.ws.security.saml.fat.logout.IDPInitiated_Login.IDPInitiatedLogin_ibmSecurityLogout_spLogoutFalse_LTPA_Tests;
import com.ibm.ws.security.saml.fat.logout.IDPInitiated_Login.IDPInitiatedLogin_ibmSecurityLogout_spLogoutFalse_Tests;
import com.ibm.ws.security.saml.fat.logout.IDPInitiated_Login.IDPInitiatedLogin_ibmSecurityLogout_spLogoutTrue_LTPA_Tests;
import com.ibm.ws.security.saml.fat.logout.IDPInitiated_Login.IDPInitiatedLogin_ibmSecurityLogout_spLogoutTrue_Tests;
import com.ibm.ws.security.saml.fat.logout.SPInitiated_Login.SolicitedSPInitiatedLogin_ibmSecurityLogout_spLogoutFalse_LTPA_Tests;
import com.ibm.ws.security.saml.fat.logout.SPInitiated_Login.SolicitedSPInitiatedLogin_ibmSecurityLogout_spLogoutFalse_Tests;
import com.ibm.ws.security.saml.fat.logout.SPInitiated_Login.SolicitedSPInitiatedLogin_ibmSecurityLogout_spLogoutTrue_LTPA_Tests;
import com.ibm.ws.security.saml.fat.logout.SPInitiated_Login.SolicitedSPInitiatedLogin_ibmSecurityLogout_spLogoutTrue_Tests;
import com.ibm.ws.security.saml.fat.logout.SPInitiated_Login.UnsolicitedSPInitiatedLogin_ibmSecurityLogout_spLogoutFalse_LTPA_Tests;
import com.ibm.ws.security.saml.fat.logout.SPInitiated_Login.UnsolicitedSPInitiatedLogin_ibmSecurityLogout_spLogoutFalse_Tests;
import com.ibm.ws.security.saml.fat.logout.SPInitiated_Login.UnsolicitedSPInitiatedLogin_ibmSecurityLogout_spLogoutTrue_LTPA_Tests;
import com.ibm.ws.security.saml.fat.logout.SPInitiated_Login.UnsolicitedSPInitiatedLogin_ibmSecurityLogout_spLogoutTrue_Tests;

import componenttest.rules.repeater.EmptyAction;
import componenttest.rules.repeater.RepeatTests;

/**
 * Collection of all SAML logout related tests, including SAML Single Logout.
 */
@RunWith(Suite.class)
@SuiteClasses({
        AlwaysRunAndPassTest.class,
        // login using each of the 3 flows, use ibm_security_logout with spLogout set to false (implying that we'll just logout locally)
        // SP Cookie
        IDPInitiatedLogin_ibmSecurityLogout_spLogoutFalse_Tests.class,
        SolicitedSPInitiatedLogin_ibmSecurityLogout_spLogoutFalse_Tests.class,
        UnsolicitedSPInitiatedLogin_ibmSecurityLogout_spLogoutFalse_Tests.class,

        // login using each of the 3 flows, use ibm_security_logout with spLogout set to true (implying that we'll also call out to the IDP)
        // SP Cookie
        IDPInitiatedLogin_ibmSecurityLogout_spLogoutTrue_Tests.class,
        SolicitedSPInitiatedLogin_ibmSecurityLogout_spLogoutTrue_Tests.class,
        UnsolicitedSPInitiatedLogin_ibmSecurityLogout_spLogoutTrue_Tests.class,

        // login using each of the 3 flows, use ibm_security_logout with spLogout set to false (implying that we'll just logout locally)
        // LTPA Token/Cookie
        IDPInitiatedLogin_ibmSecurityLogout_spLogoutFalse_LTPA_Tests.class,
        SolicitedSPInitiatedLogin_ibmSecurityLogout_spLogoutFalse_LTPA_Tests.class,
        UnsolicitedSPInitiatedLogin_ibmSecurityLogout_spLogoutFalse_LTPA_Tests.class,

        // login using each of the 3 flows, use ibm_security_logout with spLogout set to true (implying that we'll also call out to the IDP)
        // LTPA Token/Cookie
        IDPInitiatedLogin_ibmSecurityLogout_spLogoutTrue_LTPA_Tests.class,
        SolicitedSPInitiatedLogin_ibmSecurityLogout_spLogoutTrue_LTPA_Tests.class,
        UnsolicitedSPInitiatedLogin_ibmSecurityLogout_spLogoutTrue_LTPA_Tests.class,

})
public class FATSuite {

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
