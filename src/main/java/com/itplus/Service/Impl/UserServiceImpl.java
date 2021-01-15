package com.itplus.Service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itplus.Dao.UserDao;
import com.itplus.Entity.User;
import com.itplus.Model.UserDTO;
import com.itplus.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

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
    public void addUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setPhone(userDTO.getPhone());
        user.setAddress(userDTO.getAddress());
        user.setEmail(userDTO.getEmail());
        userDao.addUser(user);

    }

    @Override
    public void updateUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setPhone(userDTO.getPhone());
        user.setAddress(userDTO.getAddress());
        user.setEmail(userDTO.getEmail());
        userDao.updateUser(user);

    }

    @Override
    public UserDTO getUserById(int id) {
        User user = userDao.getUserById(id);
        return user != null ? user.toUserDTO() : null;
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);

    }

    @Override
    public UserDTO getUserByEmail(String email) {
        User user = userDao.getUserByEmail(email);
        if (user != null) {
            return user.toUserDTO();
        } else {
            return null;
        }
    }


    @Override
    public HashMap<String, Object> register(User user) {
        HashMap<String, Object> result = userDao.register(user);
        if ((boolean) result.get("success") == true) {
            User newUser = (User) result.get("user");
            result.replace("user", newUser.toUserDTO());
        }
        return result;
    }

    @Override
    public HashMap<String, Object> changePassword(int id, String oldPassword, String newPassword) {
        return userDao.changePassword(id, oldPassword, newPassword);
    }

    @Override
    public HashMap<String, Object> updatePassword(int id, String newPassword) {
        return userDao.updatePassword(id, newPassword);
    }

}
