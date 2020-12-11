package com.itplus.Model;

public class PromotionDTO {
	private int id;
	private String sale;
	private String descriptions;
	private String images;
	public PromotionDTO() {
		
	}
	public PromotionDTO(int id, String sale, String descriptions, String images) {
		super();
		this.id = id;
		this.sale = sale;
		this.descriptions = descriptions;
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
