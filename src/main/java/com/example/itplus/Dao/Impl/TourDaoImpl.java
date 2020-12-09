package com.example.itplus.Dao.Impl;


import com.example.itplus.Dao.TourDao;
import com.example.itplus.Entity.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TourDaoImpl implements TourDao {
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

}
