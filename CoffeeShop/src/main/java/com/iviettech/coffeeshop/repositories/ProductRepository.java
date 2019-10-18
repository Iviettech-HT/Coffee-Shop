/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.repositories;

import com.iviettech.coffeeshop.entities.ProductEntity;
<<<<<<< HEAD
=======
import java.util.List;
import org.springframework.data.jpa.repository.Query;
>>>>>>> 9fbd6c4cfdc3e9b269926029e7efc30d9a53a20a
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
<<<<<<< HEAD
 * @author PC
 */
@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer>{
    
=======
 * @author admin
 */
@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer>{
    @Query(value = "SELECT DISTINCT p FROM ProductEntity p INNER JOIN FETCH p.sizes s "
            + "INNER JOIN FETCH p.votes WHERE p.category.id = ?1")
    public List<ProductEntity> getProductByCategoryId(int id);
>>>>>>> 9fbd6c4cfdc3e9b269926029e7efc30d9a53a20a
}
