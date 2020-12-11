package com.itplus.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itplus.dao.UserDao;
import com.itplus.entity.User;
import com.itplus.model.UserDTO;
import com.itplus.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	@Override
	public List<UserDTO> getAllUser() {
		// TODO Auto-generated method stub
		List<UserDTO> listUserDTO = new ArrayList<UserDTO>();
		List<User> listUser = userDao.getAllUser();
		for (User user : listUser) {
			UserDTO userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setUsername(user.getUsername());
			userDTO.setPassword(user.getPassword());
			userDTO.setPhone(user.getPhone());
			userDTO.setAddress(user.getAddress());
			userDTO.setEmail(user.getEmail());
			listUserDTO.add(userDTO);
		}		
		return listUserDTO;
	}

}
