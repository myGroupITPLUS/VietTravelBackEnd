package com.itplus.Dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
			public Tour mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Tour tour = new Tour();
				tour.setId(rs.getInt("id"));
				tour.setCategoryid(rs.getInt("categoryid"));
				tour.setPromotionid(rs.getInt("promotionid"));
				tour.setName(rs.getString("name"));
				tour.setDiemdi(rs.getString("diemdi"));
				tour.setDiemden(rs.getString("diemden"));
				tour.setTimedi(rs.getString("timedi"));
				tour.setTimeve(rs.getString("timeve"));
				tour.setDescriptions(rs.getString("descriptions"));
				tour.setImages(rs.getString("images"));
				tour.setPrice(rs.getFloat("price"));
				return tour;
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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteTour(int id) {
		// TODO Auto-generated method stub
		
	}

}