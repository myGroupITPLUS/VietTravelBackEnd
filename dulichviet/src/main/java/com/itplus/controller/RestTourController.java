package com.itplus.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.itplus.model.TourDTO;
import com.itplus.service.TourService;

@RestController
public class RestTourController {
	
	@Autowired
	TourService tourService;
	@RequestMapping(value = "/getAllTour", method = RequestMethod.GET)
	public String listTour(HttpServletRequest request) {
		List<TourDTO> tour = tourService.getAllTour();
		Gson gson = new Gson();
		return gson.toJson(tour);
	}
}
