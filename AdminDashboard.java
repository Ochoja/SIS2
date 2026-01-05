/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marafa.sis.ui;

import com.marafa.sis.model.User;
import javax.swing.*;
import java.awt.*;

/**
 * Administrative dashboard for the Marafa Student Information System.
 * Provides administrators with access to core system management functions.
 *
 * Features:
 * - Manage Students: Add, edit, delete student records
 * - Manage Courses: Create and configure courses
 * - Manage Users: User account administration
 *
 * @author Marafa SIS Team
 * @version 1.0
 */
public class AdminDashboard extends JFrame {

    private final User user;

    /**
     * Constructs the admin dashboard for a given user.
     * Creates the main interface with management buttons for students, courses, and users.
     *
     * @param u the authenticated User who is an administrator (role_id = 1)
     */
    public AdminDashboard(User u) {
        super("Admin Dashboard");
        this.user = u;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel p = new JPanel(new GridLayout(3, 1));
        p.add(new JButton("Manage Students"));
        p.add(new JButton("Manage Courses"));
        p.add(new JButton("Manage Users"));
        add(p, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }
}