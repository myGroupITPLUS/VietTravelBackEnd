package com.itplus.Entity;

import com.itplus.Model.CategoryDTO;

public class Category {
	private int id;
	private String categoryname;
	private String descriptions;
	private String images;
	
	
	
	public Category() {
		
	}



	public Category(int id, String categoryname, String descriptions, String images) {
		super();
		this.id = id;
		this.categoryname = categoryname;
		this.descriptions = descriptions;
		this.images = images;
	}

	public CategoryDTO toCategoryDTO(){
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(this.getId());
		categoryDTO.setCategoryname(this.getCategoryname());
		categoryDTO.setDescriptions(this.getDescriptions());
		categoryDTO.setImages(this.getImages());
		return categoryDTO;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getCategoryname() {
		return categoryname;
	}



	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
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
