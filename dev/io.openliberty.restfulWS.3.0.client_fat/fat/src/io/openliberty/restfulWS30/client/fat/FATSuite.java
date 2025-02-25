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
package io.openliberty.restfulWS30.client.fat;

import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import componenttest.rules.repeater.FeatureReplacementAction;
import componenttest.rules.repeater.JakartaEE10Action;
import componenttest.rules.repeater.RepeatTests;
import io.openliberty.restfulWS30.client.fat.test.PathParamTest;


@RunWith(Suite.class)
@SuiteClasses({
                ClientFeatureTest.class,
                SslTest.class,
                PathParamTest.class,
                RegisterRestClientTest.class
})
public class FATSuite { 
    @ClassRule
    public static RepeatTests r = RepeatTests.withoutModification()
                    .andWith(new JakartaEE10Action().withID("EE10"));
}
