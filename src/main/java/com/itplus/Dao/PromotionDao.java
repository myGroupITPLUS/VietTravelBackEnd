package com.itplus.Dao;

import java.util.List;

import com.itplus.Entity.Promotion;

public interface PromotionDao {
	List<Promotion> getAllPromotion();
	void addPromotion(Promotion promotion);
	void updatePromotion(Promotion promotion);
	Promotion getPromotionById(int id);
	void deletePromotion(int id);
}
