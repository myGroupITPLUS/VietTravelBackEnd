package com.itplus.Service;

import java.util.HashMap;
import java.util.List;

import com.itplus.Entity.User;
import com.itplus.Model.UserDTO;

public interface UserService {
	List<UserDTO> getAllUser();
	void addUser(UserDTO userDTO);
	void updateUser(UserDTO userDTO);
	UserDTO getUserById(int id);
	void deleteUser(int id);
	UserDTO getUserByEmail(String email);
	HashMap<String, Object> register(User user);
	HashMap<String, Object> changePassword(int id, String oldPassword, String newPassword);
	HashMap<String, Object> updatePassword(int id, String newPassword);
}
