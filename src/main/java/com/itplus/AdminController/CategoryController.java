package com.itplus.AdminController;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.itplus.Model.CategoryDTO;
import com.itplus.Service.CategoryService;

@Controller
@RequestMapping(value = "/admin/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getAllCategory(HttpServletRequest request) {
		List<CategoryDTO> listCategoryDTO = categoryService.getAllCategory();
		request.setAttribute("listCategory", listCategoryDTO);
		return "category";
	}
}
