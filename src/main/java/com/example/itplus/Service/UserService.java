package com.example.itplus.Service;

import com.example.itplus.Model.UserDTO;

public interface UserService {
    UserDTO getUserByEmail(String email);
}
