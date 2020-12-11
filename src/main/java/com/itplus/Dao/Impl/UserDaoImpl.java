package com.itplus.Dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.itplus.Dao.UserDao;
import com.itplus.Entity.User;


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
				user.setPhone(rs.getString("phone"));
				user.setAddress(rs.getString("address"));
				user.setEmail(rs.getString("email"));
				return user;
			}
			});
		return listUser;
	}
	@Override
	public void addUser(User user) {
		String sql = "insert into "+TABLE_NAME+"(username,password,phone,address,email) values(?,?,?,?,?)";
		jdbcTemplate.update(sql, user.getUsername(), user.getPassword(),user.getPhone(),user.getAddress(),user.getEmail());
		
	}
	@Override
	public void updateUser(User user) {
		String sql = "update "+TABLE_NAME+" set username= ?, password = ?, phone = ?, address=?, email=? where id = ?";
		jdbcTemplate.update(sql, user.getUsername(), user.getPassword(),user.getPhone(),user.getAddress(),user.getEmail(), user.getId());
		
	}
	@Override
	public User getUserById(int id) {
		String sql = "select * from "+TABLE_NAME+" where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setAddress(rs.getString("address"));
				user.setEmail(rs.getString("email"));
				return user;
			}
		});
	}
	@Override
	public void deleteUser(int id) {
		String sql = "delete from "+TABLE_NAME+" where id = ?";		
		jdbcTemplate.update(sql, id);		
	}

	@Override
	public HashMap<String, Object> register(User user) {
		HashMap<String, Object> result = new HashMap<>();
		String sql = "Select * from " + TABLE_NAME + " where email = ?";
		User check;
		try {
			check = jdbcTemplate.queryForObject(sql, new String[]{user.getEmail()}, new RowMapper<User>() {
				@Override
				public User mapRow(ResultSet resultSet, int i) {
					User user = new User();
					try {
						user.setId(resultSet.getInt("id"));
						user.setAddress(resultSet.getString("address"));
						user.setUsername(resultSet.getString("username"));
						user.setEmail(resultSet.getString("email"));
						user.setPassword(resultSet.getString("password"));
						user.setPhone(resultSet.getString("phone"));
						return user;
					} catch (SQLException throwable) {
						return null;
					}
				}
			});
		} catch (EmptyResultDataAccessException exception){
			check =null;
		}

		if (check != null) {
			result.put("success", false);
			result.put("massage", "Email is exists");
		} else {
			sql = "INSERT INTO " + TABLE_NAME + " (username, email, password) VALUE (?, ?, ?)";
		}

		return null;
	}

	@Override
	public User getUserByEmail(String email) {
		String sql = "Select * from " + TABLE_NAME + " where email = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new String[]{email}, new RowMapper<User>() {
				@Override
				public User mapRow(ResultSet resultSet, int i) {
					User user = new User();
					try {
						user.setId(resultSet.getInt("id"));
						user.setAddress(resultSet.getString("address"));
						user.setUsername(resultSet.getString("username"));
						user.setEmail(resultSet.getString("email"));
						user.setPassword(resultSet.getString("password"));
						user.setPhone(resultSet.getString("phone"));
						return user;
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