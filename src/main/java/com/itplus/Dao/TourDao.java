package com.itplus.Dao;

import java.util.List;

import com.itplus.Entity.Tour;

public interface TourDao {
	List<Tour> getAllTour();
	void addTour(Tour tour);
	void updateTour(Tour tour);
	Tour getTourById(int id);
	void deleteTour(int id);
}