package com.hexaware.sis.main.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {
    private static final String DEFAULT_FILE = "dbconfig.properties";

    public static Properties loadProperties() {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(DEFAULT_FILE)) {
            properties.load(input);
        } catch (IOException e) {
            System.out.println("Error loading database properties: " + e.getMessage());
        }
        return properties;
    }

    public static String getConnectionString() {
        Properties properties = loadProperties();
        return properties.getProperty("db.url", "jdbc:mysql://localhost:3308/SISDB");
    }

    public static String getUsername() {
        Properties properties = loadProperties();
        return properties.getProperty("db.username", "root");
    }

    public static String getPassword() {
        Properties properties = loadProperties();
        return properties.getProperty("db.password", "");
    }
}
