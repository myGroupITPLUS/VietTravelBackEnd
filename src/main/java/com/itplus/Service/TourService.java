package com.itplus.Service;

import java.util.List;

import com.itplus.Model.TourDTO;

public interface TourService {
	List<TourDTO> getAllTour();
	void addTour(TourDTO tourDTO);
	void updateTour(TourDTO tourDTO);
	void deleteTour(int id);
	List<TourDTO> search(String q);
	List<TourDTO> getTourByCategory(int id);
	TourDTO getTourById(int id);
}
