package com.example.itplus.Service.Impl;


import com.example.itplus.Dao.CategoryDao;
import com.example.itplus.Entity.Category;
import com.example.itplus.Model.CategoryDTO;
import com.example.itplus.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDao categoryDao;
	@Override
	public List<CategoryDTO> getAllCategory() {
		// TODO Auto-generated method stub
		List<CategoryDTO> listCategoryDTO = new ArrayList<CategoryDTO>();
		List<Category> listCategory = categoryDao.getAllCategory();
		for (Category category : listCategory) {
			CategoryDTO categoryDTO = new CategoryDTO();
			categoryDTO.setId(category.getId());
			categoryDTO.setCategoryName(category.getCategoryName());
			categoryDTO.setDescriptions(category.getDescriptions());
			categoryDTO.setImages(category.getImages());
			listCategoryDTO.add(categoryDTO);
		}		
		return listCategoryDTO;
	}

	@Override
	public CategoryDTO getCategoryDetail(int id) {
		Category category = categoryDao.getCategoryDetail(id);
		if (category != null){
			return new CategoryDTO(category);
		}else{
			return null;
		}
	}

}
