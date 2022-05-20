/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm.asmjava4.dao;

import asm.asmjava4.model.Category;
import asm.asmjava4.model.Order;
import asm.asmjava4.model.OrderProduct;
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
public class OrderProductDAOImpl implements OrderProductDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public OrderProduct orderProductList(OrderProduct orderProduct) {
        return jdbcTemplate.queryForObject("select * from orderproduct "
                + "where cartId=?", new BeanPropertyRowMapper<OrderProduct>(OrderProduct.class), orderProduct.getCartId());
    }

    @Override
    public int addtoCart(OrderProduct orderProduct) {
        return jdbcTemplate.update("INSERT INTO orderproduct(orderId, productId, image, "
                + "productName, price, quantity) VALUES(?, ?, ?, ?, ?, ?)",
                new Object[]{orderProduct.getOrderId(), orderProduct.getProductId(),
                    orderProduct.getImage(), orderProduct.getProductName(),
                    orderProduct.getPrice(), orderProduct.getQuantity()});
    }

}
