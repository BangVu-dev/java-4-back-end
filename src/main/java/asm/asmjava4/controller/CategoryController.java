/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm.asmjava4.controller;

import asm.asmjava4.dao.CategoryDAO;
import asm.asmjava4.model.Category;
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
public class CategoryController {

    @Autowired
    private CategoryDAO categoryDAO;

    @GetMapping("/categories")
    public List<Category> getListCategory() {
        return categoryDAO.getAll();
    }

    @GetMapping("/category/{id}")
    public Category getCategoryById(@PathVariable int id) {
        return categoryDAO.getById(id);
    }

    @PostMapping("category/add")
    public String saveCategory(@RequestBody Category cate) {
        return categoryDAO.add(cate) + "Add Successfully!";
    }

    @PutMapping("category/update/{id}")
    public String updateCategory(@RequestBody Category cate, @PathVariable int id) {
        return categoryDAO.update(cate, id) + "Update Successfully!";
    }

    @DeleteMapping("category/delete/{id}")
    public String deleteCategory( @PathVariable int id) {
        return categoryDAO.delete(id) + "Delete Successfully";
    }
    
    @GetMapping("/category/search/{name}")
    public List<Category> searchByName(@PathVariable String name) {
        return categoryDAO.searchByName(name);
    }
}
