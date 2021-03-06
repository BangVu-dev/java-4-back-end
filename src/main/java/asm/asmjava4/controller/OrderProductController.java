/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm.asmjava4.controller;

import asm.asmjava4.dao.CategoryDAO;
import asm.asmjava4.dao.OrderDAO;
import asm.asmjava4.dao.OrderProductDAO;
import asm.asmjava4.dao.UserDAO;
import asm.asmjava4.model.Category;
import asm.asmjava4.model.Order;
import asm.asmjava4.model.OrderProduct;
import asm.asmjava4.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PC
 */
@RestController
@CrossOrigin(origins="*")
public class OrderProductController {

    @Autowired
    private OrderProductDAO orderProductDAO;  
    
    @PostMapping("cart/add")
    public String addToCart(@RequestBody OrderProduct orderProduct) {
        return orderProductDAO.addtoCart(orderProduct) + "Add to cart successfully!";
    }
  
}
