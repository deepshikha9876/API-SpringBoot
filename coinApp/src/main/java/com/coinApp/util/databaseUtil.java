package com.coinApp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class databaseUtil {
    public static Connection connab() {
        String url = "jdbc:h2:mem:testdb";
        String user = "sa";
        String password = "sa";

        Connection conn=null;
        try {
             conn = DriverManager.getConnection(url, user, password);
     
            System.out.println("Data inserted successfully!");
            return conn;
         
        } catch (SQLException e) {
            System.out.println("Database operation failed: " + e.getMessage());
        }
    return null;
    }
}