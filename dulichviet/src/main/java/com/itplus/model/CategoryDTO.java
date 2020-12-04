package com.itplus.model;

public class CategoryDTO {
	private int categoryid;
	private String categoryname;
	private String mota;
	private String img;
	
	
	
	public CategoryDTO() {
		// TODO Auto-generated constructor stub
	}
	public CategoryDTO(int categoryid, String categoryname, String mota, String img) {
		super();
		this.categoryid = categoryid;
		this.categoryname = categoryname;
		this.mota = mota;
		this.img = img;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
}
