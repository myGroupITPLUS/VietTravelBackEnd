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
public class TourServiceImpl implements TourService {

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
    public void addTour(TourDTO tourDTO) {
        Tour tour = new Tour();
        tour.setCategoryid(tourDTO.getCategoryid());
        tour.setPromotionid(tourDTO.getPromotionid());
        tour.setName(tourDTO.getName());
        tour.setDiemdi(tourDTO.getDiemdi());
        tour.setDiemden(tourDTO.getDiemden());
        tour.setTimedi(tourDTO.getTimedi());
        tour.setTimeve(tourDTO.getTimeve());
        tour.setDescriptions(tourDTO.getDescriptions());
        tour.setImages(tourDTO.getImages());
        tour.setPrice(tourDTO.getPrice());
        tourDao.addTour(tour);

    }

    @Override
    public void updateTour(TourDTO tourDTO) {
        Tour tour = new Tour();
        tour.setId(tourDTO.getId());
        tour.setCategoryid(tourDTO.getCategoryid());
        tour.setPromotionid(tourDTO.getPromotionid());
        tour.setName(tourDTO.getName());
        tour.setDiemdi(tourDTO.getDiemdi());
        tour.setDiemden(tourDTO.getDiemden());
        tour.setTimedi(tourDTO.getTimedi());
        tour.setTimeve(tourDTO.getTimeve());
        tour.setDescriptions(tourDTO.getDescriptions());
        tour.setImages(tourDTO.getImages());
        tour.setPrice(tourDTO.getPrice());
        tourDao.updateTour(tour);
    }

    @Override
    public void deleteTour(int id) {

    }

    @Override
    public List<TourDTO> search(String q) {
        List<TourDTO> dtoList = new ArrayList<>();
        List<Tour> listTour = tourDao.search(q);
        for (Tour tour : listTour) {
            dtoList.add(tour.toTourDTO());
        }
        return dtoList;
    }

    @Override
    public List<TourDTO> getTourByCategory(int id) {
        List<TourDTO> dtoList = new ArrayList<>();
        List<Tour> listTour = tourDao.getTourByCategory(id);
        for (Tour tour : listTour) {
            dtoList.add(tour.toTourDTO());
        }

        return dtoList;
    }

    @Override
    public List<TourDTO> getTourByPromotion(int id) {
        List<TourDTO> dtoList = new ArrayList<>();
        List<Tour> listTour = tourDao.getTourByPromotion(id);
        for (Tour tour : listTour) {
            dtoList.add(tour.toTourDTO());
        }

        return dtoList;
    }

    @Override
    public List<TourDTO> listTourHasPromotion() {
        List<TourDTO> dtoList = new ArrayList<>();
        List<Tour> listTour = tourDao.listTourHasPromotion();
        for (Tour tour : listTour) {
            dtoList.add(tour.toTourDTO());
        }
        return dtoList;
    }

    @Override
    public TourDTO getTourById(int id) {
        Tour tour = tourDao.getTourById(id);
        if (tour != null) {
            return tour.toTourDTO();
        } else {
            return null;
        }
    }

}
