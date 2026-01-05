/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marafa.sis.service;

import com.marafa.sis.dao.UserDAO;
import com.marafa.sis.model.User;
import org.mindrot.jbcrypt.BCrypt;

/**
 * Service class for user authentication and password management.
 * Handles login authentication using BCrypt for secure password hashing and verification.
 * BCrypt is a one-way hashing algorithm that includes a salt to protect against rainbow table attacks.
 *
 * @author Marafa SIS Team
 * @version 1.0
 */
public class AuthService {

    private final UserDAO userDAO = new UserDAO();

    /**
     * Authenticates a user by verifying their username and password.
     * Uses BCrypt to securely compare the provided password with the stored hash.
     * Only active users (is_active = 1) can be authenticated.
     *
     * @param username the username to authenticate
     * @param password the plain-text password to verify
     * @return the User object if authentication succeeds, null otherwise
     * @throws Exception if a database error occurs during authentication
     */
    public User authenticate(String username, String password) throws Exception {
        User u = userDAO.findByUsername(username);
        if (u == null) {
            return null;
        }
        String hash = userDAO.getPasswordHash(username);
        if (hash == null) {
            return null;
        }
        if (BCrypt.checkpw(password, hash)) {
            return u;
        }
        return null;
    }

    /**
     * Hashes a plain-text password using BCrypt with a work factor of 12.
     * The work factor determines the computational cost of hashing (2^12 rounds).
     * Higher work factors provide better security but take longer to compute.
     *
     * @param plain the plain-text password to hash
     * @return the BCrypt hash of the password, suitable for database storage
     */
    public static String hashPassword(String plain) {
        return BCrypt.hashpw(plain, BCrypt.gensalt(12));
    }
}
