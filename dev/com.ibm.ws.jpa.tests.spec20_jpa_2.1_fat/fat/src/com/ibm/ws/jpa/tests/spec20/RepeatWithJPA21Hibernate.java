/*******************************************************************************
 * Copyright (c) 2022 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ws.jpa.tests.spec20;

import com.ibm.ws.testtooling.jpaprovider.JPAPersistenceProvider;

import componenttest.custom.junit.runner.Mode.TestMode;
import componenttest.rules.repeater.EE7FeatureReplacementAction;

public class RepeatWithJPA21Hibernate extends EE7FeatureReplacementAction {
    public static final String ID = "JPA21_HIBERNATE";

    /**
     * Restrict Hibernate tests to run on FULL mode
     */
    public RepeatWithJPA21Hibernate() {
        // Used in componenttest.rules.repeater.RepeatTestAction.isEnabled() to determine if the test should run
        withTestMode(TestMode.FULL);
    }

    @Override
    public String toString() {
        return "Switch to JPA Container 2.1 feature and use Hibernate for JPA persistence provider";
    }

    @Override
    public void setup() throws Exception {
        FATSuite.repeatPhase = "hibernate21-cfg.xml";
        // Set this for Hibernate specific DDL
        FATSuite.provider = JPAPersistenceProvider.HIBERNATE;
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public boolean isEnabled() {
        if (!Boolean.getBoolean("jpa.enable.repeat.hibernate"))
            return false;

        return super.isEnabled();
    }
}
