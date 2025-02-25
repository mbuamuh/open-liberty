/*******************************************************************************
 * Copyright (c) 2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.cdi.visibility.tests.sharedlib.sharedLibraryJar;

public class NonInjectedHello {

    public static final String PREFIX = "Hello from a non injected class name: ";

    public String areYouThere(String name) {
        return PREFIX + name;
    }
}
