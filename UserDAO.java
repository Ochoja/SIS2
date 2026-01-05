/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marafa.sis.dao;

import com.marafa.sis.model.User;
import com.marafa.sis.util.DBConnection;
import java.sql.*;

/**
 * Data Access Object for User entities.
 * Handles all database operations related to user authentication and retrieval.
 * Uses prepared statements to prevent SQL injection attacks.
 *
 * @author Marafa SIS Team
 * @version 1.0
 */
public class UserDAO {

    /**
     * Finds an active user by their username.
     * Only returns users where is_active = 1 in the database.
     *
     * @param username the username to search for
     * @return the User object if found and active, null otherwise
     * @throws SQLException if a database access error occurs
     */
    public User findByUsername(String username) throws SQLException {
        String sql = "SELECT user_id, username, role_id FROM Users WHERE username = ? AND is_active = 1";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    User u = new User();
                    u.setUserId(rs.getInt("user_id"));
                    u.setUsername(rs.getString("username"));
                    u.setRoleId(rs.getInt("role_id"));
                    return u;
                }
            }
        }
        return null;
    }

    /**
     * Retrieves the BCrypt password hash for a given username.
     * Used for authentication purposes in conjunction with BCrypt.checkpw().
     *
     * @param username the username whose password hash to retrieve
     * @return the BCrypt password hash, or null if user not found
     * @throws SQLException if a database access error occurs
     */
    public String getPasswordHash(String username) throws SQLException {
        String sql = "SELECT password_hash FROM Users WHERE username = ?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("password_hash");
                }
            }
        }
        return null;
    }
}
