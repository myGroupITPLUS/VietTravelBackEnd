package com.itplus.Controller;

import java.util.HashMap;
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

	@GetMapping(value = "/")
	public String listCategory() throws JsonProcessingException {
		List<CategoryDTO> cate = categoryService.getAllCategory();
		return objectMapper.writeValueAsString(cate);
	}


	@GetMapping(value = "/{id}/")
	public ResponseEntity<String> detailCategory(@PathVariable int id) throws JsonProcessingException {
		CategoryDTO categoryDTO = categoryService.getCategoryById(id);
		if (categoryDTO != null){
			return new ResponseEntity<String>(objectMapper.writeValueAsString(categoryDTO), HttpStatus.OK);
		}else {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}

}
