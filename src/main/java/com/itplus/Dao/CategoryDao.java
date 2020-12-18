package com.itplus.Dao;

import java.util.List;

import com.itplus.Entity.Category;

public interface CategoryDao {
	List<Category> getAllCategory();
	void addCategory(Category category);
	void updateCategory(Category category);
	Category getCategoryById(int id);
	void deleteCategory(int id);
}
