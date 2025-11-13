/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marafa.sis.ui;
import com.marafa.sis.service.AuthService;
import com.marafa.sis.model.User;
import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    private final JTextField tfUser = new JTextField(20);
    private final JPasswordField pf = new JPasswordField(20);
    private final JButton btnLogin = new JButton("Login");

    public LoginFrame() {
        super("Marafa SIS - Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel p = new JPanel(new GridLayout(3,2));
        p.add(new JLabel("Username:"));
        p.add(tfUser);
        p.add(new JLabel("Password:"));
        p.add(pf);
        p.add(new JLabel());
        p.add(btnLogin);
        add(p, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);

        btnLogin.addActionListener(e -> doLogin());
    }

    private void doLogin() {
        String username = tfUser.getText();
        String password = new String(pf.getPassword());
        try {
            AuthService auth = new AuthService();
            var user = auth.authenticate(username, password);
            if (user == null) {
                JOptionPane.showMessageDialog(this, "Invalid credentials");
                return;
            }
            int role = user.getRoleId();
            if (role == 1) { new AdminDashboard(user).setVisible(true); }
            else if (role == 2) { new TeacherDashboard(user).setVisible(true); }
            else { new StudentDashboard(user).setVisible(true); }
            this.dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Login error: " + ex.getMessage());
        }
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}
