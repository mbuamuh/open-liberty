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
package io.openliberty.security.jakartasec.fat.utils;

import java.util.Map;

import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import com.ibm.websphere.simplicity.ShrinkHelper;
import com.ibm.websphere.simplicity.log.Log;

import componenttest.topology.impl.LibertyServer;

public class ShrinkWrapHelpers {

    protected static Class<?> thisClass = ShrinkWrapHelpers.class;
    private String providerFileContent = null;

    /**
     * Create a new instance including provider information based on the default OP port info
     */
    public ShrinkWrapHelpers() {

        Log.info(thisClass, "ShrinkWrapHelpers", "Saving default OP and RP ports");
        providerFileContent = Constants.PROVIDER_BASE + "=http://localhost:" + System.getProperty("bvt.prop.security_1_HTTP_default") +
                              System.lineSeparator() +
                              Constants.PROVIDER_SECURE_BASE + "=https://localhost:" + System.getProperty("bvt.prop.security_1_HTTP_default.secure") +
                              System.lineSeparator() +
                              Constants.CLIENT_BASE + "=http://localhost:" + System.getProperty("bvt.prop.security_2_HTTP_default") +
                              System.lineSeparator() +
                              Constants.CLIENT_SECURE_BASE + "=https://localhost:" + System.getProperty("bvt.prop.security_2_HTTP_default.secure");
    }

    /**
     * Create a new instance including provider information based on the actual OP ports
     */
    @Deprecated
    public ShrinkWrapHelpers(String opBase, String opSecureBase) {

        Log.info(thisClass, "ShrinkWrapHelpers", "Saving only RP ports");
        providerFileContent = Constants.PROVIDER_BASE + "=" + opBase +
                              System.lineSeparator() +
                              Constants.PROVIDER_SECURE_BASE + "=" + opSecureBase;
    }

    public ShrinkWrapHelpers(String opBase, String opSecureBase, String rpBase, String rpSecureBase) {

        Log.info(thisClass, "ShrinkWrapHelpers", "Saving real OP and RP ports (" + rpBase + " " + rpSecureBase + " " + rpBase + " " + rpSecureBase + ")");
        providerFileContent = Constants.PROVIDER_BASE + "=" + opBase +
                              System.lineSeparator() +
                              Constants.PROVIDER_SECURE_BASE + "=" + opSecureBase +
                              System.lineSeparator() +
                              Constants.CLIENT_BASE + "=" + rpBase +
                              System.lineSeparator() +
                              Constants.CLIENT_SECURE_BASE + "=" + rpSecureBase;

    }

    /**
     * Deploy an app that has been built as part of the fat framework. We'll add some utility classes as well as the provider
     * config file with the current op runtime ports
     *
     * @param server
     *            the server to deploy the app to
     * @param appName
     *            the app to deploy
     * @param packages
     *            the packages to include in the war (generally this is the package from the app plus any common tooling)
     * @throws Exception
     */
    public void defaultDropinApp(LibertyServer server, String appName, String... packages) throws Exception {

        WebArchive war = ShrinkHelper.buildDefaultApp(appName, packages);
        addUtilClassesToApp(war);
        addProviderConfigToApp(war);
//        addResourcesToApp(war);

        ShrinkHelper.exportDropinAppToServer(server, war);
    }

    /**
     * Deploys applications that will start with copies of a shared app. We'll update the copy with additional packages as well as
     * more specific config data
     *
     * @param server
     *            the server to deploy the app to
     * @param newWar
     *            the new war to create
     * @param sourceWar
     *            the war to copy from
     * @param configSettings
     *            the config settings to use to build the openIdConfig.properties file
     * @param packages
     *            the pacakges to include in the new war
     * @throws Exception
     */
    public void deployConfigurableTestApps(LibertyServer server, String newWar, String sourceWar, Map<String, Object> configSettings, String... packages) throws Exception {

        WebArchive war = ShrinkHelper.buildDefaultAppFromPath(newWar, sourceWar, packages);
        if (configSettings != null && !configSettings.isEmpty()) {
            war.add(new StringAsset(buildConfigFileContent(configSettings)), Constants.OPEN_ID_CONFIG_PROPERTIES);
        }

        addUtilClassesToApp(war);
        addProviderConfigToApp(war);
//        addResourcesToApp(war);
        ShrinkHelper.exportDropinAppToServer(server, war);
    }

    /**
     * Add utility classes to the tests wars
     *
     * @param war
     *            the war to update
     * @return the updated war
     * @throws Exception
     */
    public WebArchive addUtilClassesToApp(WebArchive war) throws Exception {

        war.addClass("io.openliberty.security.jakartasec.fat.utils.Constants");
        war.addClass("io.openliberty.security.jakartasec.fat.utils.ServletMessageConstants");
        // add any other classes to the war

        return war;
    }

    /**
     * Add the provider configuration settings to a file named providerConfig.properties (this should be done for all of our war
     * files)
     *
     * @param war
     *            the war to update
     * @return the updated war
     * @throws Exception
     */
    public WebArchive addProviderConfigToApp(WebArchive war) throws Exception {

        // create the property file
        Log.info(thisClass, "addProviderConfigToApp", providerFileContent);
        war.add(new StringAsset(providerFileContent), Constants.PROVIDER_CONFIG_PROPERTIES);

        return war;
    }

    public WebArchive addResourcesToApp(WebArchive war) throws Exception {
        try {
            Log.info(thisClass, "addResourcesToApp", "Adding beans.xml to app");
            war.addAsWebInfResource("oidc/client/base/utils/beans.xml", "beans.xml");
        } catch (Exception e) {
            Log.error(thisClass, "addResourcesToApp", e);
        }
        return war;
    }

    /**
     * Create the openIdConfig.properties file content from the config variable map.
     *
     * @param configSettings
     *            the map of config settings
     * @return the openIdConfig.properties file content
     * @throws Exception
     */
    public String buildConfigFileContent(Map<String, Object> configSettings) throws Exception {

        Log.info(thisClass, "buildConfigFileContent", "Build " + Constants.OPEN_ID_CONFIG_PROPERTIES + " from map provided.");

        String fileContent = "";
        for (Map.Entry<String, Object> entry : configSettings.entrySet()) {
            // only handling String for now
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                fileContent = fileContent + key + "=" + value + System.lineSeparator();
            }
        }
        return fileContent;

    }

}
