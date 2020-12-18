package com.itplus.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.itplus.Model.BannerDTO;
import com.itplus.Service.BannerService;

@RestController
@RequestMapping(value = "/banner",produces = "application/json")
public class RestBannerController {
	@Autowired
	BannerService bannerService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listBanner(HttpServletRequest request) {
		List<BannerDTO> banner = bannerService.getAllBanner();
		Gson gson = new Gson();
		return gson.toJson(banner);
	}
}
