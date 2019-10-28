/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.services;

import com.iviettech.coffeeshop.entities.CustomerEntity;
import com.iviettech.coffeeshop.entities.OrderDetailEntity;
import com.iviettech.coffeeshop.entities.OrderEntity;
import com.iviettech.coffeeshop.repositories.CustomerRepository;
import com.iviettech.coffeeshop.repositories.OrderDetailRepository;
import com.iviettech.coffeeshop.repositories.OrderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;

    public OrderEntity findOrder(int id) {
        return orderRepository.findOne(id);
    }

    public OrderEntity addOrder(OrderEntity order) {
        CustomerEntity customer = order.getCustomer();
        List<OrderDetailEntity> orderDetails = order.getOrderDetails();
        CustomerEntity existedCustomer = customerRepository.findByEmailAndPhone(customer.getEmail(), customer.getPhone());
//        Add customer
        if (existedCustomer != null) {
            customer = existedCustomer;
        } else {
            customer = customerRepository.save(customer);
        }
//        Add order
        order.setCustomer(customer);
        order = orderRepository.save(order);
//        Add orderDetail
        for(OrderDetailEntity orderDetail : orderDetails){
            orderDetail.setOrder(order);
            orderDetail = orderDetailRepository.save(orderDetail);
        }
        
        order.setOrderDetails(orderDetails);
        return order;
    }
}
