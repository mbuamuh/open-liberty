/*******************************************************************************
 * Copyright (c) 2015, 2022 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.concurrent.persistent.fat.timers;

import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.testcontainers.containers.JdbcDatabaseContainer;

import com.ibm.websphere.simplicity.Machine;
import com.ibm.websphere.simplicity.ShrinkHelper;
import com.ibm.websphere.simplicity.config.PersistentExecutor;
import com.ibm.websphere.simplicity.config.ServerConfiguration;

import componenttest.annotation.MinimumJavaLevel;
import componenttest.annotation.TestServlet;
import componenttest.custom.junit.runner.FATRunner;
import componenttest.topology.database.container.DatabaseContainerFactory;
import componenttest.topology.database.container.DatabaseContainerType;
import componenttest.topology.database.container.DatabaseContainerUtil;
import componenttest.topology.impl.LibertyFileManager;
import componenttest.topology.impl.LibertyServer;
import componenttest.topology.impl.LibertyServerFactory;
import componenttest.topology.utils.FATServletClient;
import web.PersistentTimersTestServlet;

/**
 * Tests for persistent scheduled executor via persistent EJB timers
 */
@RunWith(FATRunner.class)
@MinimumJavaLevel(javaLevel = 11)
public class PersistentExecutorTimersWithFailoverEnabledTest extends FATServletClient {

    private static final String APP_NAME = "timersapp";

    private static ServerConfiguration originalConfig;

    @TestServlet(servlet = PersistentTimersTestServlet.class, path = APP_NAME)
    public static LibertyServer server = LibertyServerFactory.getLibertyServer("com.ibm.ws.concurrent.persistent.fat.timers");

    @ClassRule
    public static final JdbcDatabaseContainer<?> testContainer = DatabaseContainerFactory.create();

    /**
     * Before running any tests, start the server
     */
    @BeforeClass
    public static void setUp() throws Exception {
        // Delete the Derby-only database that is used by the persistent executor
        Machine machine = server.getMachine();
        String installRoot = server.getInstallRoot();
        LibertyFileManager.deleteLibertyDirectoryAndContents(machine, installRoot + "/usr/shared/resources/data/persisttimers");

        // configure server.xml to enable failover
        originalConfig = server.getServerConfiguration();
        ServerConfiguration config = originalConfig.clone();

        // Run with EE 10 features, including concurrent-3.0
        Set<String> features = config.getFeatureManager().getFeatures();
        features.add("concurrent-3.0");
        features.add("servlet-6.0");
        features.remove("servlet-5.0");

        PersistentExecutor defaultEJBPersistentTimerExecutor = new PersistentExecutor();
        defaultEJBPersistentTimerExecutor.setId("defaultEJBPersistentTimerExecutor");
        defaultEJBPersistentTimerExecutor.setPollInterval("15s");
        defaultEJBPersistentTimerExecutor.setExtraAttribute("missedTaskThreshold", "4s");
        defaultEJBPersistentTimerExecutor.setExtraAttribute("ignore.minimum.for.test.use.only", "true");
        config.getPersistentExecutors().add(defaultEJBPersistentTimerExecutor);

        server.updateServerConfiguration(config);

    	//Get type
		DatabaseContainerType dbContainerType = DatabaseContainerType.valueOf(testContainer);

    	//Get driver info
    	String driverName = dbContainerType.getDriverName();
    	server.addEnvVar("DB_DRIVER", driverName);

    	//Setup server DataSource properties
    	DatabaseContainerUtil.setupDataSourceProperties(server, testContainer);
		
		//Add application to server
        ShrinkHelper.defaultDropinApp(server, APP_NAME, "web", "ejb");

        //Start Server
        server.startServer();

    }

    /**
     * After completing all tests, stop the server.
     */
    @AfterClass
    public static void tearDown() throws Exception {
        if (server != null)
            try {
                if (server.isStarted())
                    server.stopServer("CWWKZ0022W");
            } finally {
                if (originalConfig != null)
                    server.updateServerConfiguration(originalConfig);
            }
    }
}