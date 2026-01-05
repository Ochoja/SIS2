/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marafa.sis.model;

/**
 * Represents a system user in the Marafa Student Information System.
 * Users can have different roles (Admin, Teacher, Student) which determine their access permissions.
 *
 * @author Marafa SIS Team
 * @version 1.0
 */
public class User {

    private int userId;
    private String username;
    private int roleId;

    /**
     * Gets the unique identifier for this user.
     *
     * @return the user's ID
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the unique identifier for this user.
     *
     * @param id the user's ID
     */
    public void setUserId(int id) {
        this.userId = id;
    }

    /**
     * Gets the username used for authentication.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username used for authentication.
     *
     * @param u the username
     */
    public void setUsername(String u) {
        this.username = u;
    }

    /**
     * Gets the role ID which determines user permissions.
     * Role IDs: 1 = Admin, 2 = Teacher, 3 = Student
     *
     * @return the role ID
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * Sets the role ID which determines user permissions.
     *
     * @param r the role ID (1 = Admin, 2 = Teacher, 3 = Student)
     */
    public void setRoleId(int r) {
        this.roleId = r;
    }
}