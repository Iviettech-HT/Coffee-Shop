/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.repositories;

import com.iviettech.coffeeshop.entities.OrderEntity;
import com.iviettech.coffeeshop.enums.OrderStatus;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PC
 */
@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Integer>{
    public List<OrderEntity> findByOrderDateBetween(Date startDate, Date endDate);
    
    @Query(value = "SELECT * FROM Orders WHERE status like ?1", nativeQuery = true)
    public List<OrderEntity> getNewOrder(String status);   

    public List<OrderEntity> findByOrderDateBetweenAndStatusIn(Date startDate, Date endDate,List<OrderStatus> os);
}
