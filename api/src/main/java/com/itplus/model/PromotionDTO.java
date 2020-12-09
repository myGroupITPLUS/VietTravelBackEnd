package com.itplus.model;

public class PromotionDTO {
	private int id;
	private String sale;
	private String description;
	private String images;
	public PromotionDTO() {
		
	}
	public PromotionDTO(int id, String sale, String description, String images) {
		super();
		this.id = id;
		this.sale = sale;
		this.description = description;
		this.images = images;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSale() {
		return sale;
	}
	public void setSale(String sale) {
		this.sale = sale;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	
	
	
	
}
