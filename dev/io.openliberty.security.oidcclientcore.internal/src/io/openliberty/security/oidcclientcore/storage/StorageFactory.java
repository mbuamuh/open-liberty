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
package io.openliberty.security.oidcclientcore.storage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StorageFactory {

    public static Storage instantiateStorage(HttpServletRequest request, HttpServletResponse response, boolean useSession) {
        if (useSession) {
            return new SessionBasedStorage(request);
        } else {
            return new CookieBasedStorage(request, response);
        }
    }
}
