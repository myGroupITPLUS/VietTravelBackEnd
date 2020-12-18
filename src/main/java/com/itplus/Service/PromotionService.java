package com.itplus.Service;

import java.util.List;

import com.itplus.Model.PromotionDTO;

public interface PromotionService {
	List<PromotionDTO> getAllPromotion();
	void addPromotion(PromotionDTO promotionDTO);
	void updatePromotion(PromotionDTO promotionDTO);
	PromotionDTO getPromotionById(int id);
	void deletePromotion(int id);
}
