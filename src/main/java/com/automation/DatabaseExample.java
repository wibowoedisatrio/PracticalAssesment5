package com.automation;

import java.sql.*;

public class DatabaseExample {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            String url = "jdbc:postgresql://tutor-data-science.c2auimxffszu.ap-southeast-3.rds.amazonaws.com:5432/sandbox";
            String user = "DS-Kredivo";
            String password = "yMoky4Wx3SnMIxw";

            try {
                conn = DriverManager.getConnection(url, user,password );
                System.out.println("Connection Successful");
            } catch (SQLException e) {
                System.out.println("Failed to establish connection: " + e.getMessage());
                return; // Exit the test if connection fails
            }

            stmt = conn.createStatement();

            // Test Query
            String sql = "";
            try {
                ResultSet rs = stmt.executeQuery(sql);

                // Check if result set is empty
                if (!rs.isBeforeFirst()) {
                    System.out.println("No records found.");
                }

                // Test Handling of Result Set
                while (rs.next()) {

                }
                rs.close();
            } catch (SQLException e) {
                System.out.println("Query execution failed: " + e.getMessage());
            }

            // Clean up
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Failed to close resources: " + e.getMessage());
            }
        }
    }
}

