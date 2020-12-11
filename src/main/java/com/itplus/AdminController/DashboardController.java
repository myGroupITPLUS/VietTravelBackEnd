package com.itplus.AdminController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
@RequestMapping(value = "/admin/dashboard")
public class DashboardController {
	
	@RequestMapping(value = "/")
	public String Dashboard(Mode map) {
		
		return "dashboard";
	}
}
