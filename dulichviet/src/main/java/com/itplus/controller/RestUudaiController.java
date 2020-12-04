package com.itplus.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.itplus.model.UudaiDTO;
import com.itplus.service.UudaiService;

@RestController
public class RestUudaiController {
	@Autowired
	UudaiService uudaiService;
	@RequestMapping(value = "/getAllUudai", method = RequestMethod.GET)
	public String listUudai(HttpServletRequest request) {
		List<UudaiDTO> uudaiDTO = uudaiService.getAllUudai();
		Gson gson = new Gson();
		return gson.toJson(uudaiDTO);
	}
}
