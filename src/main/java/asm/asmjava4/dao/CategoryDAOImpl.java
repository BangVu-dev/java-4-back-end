/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm.asmjava4.dao;

import asm.asmjava4.model.Category;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PC
 */
@Repository
public class CategoryDAOImpl implements CategoryDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int add(Category cate) {
        return jdbcTemplate.update("INSERT INTO category(categoryName, description, image) VALUES(?, ?, ?)", new Object[]{cate.getCategoryName(), cate.getDescription(), cate.getImage()});
    }

    @Override
    public int update(Category cate, int id) {
        return jdbcTemplate.update("UPDATE category set categoryName=?, description=?, image =? where categoryId=?", new Object[]{cate.getCategoryName(), cate.getDescription(), cate.getImage(), id});
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE from category where categoryId=?", id);
    }

    @Override
    public List<Category> getAll() {
        return jdbcTemplate.query("select * from category ORDER BY categoryId DESC", new BeanPropertyRowMapper<Category>(Category.class));
    }

    @Override
    public Category getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM category where categoryId=?", new BeanPropertyRowMapper<Category>(Category.class), id);
    }

}
