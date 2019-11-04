package com.iviettech.coffeeshop.repositories;

import com.iviettech.coffeeshop.entities.OrderEntity;
import com.iviettech.coffeeshop.enums.OrderStatus;
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
    @Query(value = "SELECT DISTINCT o FROM OrderEntity o "
            + "WHERE o.status = ?1 ")
    public List<OrderEntity> getByOrderStatus(OrderStatus status);
}
