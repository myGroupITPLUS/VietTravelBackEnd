package com.itplus.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.itplus.dao.BannerDao;
import com.itplus.entity.Banner;

@Repository
public class BannerDaoImpl implements BannerDao{
	
	private final String TABLE_NAME = "banner";
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Banner> getAllBanner() {
		// TODO Auto-generated method stub
		String sqlString = "Select * from "+TABLE_NAME;
		List<Banner> listBanner = jdbcTemplate.query(sqlString, new Object[] {},new RowMapper<Banner>() {

			@Override
			public Banner mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Banner banner = new Banner();
				banner.setId(rs.getInt("id"));
				banner.setName(rs.getString("name"));
				banner.setDescriptions(rs.getString("descriptions"));
				banner.setUrl(rs.getString("url"));
				banner.setImages(rs.getString("images"));
				return banner;
			}
			});
		return listBanner;
	}
	
}
