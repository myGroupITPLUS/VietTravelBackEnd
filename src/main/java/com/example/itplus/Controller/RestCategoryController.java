package com.example.itplus.Controller;

import com.example.itplus.Model.CategoryDTO;
import com.example.itplus.Service.CategoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/category", produces = "application/json")
public class RestCategoryController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping(value = "/")
    public String listCategory() {
        List<CategoryDTO> list = categoryService.getAllCategory();
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @GetMapping(value = "/{id}/")
    public ResponseEntity<String> getDetailCategory(@PathVariable int id) throws JsonProcessingException {
        CategoryDTO categoryDTO = categoryService.getCategoryDetail(id);
        if (categoryDTO != null){
            return new ResponseEntity<String>(objectMapper.writeValueAsString(categoryDTO), HttpStatus.OK);
        }else {
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
    }

}
