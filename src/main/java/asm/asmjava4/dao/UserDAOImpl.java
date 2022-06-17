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
import utils.PasswordHelper;
import utils.SendMail;

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

    public User isExitUserName(User user) {
        try {
            return jdbcTemplate.queryForObject("select * from users where userName = ?", new BeanPropertyRowMapper<User>(User.class), user.getUserName());
        } catch (Exception e) {
            return null;
        }
    }

    public User isExitEmail(User user) {
        try {
            return jdbcTemplate.queryForObject("select * from users where email = ?", new BeanPropertyRowMapper<User>(User.class), user.getEmail());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public User add(User user) {
        if (isExitUserName(user) == null && isExitEmail(user) == null) {
            try {
                SendMail.sendEmailWhenRegister(user.getEmail());
                jdbcTemplate.update("INSERT INTO users(userName, password, email, role) VALUES(?, ?, ?, ?)",
                        new Object[]{user.getUserName(), user.getPassword(), user.getEmail(), "user"});
                return login(user);
            } catch (Exception e) {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public User update(User user, int id) {
        jdbcTemplate.update("update users set userName=?, email=? where userId=?",
                new Object[]{user.getUserName(), user.getEmail(), id});
        return jdbcTemplate.queryForObject("select userId, userName, email, role from users "
                + "where userName=?", new BeanPropertyRowMapper<User>(User.class), user.getUserName());
    }

    @Override
    public List<User> getAll() {
        return jdbcTemplate.query("select * from users ORDER BY userId DESC", new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public User addAccount(User user) {
        jdbcTemplate.update("INSERT INTO users(userName, password, email, role) VALUES(?, ?, ?, ?)",
                new Object[]{user.getUserName(), user.getPassword(), user.getEmail(), user.getRole()});
        return login(user);
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE from users where userId=?", id);
    }

    @Override
    public User updateAccount(User user, int id) {
        jdbcTemplate.update("update users set userName=?, password=?, email=?, role=? where userId=?",
                new Object[]{user.getUserName(), user.getPassword(), user.getEmail(), user.getRole(), id});
        return jdbcTemplate.queryForObject("select userId, userName, email, role from users "
                + "where userName=?", new BeanPropertyRowMapper<User>(User.class), user.getUserName());
    }

    @Override
    public int sendPassword(String email) {
        try {
            String newPass = "123456";
            String password_hash = PasswordHelper.encrypt(newPass);
            SendMail.sendPassword(email, newPass);
            return jdbcTemplate.update("update users set password=? where email=?",
                    new Object[]{password_hash, email});
        } catch (Exception e) {
            return 0;
        }
    }

}
