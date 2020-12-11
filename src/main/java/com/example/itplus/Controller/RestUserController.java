package com.example.itplus.Controller;

import com.example.itplus.Entity.User;
import com.example.itplus.Model.UserDTO;
import com.example.itplus.Service.UserService;
import com.example.itplus.Util.MD5Util;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(produces = "application/json")
public class RestUserController {
    @Autowired
    UserService userService;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping(value = "/login/")
    @ResponseStatus(HttpStatus.OK)
    public String login(@RequestBody User user) throws JsonProcessingException {
        UserDTO userDTO = userService.getUserByEmail(user.getEmail());
        HashMap<String, Object> map = new HashMap<>();
        if (userDTO != null) {
            String password = MD5Util.toMD5(user.getPassword());
            if (!userDTO.getPassword().equals(password)){
                map.put("message", "Password not match");
                map.put("success", false);
            }else {
                map.put("user", userDTO);
                map.put("success", true);
            }
        }else {
            map.put("message", "User not found");
            map.put("success", false);
        }
        return objectMapper.writeValueAsString(map);
    }
}
