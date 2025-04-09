package com.hexaware.sis.main.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnUtil {
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Ensure the driver is loaded
        } catch (ClassNotFoundException e) {
            throw new SQLException("JDBC Driver not found: " + e.getMessage(), e);
        }
        // Attempt to get a connection using properties from DBPropertyUtil.
        Connection connection = DriverManager.getConnection(
            DBPropertyUtil.getConnectionString(),
            DBPropertyUtil.getUsername(),
            DBPropertyUtil.getPassword()
        );
        return connection;
    }
}
