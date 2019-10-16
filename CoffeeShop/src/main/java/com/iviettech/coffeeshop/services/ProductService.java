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
 * @author admin
 */
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    
    public List<ProductEntity> getProducts(int CategoryId){
        return productRepository.getProductByCategoryId(CategoryId);
    }
}
