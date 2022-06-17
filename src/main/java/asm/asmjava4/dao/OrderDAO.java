/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package asm.asmjava4.dao;

import asm.asmjava4.model.Order;
import asm.asmjava4.model.OrderWithDetail;
import asm.asmjava4.model.User;
import java.util.List;

/**
 *
 * @author PC
 */
public interface OrderDAO {
    List<OrderWithDetail> getOrderList(int userId);
    Order orderList(Order order);
    Order add(Order order);
}
