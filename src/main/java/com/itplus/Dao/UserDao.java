package com.itplus.Dao;

import java.util.HashMap;
import java.util.List;

import com.itplus.Entity.User;

public interface UserDao {
	List<User> getAllUser();
	void addUser(User user);
	void updateUser(User user);
	User getUserById(int id);
	void deleteUser(int id);
	HashMap<String, Object> register(User user);
	User getUserByEmail(String email);
}
