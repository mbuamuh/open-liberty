/*******************************************************************************
 * Copyright (c) 2022 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ws.security.backchannelLogout.fat;

import org.junit.ClassRule;
import org.junit.runner.RunWith;

import com.ibm.ws.security.fat.common.actions.SecurityTestRepeatAction;
import com.ibm.ws.security.oauth_oidc.fat.commonTest.Constants;

import componenttest.annotation.AllowedFFDC;
import componenttest.custom.junit.runner.FATRunner;
import componenttest.custom.junit.runner.Mode;
import componenttest.custom.junit.runner.Mode.TestMode;
import componenttest.rules.repeater.RepeatTests;
import componenttest.topology.impl.LibertyServerWrapper;

/**
 * This is the test class that will run tests to validate the proper behavior when
 * various http methods are used wit the back channel logout enddpoint.
 * This instance of the tests will run with the OIDC back channel logout endpoints
 *
 **/

@RunWith(FATRunner.class)
@LibertyServerWrapper
@Mode(TestMode.FULL)
@AllowedFFDC({ "org.apache.http.NoHttpResponseException" })
public class HttpMethodsTests extends com.ibm.ws.security.backchannelLogout.fat.CommonTests.HttpMethodsTests {

    // Repeat tests using the OIDC endpoints
    @ClassRule
    public static RepeatTests repeat = RepeatTests.with(new SecurityTestRepeatAction(Constants.OIDC));

}
