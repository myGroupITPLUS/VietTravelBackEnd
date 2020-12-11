package com.itplus.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itplus.dao.BannerDao;
import com.itplus.entity.Banner;
import com.itplus.model.BannerDTO;
import com.itplus.service.BannerService;


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
