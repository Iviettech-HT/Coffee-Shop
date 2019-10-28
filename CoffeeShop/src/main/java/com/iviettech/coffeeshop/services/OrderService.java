/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.services;

import com.iviettech.coffeeshop.entities.OrderEntity;
import com.iviettech.coffeeshop.repositories.OrderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    
    public List<OrderEntity> getOrder(){
        return (List<OrderEntity>) orderRepository.findAll();
    }
}
