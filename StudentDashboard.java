/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marafa.sis.ui;
import com.marafa.sis.model.User;
import javax.swing.*;
import java.awt.*;
public class StudentDashboard extends JFrame {
    private final User user;
    public StudentDashboard(User u){
        super("Student Dashboard");
        this.user = u;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel p = new JPanel(new GridLayout(2,1));
        p.add(new JButton("View Transcript")); 
        p.add(new JButton("Download Hall Ticket")); 
        add(p, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }
}