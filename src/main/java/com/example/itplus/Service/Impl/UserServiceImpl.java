package com.example.itplus.Service.Impl;

import com.example.itplus.Dao.UserDao;
import com.example.itplus.Entity.User;
import com.example.itplus.Model.UserDTO;
import com.example.itplus.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

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
