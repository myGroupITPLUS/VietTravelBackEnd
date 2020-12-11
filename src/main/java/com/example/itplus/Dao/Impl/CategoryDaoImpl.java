package com.example.itplus.Dao.Impl;


import com.example.itplus.Dao.CategoryDao;
import com.example.itplus.Entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	
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
				category.setCategoryName(rs.getString("categoryName"));
				category.setDescriptions(rs.getString("descriptions"));
				category.setImages(rs.getString("images"));
				return category;
			}
			});
		return listCategory;
	}

	@Override
	public Category getCategoryDetail(int id) {
		String query = "Select * from " + TABLE_NAME + " Where id = ?";
		try {
			return jdbcTemplate.queryForObject(query, new Integer[]{id}, new RowMapper<Category>() {
				@Override
				public Category mapRow(ResultSet resultSet, int i){
					Category category = new Category();
					try {
						category.setId(resultSet.getInt("id"));
						category.setCategoryName(resultSet.getString("categoryName"));
						category.setDescriptions(resultSet.getString("descriptions"));
						category.setImages(resultSet.getString("images"));
						return category;
					} catch (SQLException throwable) {
						return null;
					}
				}
			});
		} catch (EmptyResultDataAccessException exception){
			return null;
		}
	}

}
