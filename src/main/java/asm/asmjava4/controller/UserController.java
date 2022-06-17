/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm.asmjava4.controller;

import asm.asmjava4.dao.CategoryDAO;
import asm.asmjava4.dao.UserDAO;
import asm.asmjava4.model.Category;
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
import utils.PasswordHelper;

/**
 *
 * @author PC
 */
@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/users")
    public List<User> getListUser() {        
        List<User> user = userDAO.getAll();
        for (int i = 0; i < user.size(); i++) {
            user.get(i).setPassword(PasswordHelper.decrypt(user.get(i).getPassword()));
        }
        return user;
    }

    @PostMapping("login")
    public User userLogin(@RequestBody User user) {
        String password_hash = PasswordHelper.encrypt(user.getPassword());
        user.setPassword(password_hash);
        return userDAO.login(user);
    }

    @PostMapping("/register")
    public User userRegister(@RequestBody User user) {
        String password_hash = PasswordHelper.encrypt(user.getPassword());
        user.setPassword(password_hash);
        return userDAO.add(user);
    }

    @PutMapping("/user/update/{id}")
    public User userUpdate(@RequestBody User user, @PathVariable int id) {
        return userDAO.update(user, id);
    }

    @PostMapping("/user/add")
    public User addAccount(@RequestBody User user) {
        String password_hash = PasswordHelper.encrypt(user.getPassword());
        user.setPassword(password_hash);
        return userDAO.add(user);
    }

    @DeleteMapping("user/delete/{id}")
    public String deleteAccount(@PathVariable int id) {
        return userDAO.delete(id) + "Delete Successfully";
    }

    @PutMapping("/account/update/{id}")
    public User accountUpdate(@RequestBody User user, @PathVariable int id) {
        String password_hash = PasswordHelper.encrypt(user.getPassword());
        user.setPassword(password_hash);
        return userDAO.updateAccount(user, id);
    }

    @GetMapping("/user/reset/password/{email}")
    public int resetPasswordSendMail(@PathVariable String email) {
        return userDAO.sendPassword(email);
    }

}
