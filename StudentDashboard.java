/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marafa.sis.ui;

import com.marafa.sis.model.User;
import javax.swing.*;
import java.awt.*;

/**
 * Student dashboard for the Marafa Student Information System.
 * Provides students with access to their academic records and exam documents.
 *
 * Features:
 * - View Transcript: Display student's academic transcript with grades
 * - Download Hall Ticket: Download exam hall ticket as PDF
 *
 * @author Marafa SIS Team
 * @version 1.0
 */
public class StudentDashboard extends JFrame {

    private final User user;

    /**
     * Constructs the student dashboard for a given user.
     * Creates the main interface with buttons for viewing transcript and downloading hall ticket.
     *
     * @param u the authenticated User who is a student (role_id = 3+)
     */
    public StudentDashboard(User u) {
        super("Student Dashboard");
        this.user = u;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel p = new JPanel(new GridLayout(2, 1));
        p.add(new JButton("View Transcript"));
        p.add(new JButton("Download Hall Ticket"));
        add(p, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }
}