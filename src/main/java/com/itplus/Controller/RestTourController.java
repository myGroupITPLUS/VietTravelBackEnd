package com.itplus.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.itplus.Model.TourDTO;
import com.itplus.Service.TourService;

@RestController
@RequestMapping(value = "/tour",produces = "application/json")
public class RestTourController {
	
	@Autowired
	TourService tourService;

	@Autowired
	ObjectMapper objectMapper;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listAllTour(HttpServletRequest request) throws JsonProcessingException {
		List<TourDTO> list = tourService.getAllTour();
		return objectMapper.writeValueAsString(list);
	}

	@RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
	public String listTourByCategory(@PathVariable int id) throws JsonProcessingException {
		List<TourDTO> list = tourService.getTourByCategory(id);
		return objectMapper.writeValueAsString(list);
	}
}
