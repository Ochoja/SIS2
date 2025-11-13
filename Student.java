/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marafa.sis.model;
public class Student {
    private int studentId;
    private String registrationNumber;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String photoPath;
    // getters/setters
    public int getStudentId(){ return studentId; }
    public void setStudentId(int id){ this.studentId = id; }
    public String getRegistrationNumber(){ return registrationNumber; }
    public void setRegistrationNumber(String s){ registrationNumber = s; }
    public String getFirstName(){ return firstName; }
    public void setFirstName(String s){ firstName = s; }
    public String getLastName(){ return lastName; }
    public void setLastName(String s){ lastName = s; }
    public String getPhotoPath(){ return photoPath; }
    public void setPhotoPath(String p){ photoPath = p; }
    public String getPhone(){ return phone; }
    public void setPhone(String p){ phone = p; }
    public String getEmail(){ return email; }
    public void setEmail(String e){ email = e; }
}
