package com.itplus.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itplus.Dao.BannerDao;
import com.itplus.Entity.Banner;
import com.itplus.Model.BannerDTO;
import com.itplus.Service.BannerService;


@Service
public class BannerServiceImpl implements BannerService{

	@Autowired
	BannerDao bannerDao;
	@Override
	public List<BannerDTO> getAllBanner() {
		// TODO Auto-generated method stub
		List<BannerDTO> listBannerDTO = new ArrayList<BannerDTO>();
		List<Banner> listBanner = bannerDao.getAllBanner();
		for (Banner banner : listBanner) {
			BannerDTO bannerDTO = new BannerDTO();
			bannerDTO.setId(banner.getId());
			bannerDTO.setName(banner.getName());
			bannerDTO.setDescriptions(banner.getDescriptions());
			bannerDTO.setUrl(banner.getUrl());
			bannerDTO.setImages(banner.getImages());
			listBannerDTO.add(bannerDTO);
		}		
		return listBannerDTO;
	}
	
}
