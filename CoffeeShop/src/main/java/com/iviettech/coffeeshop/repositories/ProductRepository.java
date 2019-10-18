/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.repositories;

import com.iviettech.coffeeshop.entities.ProductEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer>{
    @Query(value = "SELECT DISTINCT p FROM ProductEntity p INNER JOIN FETCH p.sizes s "
            + "INNER JOIN FETCH p.votes WHERE p.category.id = ?1")
    public List<ProductEntity> getProductByCategoryId(int id);
}
