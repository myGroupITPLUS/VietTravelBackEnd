package com.itplus.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itplus.dao.TourDao;
import com.itplus.entity.Tour;
import com.itplus.model.TourDTO;
import com.itplus.service.TourService;


@Service
public class TourServiceImpl implements TourService{

	@Autowired
	TourDao tourDao;
	
	@Override
	public List<TourDTO> getAllTour() {
		// TODO Auto-generated method stub
		
		List<TourDTO> listtourDTO = new ArrayList<TourDTO>();
		List<Tour> listTour = tourDao.getAllTour();
		for (Tour tour : listTour) {
			TourDTO tourDTO = new TourDTO();
			tourDTO.setTourid(tour.getTourid());
			tourDTO.setCategoryid(tour.getCategoryid());
			tourDTO.setUudaiid(tour.getUudaiid());
			tourDTO.setDiemdi(tour.getDiemdi());
			tourDTO.setDiemden(tour.getDiemden());
			tourDTO.setThoigiandi(tour.getThoigiandi());
			tourDTO.setThoigianve(tour.getThoigianve());
			tourDTO.setMota(tour.getMota());
			tourDTO.setAnh(tour.getAnh());
			tourDTO.setGia(tour.getGia());
			listtourDTO.add(tourDTO);
		}
		
		return listtourDTO;
	}

}
