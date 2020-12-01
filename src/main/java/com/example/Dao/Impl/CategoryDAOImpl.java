package com.example.Dao.Impl;

import com.example.Dao.CategoryDAO;
import com.example.Entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Category> getCategoryList() {
        String sql = "select * from category";
        List<Category> result = jdbcTemplate.query(sql, new Object[] { }, (rs, rowNum) -> {
            Category category = new Category();
            category.setCategoryID(rs.getInt("CategoryID"));
            category.setCategoryName(rs.getString("CategoryName"));
            category.setDescription(rs.getString("Description"));
            return category;
        });
        return result;
    }
}
