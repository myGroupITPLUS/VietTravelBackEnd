package com.example.itplus.Entity;

public class Category {
    private int id;
    private String categoryName;
    private String descriptions;
    private String images;


    public Category() {

    }

    public Category(int id, String categoryName, String descriptions, String images) {
        super();
        this.id = id;
        this.categoryName = categoryName;
        this.descriptions = descriptions;
        this.images = images;
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
