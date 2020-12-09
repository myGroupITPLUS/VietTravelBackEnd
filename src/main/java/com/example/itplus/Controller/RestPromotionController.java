package com.example.itplus.Controller;

import com.example.itplus.Model.PromotionDTO;
import com.example.itplus.Service.PromotionService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/promotion",produces = "application/json")
public class RestPromotionController {
	@Autowired
	PromotionService promotionService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listUudai(HttpServletRequest request) {
		List<PromotionDTO> uudaiDTO = promotionService.getAllPromotion();
		Gson gson = new Gson();
		return gson.toJson(uudaiDTO);
	}
}
