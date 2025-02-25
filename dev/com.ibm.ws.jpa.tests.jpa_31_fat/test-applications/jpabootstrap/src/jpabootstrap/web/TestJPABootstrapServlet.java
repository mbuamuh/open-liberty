/*******************************************************************************
 * Copyright (c) 2020 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package jpabootstrap.web;

import org.junit.Assert;

import componenttest.app.FATServlet;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.transaction.UserTransaction;
import jpabootstrap.entity.SimpleTestEntity;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/TestJPABootstrap")
public class TestJPABootstrapServlet extends FATServlet {
    @PersistenceContext(unitName = "JPAPU")
    private EntityManager em;

    @Resource
    private UserTransaction tx;

    public void testPersistenceUnitBootstrap() throws Exception {
        tx.begin();
        SimpleTestEntity entity = new SimpleTestEntity();
        entity.setStrData("Foo Bar");
        em.persist(entity);
        tx.commit();

        em.clear();

        SimpleTestEntity findEntity = em.find(SimpleTestEntity.class, entity.getId());
        Assert.assertNotNull(findEntity);
        Assert.assertNotSame(entity, findEntity);
        Assert.assertEquals(entity.getId(), findEntity.getId());
    }
}
