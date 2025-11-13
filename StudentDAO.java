/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marafa.sis.dao;
import com.marafa.sis.model.Student;
import com.marafa.sis.util.DBConnection;
import java.sql.*;
import java.util.*;
public class StudentDAO {
    public List<Student> findAll() throws SQLException {
        String sql = "SELECT student_id, registration_number, first_name, last_name, phone, email, photo_path FROM Students";
        List<Student> out = new ArrayList<>();
        try(Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            while(rs.next()) {
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

    public Student findById(int id) throws SQLException {
        String sql = "SELECT student_id, registration_number, first_name, last_name, phone, email, photo_path FROM Students WHERE student_id = ?";
        try(Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()) {
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
