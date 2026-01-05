/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marafa.sis.dao;

import com.marafa.sis.model.Student;
import com.marafa.sis.util.DBConnection;
import java.sql.*;
import java.util.*;

/**
 * Data Access Object for Student entities.
 * Handles all database operations related to student records including retrieval operations.
 * Uses prepared statements to prevent SQL injection attacks.
 *
 * @author Marafa SIS Team
 * @version 1.0
 */
public class StudentDAO {

    /**
     * Retrieves all students from the database.
     * Fetches all student records including their personal information, contact details, and photo paths.
     *
     * @return a List of all Student objects in the database
     * @throws SQLException if a database access error occurs
     */
    public List<Student> findAll() throws SQLException {
        String sql = "SELECT student_id, registration_number, first_name, last_name, phone, email, photo_path FROM Students";
        List<Student> out = new ArrayList<>();
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Student s = new Student();
                s.setStudentId(rs.getInt("student_id"));
                s.setRegistrationNumber(rs.getString("registration_number"));
                s.setFirstName(rs.getString("first_name"));
                s.setLastName(rs.getString("last_name"));
                s.setPhotoPath(rs.getString("photo_path"));
                s.setPhone(rs.getString("phone"));
                s.setEmail(rs.getString("email"));
                out.add(s);
            }
        }
        return out;
    }

    /**
     * Finds a specific student by their unique ID.
     * Retrieves complete student information for the specified student ID.
     *
     * @param id the student ID to search for
     * @return the Student object if found, null otherwise
     * @throws SQLException if a database access error occurs
     */
    public Student findById(int id) throws SQLException {
        String sql = "SELECT student_id, registration_number, first_name, last_name, phone, email, photo_path FROM Students WHERE student_id = ?";
        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Student s = new Student();
                    s.setStudentId(rs.getInt("student_id"));
                    s.setRegistrationNumber(rs.getString("registration_number"));
                    s.setFirstName(rs.getString("first_name"));
                    s.setLastName(rs.getString("last_name"));
                    s.setPhotoPath(rs.getString("photo_path"));
                    s.setPhone(rs.getString("phone"));
                    s.setEmail(rs.getString("email"));
                    return s;
                }
            }
        }
        return null;
    }
}
