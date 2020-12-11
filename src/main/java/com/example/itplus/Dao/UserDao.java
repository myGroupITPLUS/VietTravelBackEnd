package com.example.itplus.Dao;

import com.example.itplus.Entity.User;

import java.util.HashMap;


public interface UserDao {
    HashMap<String, Object> register(User user);
    User getUserByEmail(String email);
}
