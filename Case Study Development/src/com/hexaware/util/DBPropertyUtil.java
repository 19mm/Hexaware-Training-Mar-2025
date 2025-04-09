package com.hexaware.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//Reads a property file (db.properties) and builds a connection with the DB.
    
public class DBPropertyUtil {
    public static String getPropertyString(String fileName) {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(fileName)) {
            properties.load(fis);
        } catch(IOException e) {
            e.printStackTrace();
        }
        //extract the required Parameter's for connection
        String hostname = properties.getProperty("hostname");
        String port = properties.getProperty("port");
        String dbname = properties.getProperty("dbname");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        String connectionString = "jdbc:mysql://" + hostname + ":" + port + "/" + dbname 
                + "?user=" + username + "&password=" + password;
        return connectionString;
    }
}
