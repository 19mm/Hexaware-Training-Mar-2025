package com.hexaware.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnUtil {
    private static Connection connection;

    /**
     * Returns a singleton Connection object.
     */
    public static Connection getConnection(String connectionString) {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(connectionString);
                System.out.println("DB Connection Sucessful");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
