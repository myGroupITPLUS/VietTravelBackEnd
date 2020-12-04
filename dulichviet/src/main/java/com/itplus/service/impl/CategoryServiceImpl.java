package com.itplus.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itplus.dao.CategoryDao;
import com.itplus.entity.Category;
import com.itplus.model.CategoryDTO;
import com.itplus.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryDao categoryDao;
	@Override
	public List<CategoryDTO> getAllCategory() {
		// TODO Auto-generated method stub
		List<CategoryDTO> listCategoryDTO = new ArrayList<CategoryDTO>();
		List<Category> listCategory = categoryDao.getAllCategory();
		for (Category category : listCategory) {
			CategoryDTO categoryDTO = new CategoryDTO();
			categoryDTO.setCategoryid(category.getCategoryid());
			categoryDTO.setCategoryname(category.getCategoryname());
			categoryDTO.setMota(category.getMota());
			categoryDTO.setImg(category.getImg());
			listCategoryDTO.add(categoryDTO);
		}		
		return listCategoryDTO;
	}

}
