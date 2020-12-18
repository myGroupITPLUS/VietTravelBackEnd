package com.itplus.Controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itplus.Entity.User;
import com.itplus.Util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;
import com.itplus.Model.UserDTO;
import com.itplus.Service.UserService;

@RestController
@RequestMapping(value = "/user",produces = "application/json")
public class RestUserController {
	@Autowired
	UserService userService;

	@Autowired
	ObjectMapper objectMapper;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listUser(HttpServletRequest request) {
		List<UserDTO> user = userService.getAllUser();
		Gson gson = new Gson();
		return gson.toJson(user);
	}

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

	@PostMapping(value = "/register/")
	@ResponseStatus(HttpStatus.OK)
	public String register(@RequestBody User user) throws JsonProcessingException {
		return objectMapper.writeValueAsString(userService.register(user));
	}


}
