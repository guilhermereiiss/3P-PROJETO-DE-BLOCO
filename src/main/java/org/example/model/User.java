package org.example.model;

import org.example.enums.PermissionLevel;

public class User {

    private int id;
    private String username;
    private String CPF;
    private String password;
    private String email;
    private String phone;
    private PermissionLevel permissionLevel;

    public User() {

    }

    public User(int id, String username, String CPF, String password, String email, String phone, PermissionLevel permissionLevel) {
        this.id = id;
        this.username = username;
        this.CPF = CPF;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.permissionLevel = permissionLevel;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public PermissionLevel getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(PermissionLevel permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }


}
