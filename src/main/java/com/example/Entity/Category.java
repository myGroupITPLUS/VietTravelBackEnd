package com.example.Entity;

import com.example.Model.CategoryDTO;

public class Category {
    private int categoryID;
    private String categoryName;
    private String description;

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category() {
    }

    public CategoryDTO toDTO(){
        CategoryDTO dto = new CategoryDTO();
        dto.setCategoryID(this.categoryID);
        dto.setDescription(this.description);
        dto.setCategoryName(this.categoryName);
        return dto;
    }
}
