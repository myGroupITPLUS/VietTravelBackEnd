package com.itplus.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.itplus.dao.TourDao;
import com.itplus.entity.Tour;

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
				tour.setTourid(rs.getInt("matour"));
				tour.setCategoryid(rs.getInt("macategory"));
				tour.setUudaiid(rs.getInt("mauudai"));
				tour.setDiemdi(rs.getString("diemdi"));
				tour.setDiemden(rs.getString("diemden"));
				tour.setThoigiandi(rs.getString("thoigiandi"));
				tour.setThoigianve(rs.getString("thoigianve"));
				tour.setMota(rs.getString("mota"));
				tour.setAnh(rs.getString("anh"));
				tour.setGia(rs.getFloat("gia"));
				return tour;
			}
			});
		return listTour;
	}

}
