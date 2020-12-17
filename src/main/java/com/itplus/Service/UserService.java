package com.itplus.service;

import java.util.List;

import com.itplus.model.UserDTO;

public interface UserService {
	List<UserDTO> getAllUser();
	void addUser(UserDTO userDTO);
	void updateUser(UserDTO userDTO);
	UserDTO getUserById(int id);
	void deleteUser(int id);
}
