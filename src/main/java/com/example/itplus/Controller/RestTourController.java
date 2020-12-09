package com.example.itplus.Controller;

import com.example.itplus.Model.TourDTO;
import com.example.itplus.Service.TourService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/tour",produces = "application/json")
public class RestTourController {
	
	@Autowired
	TourService tourService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listTour(HttpServletRequest request) {
		List<TourDTO> tour = tourService.getAllTour();
		Gson gson = new Gson();
		return gson.toJson(tour);
	}
}
