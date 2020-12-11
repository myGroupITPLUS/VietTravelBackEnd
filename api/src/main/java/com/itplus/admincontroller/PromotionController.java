package com.itplus.admincontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itplus.model.PromotionDTO;
import com.itplus.service.PromotionService;

@Controller
@RequestMapping(value = "/admin/promotion")
public class PromotionController {
	@Autowired
	PromotionService proService;
	@RequestMapping(value = "/")
	public String getAll(HttpServletRequest request) {
		List<PromotionDTO> promotionDTO = proService.getAllPromotion();
		request.setAttribute("listPromotion", promotionDTO);
		
		return "promotion";
	}

}
