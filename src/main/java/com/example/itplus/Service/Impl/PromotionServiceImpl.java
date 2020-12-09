package com.example.itplus.Service.Impl;

import com.example.itplus.Dao.PromotionDao;
import com.example.itplus.Entity.Promotion;
import com.example.itplus.Model.PromotionDTO;
import com.example.itplus.Service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PromotionServiceImpl implements PromotionService {
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
			promotionDTO.setDescription(promotion.getDescription());
			promotionDTO.setImages(promotion.getImages());
			listPromotionDTO.add(promotionDTO);
		}
		return listPromotionDTO;
	}
	
	

}
