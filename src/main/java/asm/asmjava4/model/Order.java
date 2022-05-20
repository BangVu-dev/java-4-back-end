/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm.asmjava4.model;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author PC
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    Double orderId;
    Integer userId;
    Timestamp createdAt;
    String orderStatus;
    String fullName;
    String phoneNumber;
    String email;
    String postCode;
    String address;
    String message;
}
