package com.itplus.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itplus.Dao.CategoryDao;
import com.itplus.Entity.Category;
import com.itplus.Model.CategoryDTO;
import com.itplus.Service.CategoryService;

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
			categoryDTO.setId(category.getId());
			categoryDTO.setCategoryName(category.getCategoryName());
			categoryDTO.setDescriptions(category.getDescriptions());
			categoryDTO.setImages(category.getImages());
			listCategoryDTO.add(categoryDTO);
		}		
		return listCategoryDTO;
	}

	@Override
	public CategoryDTO getCategoryById(int id) {
		Category category = categoryDao.getCategoryById(id);
		if (category != null){
			return category.toDTO();
		}else{
			return null;
		}
	}

}
