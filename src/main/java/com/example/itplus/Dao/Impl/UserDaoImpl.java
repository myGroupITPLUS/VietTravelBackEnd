package com.example.itplus.Dao.Impl;

import com.example.itplus.Dao.UserDao;
import com.example.itplus.Entity.User;
import com.example.itplus.Model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String TABLE_NAME = "user";

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
