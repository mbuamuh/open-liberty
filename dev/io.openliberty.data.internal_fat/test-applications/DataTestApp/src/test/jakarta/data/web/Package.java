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
package test.jakarta.data.web;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 *
 */
@Entity
public class Package {

    public String description;

    @Id
    public int id;

    @Column(columnDefinition = "DECIMAL(8,5) NOT NULL")
    public float height;

    @Column(columnDefinition = "DECIMAL(9,4) NOT NULL")
    public float length;

    @Column(columnDefinition = "DECIMAL(8,4) NOT NULL")
    public float width;

    public Package() {
    }

    public Package(int id, float length, float width, float height, String description) {
        this.id = id;
        this.length = length;
        this.width = width;
        this.height = height;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Package type=" + id + "; L=" + length + "; W=" + width + " H=" + height + " " + description;
    }
}
