package com.itplus.admincontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itplus.model.TourDTO;
import com.itplus.service.TourService;

@Controller
@RequestMapping(value = "/admin/tour")
public class TourController {
	
	@Autowired
	TourService tourService;
	
	@RequestMapping(value = "/")
	public String getAllTour(HttpServletRequest request) {
		List<TourDTO> listTourDTO = tourService.getAllTour();
		request.setAttribute("listTour", listTourDTO);
		return "tour";
	}
}
