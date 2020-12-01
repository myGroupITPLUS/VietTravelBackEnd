package com.example.Service.Impl;

import com.example.Dao.CategoryDAO;
import com.example.Entity.Category;
import com.example.Model.CategoryDTO;
import com.example.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDAO categoryDAO;

    @Override
    public List<CategoryDTO> getCategoryList() {
        List<Category> list = categoryDAO.getCategoryList();
        List<CategoryDTO> result = new ArrayList<>();
        for (Category category: list) {
            result.add(category.toDTO());
        }
        return result;
    }
}
