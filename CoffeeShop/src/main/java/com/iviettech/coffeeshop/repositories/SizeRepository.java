/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.repositories;

import com.iviettech.coffeeshop.entities.ProductEntity;
import com.iviettech.coffeeshop.entities.SizeEntity;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PC
 */
@Repository
public interface SizeRepository extends CrudRepository<SizeEntity, Integer>{
    
    @Query(value = "SELECT s FROM SizeEntity s JOIN s.products p where p.id = ?1")
    public LinkedHashSet<SizeEntity> getSizesByProductId(int  id);
}
