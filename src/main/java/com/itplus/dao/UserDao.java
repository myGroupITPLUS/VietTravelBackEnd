package com.itplus.dao;

import java.util.List;

import com.itplus.entity.User;

public interface UserDao {
	List<User> getAllUser();
	void addUser(User user);
	void updateUser(User user);
	User getUserById(int id);
	void deleteUser(int id);
}
