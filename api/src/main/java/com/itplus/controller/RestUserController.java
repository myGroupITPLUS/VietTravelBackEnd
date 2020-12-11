package com.itplus.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.itplus.model.UserDTO;
import com.itplus.service.UserService;

@RestController
@RequestMapping(value = "/user",produces = "application/json")
public class RestUserController {
	@Autowired
	UserService userService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listUser(HttpServletRequest request) {
		List<UserDTO> user = userService.getAllUser();
		Gson gson = new Gson();
		return gson.toJson(user);
	}
}
