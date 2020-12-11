package com.itplus.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.itplus.dao.UserDao;
import com.itplus.entity.User;


@Repository
public class UserDaoImpl implements UserDao{

	private final String TABLE_NAME = "user";
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		String sqlString = "Select * from "+TABLE_NAME;
		List<User> listUser= jdbcTemplate.query(sqlString, new Object[] {},new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getInt("phone"));
				user.setAddress(rs.getString("address"));
				user.setEmail(rs.getString("email"));
				return user;
			}
			});
		return listUser;
	}

}
