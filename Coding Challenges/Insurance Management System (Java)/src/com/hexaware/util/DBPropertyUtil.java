package com.hexaware.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {
    // DB Properties File Path
    private static final String filepath = "C:\\Users\\Mayuresh\\Desktop\\Hexaware Training\\Java Assignments\\Insurance Management System\\src\\com\\hexaware\\util\\DB.properties";

    //Loading the properties file
    public static Properties loadProperties() {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(filepath)) {
            properties.load(input);
        } catch (IOException e) {
            System.out.println("Error loading database properties: " + e.getMessage());
        }
        return properties;
    }
    
    //Extraction of Required Properties
    public static String getConnectionString() {
        Properties properties = loadProperties();
        //DB URL: jdbc:mysql://localhost:3308/Insurance_Management_System
        return properties.getProperty("db.url");
    }

    public static String getUsername() {
        Properties properties = loadProperties();
        //DB UserName: root
        return properties.getProperty("db.username");
    }

    public static String getPassword() {
        Properties properties = loadProperties();
        //DB Password
        return properties.getProperty("db.password");
    }
}
