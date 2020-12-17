package com.itplus.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itplus.dao.PromotionDao;
import com.itplus.entity.Promotion;
import com.itplus.model.PromotionDTO;
import com.itplus.service.PromotionService;


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
	@Override
	public void addPromotion(PromotionDTO promotionDTO) {
		Promotion promotion = new Promotion();
		promotion.setSale(promotionDTO.getSale());
		promotion.setDescription(promotionDTO.getDescriptions());
		promotion.setImages(promotionDTO.getImages());
		promotionDao.addPromotion(promotion);		
	}
	@Override
	public void updatePromotion(PromotionDTO promotionDTO) {
		Promotion promotion = new Promotion();
		promotion.setId(promotionDTO.getId());
		promotion.setSale(promotionDTO.getSale());
		promotion.setDescription(promotionDTO.getDescriptions());
		promotion.setImages(promotionDTO.getImages());
		promotionDao.updatePromotion(promotion);
		
	}
	@Override
	public PromotionDTO getPromotionById(int id) {
		Promotion promotion = promotionDao.getPromotionById(id);
		PromotionDTO promotionDTO = new PromotionDTO();
		promotionDTO.setId(promotion.getId());
		promotionDTO.setSale(promotion.getSale());
		promotionDTO.setDescriptions(promotion.getDescription());
		promotionDTO.setImages(promotion.getImages());
		return promotionDTO;
	}
	@Override
	public void deletePromotion(int id) {
		promotionDao.deletePromotion(id);
		
	}
	
	

}
