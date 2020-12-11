package com.itplus.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itplus.Dao.UserDao;
import com.itplus.Entity.User;
import com.itplus.Model.UserDTO;
import com.itplus.Service.UserService;

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

	@Override
	public UserDTO getUserByEmail(String email) {
		User user = userDao.getUserByEmail(email);
		if (user != null){
			return user.toUserDTO();
		}else{
			return null;
		}
	}

}
