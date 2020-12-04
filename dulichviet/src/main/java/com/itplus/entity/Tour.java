package com.itplus.entity;

public class Tour {
	private int tourid;
	private int categoryid;
	private int uudaiid;
	private String diemdi;
	private String diemden;
	private String thoigiandi;
	private String thoigianve;
	private String mota;
	private String anh;
	private float gia;
	
	public Tour() {
		
	}

	public Tour(int tourid, int categoryid, int uudaiid, String diemdi, String diemden, String thoigiandi,
			String thoigianve, String mota, String anh, float gia) {
		super();
		this.tourid = tourid;
		this.categoryid = categoryid;
		this.uudaiid = uudaiid;
		this.diemdi = diemdi;
		this.diemden = diemden;
		this.thoigiandi = thoigiandi;
		this.thoigianve = thoigianve;
		this.mota = mota;
		this.anh = anh;
		this.gia = gia;
	}

	public int getTourid() {
		return tourid;
	}

	public void setTourid(int tourid) {
		this.tourid = tourid;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public int getUudaiid() {
		return uudaiid;
	}

	public void setUudaiid(int uudaiid) {
		this.uudaiid = uudaiid;
	}

	public String getDiemdi() {
		return diemdi;
	}

	public void setDiemdi(String diemdi) {
		this.diemdi = diemdi;
	}

	public String getDiemden() {
		return diemden;
	}

	public void setDiemden(String diemden) {
		this.diemden = diemden;
	}

	public String getThoigiandi() {
		return thoigiandi;
	}

	public void setThoigiandi(String thoigiandi) {
		this.thoigiandi = thoigiandi;
	}

	public String getThoigianve() {
		return thoigianve;
	}

	public void setThoigianve(String thoigianve) {
		this.thoigianve = thoigianve;
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

	public float getGia() {
		return gia;
	}

	public void setGia(float gia) {
		this.gia = gia;
	}
	
	
	
	
}
