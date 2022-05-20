/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package asm.asmjava4.dao;

import asm.asmjava4.model.Order;
import asm.asmjava4.model.OrderProduct;
import asm.asmjava4.model.User;
import java.util.List;

/**
 *
 * @author PC
 */
public interface OrderProductDAO {
//   int update(Product product, int id);
//   int delete (int id);
//   List<ProductWithDetail> getAll();   
    OrderProduct orderProductList(OrderProduct orderProduct);
    int addtoCart(OrderProduct orderProduct);
}
