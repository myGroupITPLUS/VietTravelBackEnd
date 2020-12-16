package com.itplus.Controller;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.sonatype.inject.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.itplus.Model.TourDTO;
import com.itplus.Service.TourService;

@RestController
@RequestMapping(value = "/tour",produces = "application/json")
public class RestTourController {
	
	@Autowired
	TourService tourService;

	@Autowired
	ObjectMapper objectMapper;

	@GetMapping(value = "/")
	public String listAllTour(@Nullable @RequestParam String q) throws JsonProcessingException {
		List<TourDTO> list;
		if (q != null) {
			list = tourService.search(q);
		}else{
			list = tourService.getAllTour();
		}
		return objectMapper.writeValueAsString(list);
	}

	@GetMapping(value = "/category/{id}/")
	public String listTourByCategory(@PathVariable int id) throws JsonProcessingException {
		List<TourDTO> list = tourService.getTourByCategory(id);
		return objectMapper.writeValueAsString(list);
	}

	@GetMapping(value = "/{id}/")
	public String listTourById(@PathVariable int id) throws JsonProcessingException {
		TourDTO list = tourService.getTourById(id);
		return objectMapper.writeValueAsString(list);
	}
}
