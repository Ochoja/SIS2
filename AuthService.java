/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marafa.sis.service;
import com.marafa.sis.dao.UserDAO;
import com.marafa.sis.model.User;
import org.mindrot.jbcrypt.BCrypt;

public class AuthService {
    private final UserDAO userDAO = new UserDAO();

    public User authenticate(String username, String password) throws Exception {
        User u = userDAO.findByUsername(username);
        if (u == null) return null;
        String hash = userDAO.getPasswordHash(username);
        if (hash == null) return null;
        if (BCrypt.checkpw(password, hash)) return u;
        return null;
    }

    public static String hashPassword(String plain) {
        return BCrypt.hashpw(plain, BCrypt.gensalt(12));
    }
}
