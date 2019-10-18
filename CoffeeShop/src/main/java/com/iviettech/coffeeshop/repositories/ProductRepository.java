/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.repositories;

import com.iviettech.coffeeshop.entities.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PC
 */
@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer>{
    
}
