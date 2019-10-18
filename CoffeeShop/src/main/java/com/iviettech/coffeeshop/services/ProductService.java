/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.services;

import com.iviettech.coffeeshop.entities.ProductEntity;
import com.iviettech.coffeeshop.repositories.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
<<<<<<< HEAD
 * @author PC
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> getProducts() {
        return (List<ProductEntity>) productRepository.findAll();
    }

    public void addProduct(ProductEntity category) {
        productRepository.save(category);
=======
 * @author admin
 */
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    
    public List<ProductEntity> getProducts(int CategoryId){
        return productRepository.getProductByCategoryId(CategoryId);
>>>>>>> 9fbd6c4cfdc3e9b269926029e7efc30d9a53a20a
    }
}
