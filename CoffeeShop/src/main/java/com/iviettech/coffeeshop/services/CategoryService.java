/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.services;

import com.iviettech.coffeeshop.entities.CategoryEntity;
import com.iviettech.coffeeshop.repositories.CategoryRepository;
import com.iviettech.coffeeshop.repositories.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;
//    public CategoryEntity getCategory(String name){
//        
//    }
    
    public List<CategoryEntity> getAllCategories(){
        ArrayList<CategoryEntity> categories =(ArrayList) categoryRepository.findAll();
        for(CategoryEntity category : categories){
            if(category.getId() == 1)
                category.setProducts(productRepository.getProductByCategoryId(1));
        }
        return categories;
    }
}
