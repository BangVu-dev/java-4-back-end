/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm.asmjava4.dao;

import asm.asmjava4.model.Category;
import asm.asmjava4.model.Order;
import asm.asmjava4.model.OrderWithDetail;
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
public class OrderDAOImpl implements OrderDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Override
    public List<OrderWithDetail> getOrderList() {
        return jdbcTemplate.query("SELECT * FROM orders as o join orderproduct as op on o.orderId = op.orderId ORDER BY o.orderId DESC", 
                new BeanPropertyRowMapper<OrderWithDetail>(OrderWithDetail.class));
    }
    
    @Override
    public Order orderList(Order order) {
        return jdbcTemplate.queryForObject("select * from orders "
                + "where orderId=?", new BeanPropertyRowMapper<Order>(Order.class), order.getOrderId());
    }

    @Override
    public Order add(Order order) {
        jdbcTemplate.update("INSERT INTO orders(orderId, userId, createdAt, orderStatus, "
                + "fullName, phoneNumber, email, postCode, address, message) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new Object[]{order.getOrderId(), order.getUserId(), order.getCreatedAt(), order.getOrderStatus(), order.getFullName(),
                    order.getPhoneNumber(), order.getEmail(), order.getPostCode(), order.getAddress(), order.getMessage()}); 
        return orderList(order);
    }    

}
