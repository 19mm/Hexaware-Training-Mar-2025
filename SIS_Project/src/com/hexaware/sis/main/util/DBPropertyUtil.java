package com.hexaware.sis.main.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBPropertyUtil {
    private static final String DEFAULT_FILE = "com/hexaware/sis/main/util/dbconfig.properties";

    public static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = DBPropertyUtil.class.getClassLoader().getResourceAsStream(DEFAULT_FILE)) {
            if (input == null) {
                throw new IOException("Unable to find " + DEFAULT_FILE + " in classpath.");
            }
            properties.load(input);
        } catch (IOException e) {
            System.out.println("Error loading database properties: " + e.getMessage());
        }
        return properties;
    }

    public static String getConnectionString() {
        Properties properties = loadProperties();
        return properties.getProperty("db.url");
    }

    public static String getUsername() {
        Properties properties = loadProperties();
        return properties.getProperty("db.username");
    }

    public static String getPassword() {
        Properties properties = loadProperties();
        return properties.getProperty("db.password");
    }
}
