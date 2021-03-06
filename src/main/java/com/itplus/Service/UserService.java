package com.itplus.Service;

import java.util.HashMap;
import java.util.List;

import com.itplus.Entity.User;
import com.itplus.Model.UserDTO;

public interface UserService {
	List<UserDTO> getAllUser();
	UserDTO getUserByEmail(String email);
	HashMap<String, Object> register(User user);
}
