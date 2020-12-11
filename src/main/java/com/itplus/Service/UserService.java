package com.itplus.Service;

import java.util.List;

import com.itplus.Model.UserDTO;

public interface UserService {
	List<UserDTO> getAllUser();
	UserDTO getUserByEmail(String email);
}
