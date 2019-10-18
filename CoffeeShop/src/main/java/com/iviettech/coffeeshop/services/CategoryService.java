/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.services;

import com.iviettech.coffeeshop.entities.CategoryEntity;
import com.iviettech.coffeeshop.repositories.CategoryRepository;
import java.util.ArrayList;
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
//    public CategoryEntity getCategory(String name){
//        
//    }
    
    public ArrayList<CategoryEntity> getCategories(){
        ArrayList<CategoryEntity> categories = (ArrayList) categoryRepository.findAll();
        return categories;
    }
}