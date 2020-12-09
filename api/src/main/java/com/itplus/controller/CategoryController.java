package com.itplus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {
	
	@RequestMapping("/hello")
	public String sayHello(ModelMap map) {
		map.addAttribute("msg", "Hello Spring MVC!!!!");
		return "hello";
	}
}
