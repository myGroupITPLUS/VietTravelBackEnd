package com.itplus.Service;

import java.util.List;

import com.itplus.Model.CategoryDTO;

public interface CategoryService {
	List<CategoryDTO> getAllCategory();
	CategoryDTO getCategoryById(int id);
}
