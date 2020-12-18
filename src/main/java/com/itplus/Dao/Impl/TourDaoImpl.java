package com.itplus.Dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itplus.Entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.itplus.Dao.TourDao;
import com.itplus.Entity.Tour;

@Repository
public class TourDaoImpl implements TourDao{
	private final String TABLE_NAME = "tour";
	private final int PRICE_DIFFERENCE = 100000;
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Tour> getAllTour() {
		String sql = "Select * from "+TABLE_NAME;
		List<Tour> listTour = jdbcTemplate.query(sql, new Object[] {}, new RowMapper<Tour>(){

			@Override
			public Tour mapRow(ResultSet rs, int rowNum){
				return mapTour(rs);
			}
			});
		return listTour;
	}

	@Override
	public List<Tour> search(String q) {
		String queryName = "Select * from " + TABLE_NAME + " Where name LIKE N'%%%s%%'";
		String queryPrice = "Select * from " + TABLE_NAME + " Where price >= %f and price <= %f";
		String query;
		try {
			double price = Double.parseDouble(q);
			query = String.format(queryPrice, price - PRICE_DIFFERENCE, price + PRICE_DIFFERENCE);
		}catch (NumberFormatException e){
			query = String.format(queryName, q);
		}

		try {
			return jdbcTemplate.query(query, new RowMapper<Tour>() {
				@Override
				public Tour mapRow(ResultSet resultSet, int i){
					return mapTour(resultSet);
				}
			});
		} catch (EmptyResultDataAccessException exception){
			return new ArrayList<Tour>();
		}
	}

	@Override
	public void addTour(Tour tour) {
		String sql = "insert into "+TABLE_NAME+"(categoryid,tourid,name,diemdi,diemden,timedi,timeve,descriptions,images,price) values(?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,tour.getCategoryid(),tour.getPromotionid(),tour.getName(),tour.getDiemdi(),tour.getDiemden(),tour.getTimedi(),tour.getTimeve(),tour.getDescriptions(),tour.getImages(),tour.getPrice());	
		
	}
	@Override
	public void updateTour(Tour tour) {
		String sql = "update "+TABLE_NAME+" set categoryid = ?, tourid = ?, name=?, diemdi=?, diemden=?, timedi=?, timeve=?, descriptions=?, images=?, price=? where id = ?";
		jdbcTemplate.update(sql, tour.getCategoryid(),tour.getPromotionid(),tour.getName(),tour.getDiemdi(),tour.getDiemden(),tour.getTimedi(),tour.getTimeve(),tour.getDescriptions(),tour.getImages(),tour.getPrice(),tour.getId());
		
	}
	@Override
	public Tour getTourById(int id) {
		String query = "Select * from " + TABLE_NAME + " Where id = ?";
		try {
			return jdbcTemplate.queryForObject(query, new Integer[]{id}, new RowMapper<Tour>() {
				@Override
				public Tour mapRow(ResultSet resultSet, int i){
					return mapTour(resultSet);
				}
			});
		} catch (EmptyResultDataAccessException exception){
			return null;
		}
	}
	@Override
	public void deleteTour(int id) {
		String sql = "delete from "+TABLE_NAME+" where id = ?";		
		jdbcTemplate.update(sql, id);
		
	}

	private Tour mapTour(ResultSet resultSet) {
		Tour tour = new Tour();
		try {
			tour.setId(resultSet.getInt("id"));
			tour.setCategoryid(resultSet.getInt("categoryid"));
			tour.setPromotionid(resultSet.getInt("promotionid"));
			tour.setName(resultSet.getString("name"));
			tour.setDiemdi(resultSet.getString("diemdi"));
			tour.setDiemden(resultSet.getString("diemden"));
			tour.setTimedi(resultSet.getString("timedi"));
			tour.setTimeve(resultSet.getString("timeve"));
			tour.setDescriptions(resultSet.getString("descriptions"));
			tour.setImages(resultSet.getString("images"));
			tour.setPrice(resultSet.getFloat("price"));
			return tour;
		} catch (SQLException throwable) {
			return null;
		}
	}

	@Override
	public List<Tour> getTourByCategory(int id) {
		String query = "Select * from " + TABLE_NAME + " Where categoryid = ?";
		try {
			return jdbcTemplate.query(query, new Integer[]{id}, new RowMapper<Tour>() {
				@Override
				public Tour mapRow(ResultSet resultSet, int i){
					return mapTour(resultSet);
				}
			});
		} catch (EmptyResultDataAccessException exception){
			return new ArrayList<Tour>();
		}
	}


	@Override
	public List<Tour> listTourHasPromotion() {
		String query = "Select * from " + TABLE_NAME + " Where promotionid IS NOT NULL";
		try {
			return jdbcTemplate.query(query, new RowMapper<Tour>() {
				@Override
				public Tour mapRow(ResultSet resultSet, int i){
					return mapTour(resultSet);
				}
			});
		} catch (EmptyResultDataAccessException exception){
			return new ArrayList<Tour>();
		}
	}

}
