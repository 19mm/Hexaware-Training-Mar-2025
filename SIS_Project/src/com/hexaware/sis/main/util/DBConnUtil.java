package com.hexaware.sis.main.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnUtil {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Ensure the driver is loaded
            return DriverManager.getConnection(
                DBPropertyUtil.getConnectionString(),
                DBPropertyUtil.getUsername(),
                DBPropertyUtil.getPassword()
            );
            
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("Error obtaining DB connection: " + e.getMessage());
            return null;
        }
    }
}
