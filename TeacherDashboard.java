/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marafa.sis.ui;

import com.marafa.sis.model.User;
import javax.swing.*;
import java.awt.*;

/**
 * Teacher dashboard for the Marafa Student Information System.
 * Provides teachers with access to grade entry, enrollment management, and reporting functions.
 *
 * Features:
 * - Enter Grades: Input and update student grades for courses
 * - Manage Enrolments: View and manage student course enrollments
 * - Generate Reports: Create class reports and grade summaries
 *
 * @author Marafa SIS Team
 * @version 1.0
 */
public class TeacherDashboard extends JFrame {

    private final User user;

    /**
     * Constructs the teacher dashboard for a given user.
     * Creates the main interface with buttons for grading, enrollment management, and reporting.
     *
     * @param u the authenticated User who is a teacher (role_id = 2)
     */
    public TeacherDashboard(User u) {
        super("Teacher Dashboard");
        this.user = u;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel p = new JPanel(new GridLayout(3, 1));
        p.add(new JButton("Enter Grades"));
        p.add(new JButton("Manage Enrolments"));
        p.add(new JButton("Generate Reports"));
        add(p, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }
}
