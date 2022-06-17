/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package asm.asmjava4.dao;

import asm.asmjava4.model.Product;
import asm.asmjava4.model.ProductWithDetail;
import java.util.List;

/**
 *
 * @author PC
 */
public interface ProductDAO {
   int add(Product product);
   int update(Product product, int id);
   int delete (int id);
   List<ProductWithDetail> getAll(); 
   Product getById(int id);
   List<Product> getAllWithCatId(int catId);
}
