/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package asm.asmjava4.dao;

import asm.asmjava4.model.User;
import java.util.List;

/**
 *
 * @author PC
 */
public interface UserDAO {
//   int update(Product product, int id);
//   int delete (int id);
//   List<ProductWithDetail> getAll();
   User login(User user);
   User add(User user);
   User update(User user, int id);
}
