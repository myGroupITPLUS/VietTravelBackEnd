package com.example.itplus.Dao.Impl;

import com.example.itplus.Dao.PromotionDao;
import com.example.itplus.Entity.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PromotionDaoImpl implements PromotionDao {
	
	private final String TABLE_NAME = "promotion";
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Promotion> getAllPromotion() {
		String sqlString = "Select * from "+TABLE_NAME;
		List<Promotion> listPromotion= jdbcTemplate.query(sqlString, new Object[] {},new RowMapper<Promotion>() {
			@Override
			public Promotion mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Promotion promotion = new Promotion();
				promotion.setId(rs.getInt("id"));
				promotion.setSale(rs.getString("sale"));
				promotion.setDescription(rs.getString("descriptions"));
				promotion.setImages(rs.getString("images"));
				return promotion;
			}
			});
		return listPromotion;
	}
	
}
