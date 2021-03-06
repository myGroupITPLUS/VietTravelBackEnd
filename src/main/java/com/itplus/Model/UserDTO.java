package com.itplus.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDTO {
    private int id;
    private String username;
    @JsonIgnore
    private String password;
    private String phone;
    private String address;
    private String email;

    public UserDTO(int id, String username, String password, String phone, String address, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public UserDTO(){

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
