package com.itplus.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itplus.Dao.PromotionDao;
import com.itplus.Entity.Promotion;
import com.itplus.Model.PromotionDTO;
import com.itplus.Service.PromotionService;


@Service
public class PromotionServiceImpl implements PromotionService{
	@Autowired
	PromotionDao promotionDao;
	@Override
	public List<PromotionDTO> getAllPromotion() {
		List<PromotionDTO> listPromotionDTO = new ArrayList<PromotionDTO>();
		List<Promotion> listPromotion = promotionDao.getAllPromotion();
		for (Promotion promotion : listPromotion) {
			PromotionDTO promotionDTO = new PromotionDTO();
			promotionDTO.setId(promotion.getId());
			promotionDTO.setSale(promotion.getSale());
			promotionDTO.setDescriptions(promotion.getDescription());
			promotionDTO.setImages(promotion.getImages());
			listPromotionDTO.add(promotionDTO);
		}
		return listPromotionDTO;
	}
	
	

}
