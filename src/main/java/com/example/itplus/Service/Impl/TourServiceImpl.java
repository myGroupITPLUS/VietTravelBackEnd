package com.example.itplus.Service.Impl;

import com.example.itplus.Dao.TourDao;
import com.example.itplus.Entity.Tour;
import com.example.itplus.Model.TourDTO;
import com.example.itplus.Service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TourServiceImpl implements TourService {

	@Autowired
	TourDao tourDao;
	
	@Override
	public List<TourDTO> getAllTour() {
		// TODO Auto-generated method stub
		
		List<TourDTO> listtourDTO = new ArrayList<TourDTO>();
		List<Tour> listTour = tourDao.getAllTour();
		for (Tour tour : listTour) {
			TourDTO tourDTO = new TourDTO();
			tourDTO.setId(tour.getId());
			tourDTO.setCategoryid(tour.getCategoryid());
			tourDTO.setPromotionid(tour.getPromotionid());
			tourDTO.setName(tour.getName());
			tourDTO.setDiemdi(tour.getDiemdi());
			tourDTO.setDiemden(tour.getDiemden());
			tourDTO.setTimedi(tour.getTimedi());
			tourDTO.setTimeve(tour.getTimeve());
			tourDTO.setDescriptions(tour.getDescriptions());
			tourDTO.setImages(tour.getImages());
			tourDTO.setPrice(tour.getPrice());
			listtourDTO.add(tourDTO);
		}
		
		return listtourDTO;
	}

}
