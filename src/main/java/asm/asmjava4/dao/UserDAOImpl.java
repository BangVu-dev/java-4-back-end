/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm.asmjava4.dao;

import asm.asmjava4.model.Category;
import asm.asmjava4.model.Product;
import asm.asmjava4.model.ProductWithDetail;
import asm.asmjava4.model.User;
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
public class UserDAOImpl implements UserDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public User login(User user) {
        return jdbcTemplate.queryForObject("select userId, userName, email, role from users "
                + "where userName=? and password=?", new BeanPropertyRowMapper<User>(User.class), user.getUserName(),
                user.getPassword());
    }

    @Override
    public User add(User user) {
        jdbcTemplate.update("INSERT INTO users(userName, password, email, role) VALUES(?, ?, ?, ?)",
                new Object[]{user.getUserName(), user.getPassword(), user.getEmail(), "user"});
        return login(user);
    }

    @Override
    public User update(User user, int id) {
        jdbcTemplate.update("update users set userName=?, email=? where userId=?",
                new Object[]{user.getUserName(), user.getEmail(), id});
        return jdbcTemplate.queryForObject("select userId, userName, email, role from users "
                + "where userName=?", new BeanPropertyRowMapper<User>(User.class), user.getUserName());
    }

}
