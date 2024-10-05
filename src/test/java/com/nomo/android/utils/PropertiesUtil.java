package com.nomo.android.utils;

import java.io.*;
import java.util.Properties;

public class PropertiesUtil {
    public static Properties loadProperties(String filePath) {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream(filePath)) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file: " + filePath, e);
        }
        return properties;
    }

}
