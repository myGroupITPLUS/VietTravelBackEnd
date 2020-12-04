package com.itplus.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.itplus.dao.UudaiDao;
import com.itplus.entity.Uudai;

@Repository
public class UudaiImpl implements UudaiDao{
	
	private final String TABLE_NAME = "uudai";
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Uudai> getAllUudai() {
		String sqlString = "Select * from "+TABLE_NAME;
		List<Uudai> listUudai= jdbcTemplate.query(sqlString, new Object[] {},new RowMapper<Uudai>() {
			@Override
			public Uudai mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Uudai uudai = new Uudai();
				uudai.setMauudai(rs.getInt("mauudai"));
				uudai.setSale(rs.getString("sale"));
				uudai.setMota(rs.getString("mota"));
				uudai.setAnh(rs.getString("anh"));
				return uudai;
			}
			});
		return listUudai;
	}
	
}
