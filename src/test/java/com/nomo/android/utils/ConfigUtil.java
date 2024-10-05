package com.nomo.android.utils;

import java.util.Properties;

public class ConfigUtil {
    private static Properties emulatorProperties;
    private static ConfigUtil configUtil;

    public ConfigUtil() {
        emulatorProperties = PropertiesUtil.loadProperties("src/test/resources/emulator.properties");
        if (emulatorProperties == null) {
            throw new RuntimeException("Failed to load emulator properties");
        }

    }

    public static ConfigUtil getInstance() {
        if (configUtil == null) {
            configUtil = new ConfigUtil();
        }
        return configUtil;
    }

    public String getEmulatorPlatformName() {
        String prop = emulatorProperties.getProperty("platformName");
        if (prop != null) return prop;
        throw new RuntimeException("Could not find the value in the property file");
    }

    public String getEmulatorDeviceName() {
        String prop = emulatorProperties.getProperty("deviceName");
        if (prop != null) return prop;
        throw new RuntimeException("Could not find the value in the property file");
    }

    public String getEmulatorPlatformVersion() {
        String prop = emulatorProperties.getProperty("platformVersion");
        if (prop != null) return prop;
        throw new RuntimeException("Could not find the value in the property file");
    }

    public String getEmulatorAutomationName() {
        String prop = emulatorProperties.getProperty("automationName");
        if (prop != null) return prop;
        throw new RuntimeException("Could not find the value in the property file");
    }

    public String getAppName() {
        String prop = emulatorProperties.getProperty("app");
        if (prop != null) return prop;
        throw new RuntimeException("Could not find the value in the property file");
    }
}
