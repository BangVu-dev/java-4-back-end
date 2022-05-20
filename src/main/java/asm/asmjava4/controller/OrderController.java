/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm.asmjava4.controller;

import asm.asmjava4.dao.CategoryDAO;
import asm.asmjava4.dao.OrderDAO;
import asm.asmjava4.dao.UserDAO;
import asm.asmjava4.model.Category;
import asm.asmjava4.model.Order;
import asm.asmjava4.model.OrderWithDetail;
import asm.asmjava4.model.User;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import static org.apache.tomcat.jni.User.username;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import utils.SendMail;

/**
 *
 * @author PC
 */
@RestController
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderDAO orderDAO;

    @PostMapping("/order/checkout")
    public Order checkOut(@RequestBody Order order) {
        Date date = new Date();
        Timestamp timestamp2 = new Timestamp(date.getTime());
        order.setCreatedAt(timestamp2);
        try {
            SendMail.sendEmail(order.getEmail());
            return orderDAO.add(order);
        } catch (Exception e) {
            return null;
        }
        
    }

    @GetMapping("/orders/list")
    public List<OrderWithDetail> getOrderList() {
        return orderDAO.getOrderList();
    }

}
