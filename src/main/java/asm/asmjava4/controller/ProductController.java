/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm.asmjava4.controller;

import asm.asmjava4.dao.CategoryDAO;
import asm.asmjava4.dao.ProductDAO;
import asm.asmjava4.model.Product;
import asm.asmjava4.model.ProductWithDetail;
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
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @GetMapping("/products")
    public List<ProductWithDetail> getListProduct() {
        return productDAO.getAll();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable int id) {
        return productDAO.getById(id);
    }

    @PostMapping("product/add")
    public String addProduct(@RequestBody Product product) {
        return productDAO.add(product) + "Add Successfully!";
    }

    @PutMapping("product/update/{id}")
    public String updateProduct(@RequestBody Product product, @PathVariable int id) {
        return productDAO.update(product, id) + "Update Successfully!";
    }

    @DeleteMapping("product/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return productDAO.delete(id) + "Delete Successfully";
    }
    
    @GetMapping("products/category/{catId}")
    public List<Product> getListProductWithCatId(@PathVariable int catId) {
        return productDAO.getAllWithCatId(catId);
    }
}
