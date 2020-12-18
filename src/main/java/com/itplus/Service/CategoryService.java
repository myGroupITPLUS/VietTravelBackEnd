package com.itplus.Service;

import java.util.List;

import com.itplus.Model.CategoryDTO;

public interface CategoryService {
	List<CategoryDTO> getAllCategory();
	void addCategory(CategoryDTO categoryDTO);
	void updateCategory(CategoryDTO categoryDTO);
	CategoryDTO getCategoryById(int id);
	void deleteCategory(int id);
	
}
