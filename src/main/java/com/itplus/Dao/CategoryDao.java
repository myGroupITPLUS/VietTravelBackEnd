package com.itplus.Dao;

import java.util.List;

import com.itplus.Entity.Category;

public interface CategoryDao {
	List<Category> getAllCategory();
	Category getCategoryById(int id);
	void addCategory(Category category);
	void updateCategory(Category category);
	void deleteCategory(int id);
}
