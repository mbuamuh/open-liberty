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
package io.openliberty.microprofile.jwt20.internal.tck;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import componenttest.annotation.MaximumJavaLevel;

@RunWith(Suite.class)
@SuiteClasses({
                Mpjwt20TCKLauncher_aud_env.class,
                Mpjwt20TCKLauncher_aud_noenv.class,
                Mpjwt20TCKLauncher_noaud_env.class,
                Mpjwt20TCKLauncher_noaud_noenv.class,
                Mpjwt20TCKLauncher_aud_noenv2.class,
                DummyForQuarantine.class
})

@MaximumJavaLevel(javaLevel = 18)
public class FATSuite {
}
