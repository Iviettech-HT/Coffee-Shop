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

/**
 *
 * @author admin
 */
@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer>{
    @Query(value = "SELECT DISTINCT p FROM ProductEntity p INNER JOIN FETCH p.sizes s "
            + "WHERE p.category.id = ?1")
    public List<ProductEntity> getProductsByCategoryId(int id);
    
    @Query(value = "SELECT DISTINCT p FROM ProductEntity p INNER JOIN FETCH p.sizes s "
            + "WHERE p.category.name = ?1 "
            + "ORDER BY p.name ")
    public List<ProductEntity> getProductsByCategoryName(String name);
    
    @Query(value = "SELECT p.id FROM product p "
            + "JOIN vote v "
            + "ON p.id = v.product_id "
            + "GROUP BY p.id "
            + "ORDER BY AVG(v.star) DESC "
            + "LIMIT 20 ", nativeQuery = true)
    public List<Integer> getBestProducts();
    
    @Query(value = "SELECT DISTINCT p FROM ProductEntity p INNER JOIN FETCH p.sizes s "
            + "WHERE p.id = ?1 ")
    public ProductEntity getProductById(int id);
    
    @Query(value = "SELECT DISTINCT p FROM ProductEntity p INNER JOIN FETCH p.sizes s "
            + "WHERE p.id = ?1 AND s.id = ?2")
    public ProductEntity getProductByIdAndSizeId(int id, int sizeId);
}
