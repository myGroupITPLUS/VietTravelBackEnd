package com.example.Controller;


import com.example.Service.CategoryService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/category",produces = "application/json")
public class CategoryController {
    @Autowired
    CategoryService categoryService;


    @GetMapping(value = "/")
    public String getCategoryList(){
        return new Gson().toJson(categoryService.getCategoryList());
    }
}
