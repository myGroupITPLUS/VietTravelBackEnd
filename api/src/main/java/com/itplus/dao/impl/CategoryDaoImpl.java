package com.itplus.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.itplus.dao.CategoryDao;
import com.itplus.entity.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao{
	
	private final String TABLE_NAME = "category";
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		String sqlString = "Select * from "+TABLE_NAME;
		List<Category> listCategory= jdbcTemplate.query(sqlString, new Object[] {},new RowMapper<Category>() {

			@Override
			public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setDescriptions(rs.getString("descriptions"));
				category.setImages(rs.getString("images"));
				return category;
			}
			});
		return listCategory;
	}

}
