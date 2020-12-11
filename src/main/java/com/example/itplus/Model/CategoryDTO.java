package com.example.itplus.Model;

import com.example.itplus.Entity.Category;

public class CategoryDTO {
    private int id;
    private String categoryName;
    private String descriptions;
    private String images;

    public CategoryDTO() {

    }

    public CategoryDTO(int id, String categoryName, String descriptions, String images) {
        super();
        this.id = id;
        this.categoryName = categoryName;
        this.descriptions = descriptions;
        this.images = images;
    }

    public CategoryDTO(Category category){
        super();
        this.id = category.getId();
        this.categoryName = category.getCategoryName();
        this.descriptions = category.getDescriptions();
        this.images = category.getImages();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

}
