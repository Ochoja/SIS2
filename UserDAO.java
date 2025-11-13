/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marafa.sis.dao;
import com.marafa.sis.model.User;
import com.marafa.sis.util.DBConnection;
import java.sql.*;
public class UserDAO {
    public User findByUsername(String username) throws SQLException {
        String sql = "SELECT user_id, username, role_id FROM Users WHERE username = ? AND is_active = 1";
        try(Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, username);
            try(ResultSet rs = ps.executeQuery()) {
                if(rs.next()) {
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

    public String getPasswordHash(String username) throws SQLException {
        String sql = "SELECT password_hash FROM Users WHERE username = ?";
        try(Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, username);
            try(ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getString("password_hash");
            }
        }
        return null;
    }
}
