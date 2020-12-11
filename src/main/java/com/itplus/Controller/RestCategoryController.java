package com.itplus.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;
import com.itplus.Service.CategoryService;

import com.itplus.Model.CategoryDTO;

@RestController
@RequestMapping(value = "/category",produces = "application/json")
public class RestCategoryController {
	@Autowired
	CategoryService categoryService;

	@Autowired
	ObjectMapper objectMapper;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listCategory(HttpServletRequest request) {
		List<CategoryDTO> cate = categoryService.getAllCategory();
		Gson gson = new Gson();
		return gson.toJson(cate);
	}

	@GetMapping(value = "/{id}/")
	public ResponseEntity<String> getDetailCategory(@PathVariable int id) throws JsonProcessingException {
		CategoryDTO categoryDTO = categoryService.getCategoryById(id);
		if (categoryDTO != null){
			return new ResponseEntity<String>(objectMapper.writeValueAsString(categoryDTO), HttpStatus.OK);
		}else {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}

}
