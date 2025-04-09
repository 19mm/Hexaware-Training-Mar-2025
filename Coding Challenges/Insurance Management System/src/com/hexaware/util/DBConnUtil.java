package com.hexaware.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnUtil {
    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
            	// Loading the JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver"); 
            } catch (ClassNotFoundException e) {
                throw new SQLException("JDBC Driver not found: " + e.getMessage(), e);
            }
            //Extraction of Required Resources from "DB.properties" File
            connection = DriverManager.getConnection(
                DBPropertyUtil.getConnectionString(),
                DBPropertyUtil.getUsername(),
                DBPropertyUtil.getPassword()
            );
        }
        return connection;
    }
}
