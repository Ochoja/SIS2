/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marafa.sis.ui;
import com.marafa.sis.model.User;
import javax.swing.*;
import java.awt.*;
public class AdminDashboard extends JFrame {
    private final User user;
    public AdminDashboard(User u){
        super("Admin Dashboard");
        this.user = u;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel p = new JPanel(new GridLayout(3,1));
        p.add(new JButton("Manage Students"));
        p.add(new JButton("Manage Courses"));
        p.add(new JButton("Manage Users"));
        add(p, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }
}