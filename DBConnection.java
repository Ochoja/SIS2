/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marafa.sis.util;
import java.sql.*;
public class DBConnection {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=MarafaSIS;encrypt=false;";
    private static final String USER = "db_user";
    private static final String PASS = "db_pass";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
