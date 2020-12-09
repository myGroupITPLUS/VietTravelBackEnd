package com.example.itplus.Controller;

import com.example.itplus.Model.CategoryDTO;
import com.example.itplus.Service.CategoryService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/category",produces = "application/json")
public class RestCategoryController {
	@Autowired
	CategoryService categoryService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listCategory(HttpServletRequest request) {
		List<CategoryDTO> cate = categoryService.getAllCategory();
		Gson gson = new Gson();
		return gson.toJson(cate);
	}

}
