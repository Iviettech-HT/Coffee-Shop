/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Entity
@Table(name="orderDetail")
public class OrderDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double unitPrice;
    private double price;
    
    @ManyToMany
    @JoinColumn(name = "product_id")
    private ProductEntity product;
    
    @ManyToMany
    @JoinColumn(name = "orders_id")
    private OrdersEntity orders;
    
}
