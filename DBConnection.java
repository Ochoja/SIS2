/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marafa.sis.util;

import java.sql.*;

/**
 * Database connection utility class for the Marafa Student Information System.
 * Provides centralized database connection management using SQL Server JDBC driver.
 * All connection parameters are configured as constants for easy maintenance.
 *
 * Database Configuration:
 * - Server: localhost:1433
 * - Database: MarafaSIS
 * - Encryption: Disabled (for development only)
 *
 * @author Marafa SIS Team
 * @version 1.0
 */
public class DBConnection {

    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=MarafaSIS;encrypt=false;";
    private static final String USER = "db_user";
    private static final String PASS = "db_pass";

    /**
     * Creates and returns a new database connection.
     * Each call creates a fresh connection to the SQL Server database.
     * Callers are responsible for closing the connection after use.
     *
     * @return a Connection object to the MarafaSIS database
     * @throws SQLException if connection cannot be established or database credentials are invalid
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
