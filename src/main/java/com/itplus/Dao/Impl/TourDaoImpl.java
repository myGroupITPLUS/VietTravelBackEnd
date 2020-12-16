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
	public void addTour(Tour tour) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateTour(Tour tour) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
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

}
