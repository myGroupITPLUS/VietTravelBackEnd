package com.itplus.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.itplus.dao.PromotionDao;
import com.itplus.entity.Promotion;

@Repository
public class PromotionDaoImpl implements PromotionDao{
	
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
	@Override
	public void addPromotion(Promotion promotion) {
		String sql = "insert into "+TABLE_NAME+"(sale,descriptions,images) values(?,?,?)";
		jdbcTemplate.update(sql,promotion.getSale(),promotion.getDescription(),promotion.getImages());				
	}
	@Override
	public void updatePromotion(Promotion promotion) {
		String sql = "update "+TABLE_NAME+" set sale = ?, descriptions = ?, images=? where id = ?";
		jdbcTemplate.update(sql, promotion.getSale(),promotion.getDescription(),promotion.getImages(),promotion.getImages(),promotion.getId());
		
	}
	@Override
	public Promotion getPromotionById(int id) {
		String sql = "select * from "+TABLE_NAME+" where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, new RowMapper<Promotion>(){
			@Override
			public Promotion mapRow(ResultSet rs, int rowNum) throws SQLException {
				Promotion promotion = new Promotion();
				promotion.setId(rs.getInt("id"));
				promotion.setSale(rs.getString("sale"));
				promotion.setDescription(rs.getString("descriptions"));
				promotion.setImages(rs.getString("images"));
				return promotion;
			}
		});
	}
	@Override
	public void deletePromotion(int id) {
		String sql = "delete from "+TABLE_NAME+" where id = ?";		
		jdbcTemplate.update(sql, id);
		
	}
	
}
