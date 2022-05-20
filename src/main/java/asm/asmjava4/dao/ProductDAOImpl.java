/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm.asmjava4.dao;

import asm.asmjava4.model.Category;
import asm.asmjava4.model.Product;
import asm.asmjava4.model.ProductWithDetail;
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
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Override
    public int add(Product product) {
        return jdbcTemplate.update("INSERT INTO product(image, productName, price, categoryId, description) "
                + "VALUES(?, ?, ?, ?, ?)", new Object[]{product.getImage(), product.getProductName(), product.getPrice(), 
                    product.getCategoryId(), product.getDescription()});
    }
    
    @Override
    public int update(Product product, int id) {
        return jdbcTemplate.update("update product set image=?, productName=?, price=?, categoryId=?, description=? where productId=?", 
                new Object[]{product.getImage(), product.getProductName(), product.getPrice(), 
                    product.getCategoryId(), product.getDescription(), id});
    }
    
    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE from product where productId=?", id);
    }
    
    @Override
    public List<ProductWithDetail> getAll() {
        return jdbcTemplate.query("SELECT p.productId, p.image, p.productName, p.price, p.categoryId, p.description, c.categoryName\n" +
        "FROM product as p join category as c on p.categoryId = c.categoryId ORDER BY p.productId DESC", new BeanPropertyRowMapper<ProductWithDetail>(ProductWithDetail.class));
    }
    
    @Override
    public Product getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM product where productId=?", new BeanPropertyRowMapper<Product>(Product.class), id);
    }
    
}
