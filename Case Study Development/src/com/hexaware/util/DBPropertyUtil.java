package com.hexaware.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {
    /**
     * Reads a property file (for example, "db.properties") and builds a connection string.
     * Adjust the string format if your SQL file requires additional parameters.
     */
    public static String getPropertyString(String fileName) {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(fileName)) {
            properties.load(fis);
        } catch(IOException e) {
            e.printStackTrace();
        }
        String hostname = properties.getProperty("hostname");
        String port = properties.getProperty("port");
        String dbname = properties.getProperty("dbname");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        // Adjust the connection string as required (for example, SSL or timezone parameters)
        String connectionString = "jdbc:mysql://" + hostname + ":" + port + "/" + dbname 
                + "?user=" + username + "&password=" + password;
        return connectionString;
    }
}
