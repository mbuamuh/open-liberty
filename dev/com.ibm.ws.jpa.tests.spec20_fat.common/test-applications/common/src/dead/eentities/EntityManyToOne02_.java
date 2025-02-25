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

package dead.eentities;

import javax.persistence.metamodel.SingularAttribute;

@javax.persistence.metamodel.StaticMetamodel(value = dead.eentities.EntityManyToOne02.class)
public class EntityManyToOne02_ {
    public static volatile SingularAttribute<EntityManyToOne02, Integer> entityManyToOne02_id;
    public static volatile SingularAttribute<EntityManyToOne02, Integer> entityManyToOne02_version;
}
