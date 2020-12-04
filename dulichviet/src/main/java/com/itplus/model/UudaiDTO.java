package com.itplus.model;

public class UudaiDTO {
	private int mauudai;
	private String sale;
	private String mota;
	private String anh;
	public UudaiDTO() {
		
	}
	public UudaiDTO(int mauudai, String sale, String mota, String anh) {
		super();
		this.mauudai = mauudai;
		this.sale = sale;
		this.mota = mota;
		this.anh = anh;
	}
	public int getMauudai() {
		return mauudai;
	}
	public void setMauudai(int mauudai) {
		this.mauudai = mauudai;
	}
	public String getSale() {
		return sale;
	}
	public void setSale(String sale) {
		this.sale = sale;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	
	
}
