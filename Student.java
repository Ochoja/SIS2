/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marafa.sis.model;

/**
 * Represents a student in the Marafa Student Information System.
 * Contains personal information, contact details, and photo path for student records.
 *
 * @author Marafa SIS Team
 * @version 1.0
 */
public class Student {

    private int studentId;
    private String registrationNumber;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String photoPath;

    /**
     * Gets the unique identifier for this student.
     *
     * @return the student's ID
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * Sets the unique identifier for this student.
     *
     * @param id the student's ID
     */
    public void setStudentId(int id) {
        this.studentId = id;
    }

    /**
     * Gets the student's registration number.
     *
     * @return the registration number
     */
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * Sets the student's registration number.
     *
     * @param s the registration number
     */
    public void setRegistrationNumber(String s) {
        registrationNumber = s;
    }

    /**
     * Gets the student's first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the student's first name.
     *
     * @param s the first name
     */
    public void setFirstName(String s) {
        firstName = s;
    }

    /**
     * Gets the student's last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the student's last name.
     *
     * @param s the last name
     */
    public void setLastName(String s) {
        lastName = s;
    }

    /**
     * Gets the path to the student's photo file.
     *
     * @return the photo file path
     */
    public String getPhotoPath() {
        return photoPath;
    }

    /**
     * Sets the path to the student's photo file.
     *
     * @param p the photo file path
     */
    public void setPhotoPath(String p) {
        photoPath = p;
    }

    /**
     * Gets the student's phone number.
     *
     * @return the phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the student's phone number.
     *
     * @param p the phone number
     */
    public void setPhone(String p) {
        phone = p;
    }

    /**
     * Gets the student's email address.
     *
     * @return the email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the student's email address.
     *
     * @param e the email address
     */
    public void setEmail(String e) {
        email = e;
    }
}
