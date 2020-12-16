package com.itplus.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itplus.Dao.TourDao;
import com.itplus.Entity.Tour;
import com.itplus.Model.TourDTO;
import com.itplus.Service.TourService;


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
			listtourDTO.add(tour.toTourDTO());
		}
		return listtourDTO;
	}

	@Override
	public List<TourDTO> getTourByCategory(int id) {
		List<TourDTO> listtourDTO = new ArrayList<TourDTO>();
		List<Tour> listTour = tourDao.getTourByCategory(id);
		for (Tour tour : listTour) {
			listtourDTO.add(tour.toTourDTO());
		}

		return listtourDTO;
	}

}
