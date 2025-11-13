/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marafa.sis.model;
public class User {
    private int userId;
    private String username;
    private int roleId;
    // getters/setters
    public int getUserId(){return userId;}
    public void setUserId(int id){this.userId = id;}
    public String getUsername(){return username;}
    public void setUsername(String u){this.username = u;}
    public int getRoleId(){return roleId;}
    public void setRoleId(int r){this.roleId = r;}
}