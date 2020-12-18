package com.itplus.Dao;

import java.util.List;

import com.itplus.Entity.Banner;

public interface BannerDao {
	List<Banner> getAllBanner();
	void addBanner(Banner banner);
	void updateBanner(Banner banner);
	Banner getBannerById(int id);
	void deleteBanner(int id);
}
