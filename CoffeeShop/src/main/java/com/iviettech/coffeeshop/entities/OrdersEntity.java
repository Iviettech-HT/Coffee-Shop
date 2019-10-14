/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author PC
 */
@Entity
@Table(name="orders")
public class OrdersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    private Date shippingDate;
    private double totalPrice;
    private String status;
    
    @OneToMany(mappedBy = "orders", fetch = FetchType.LAZY)
    private List<OrderDetailsEntity> orderDetail;
    
}