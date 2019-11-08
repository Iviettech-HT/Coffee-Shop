/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.services;

import com.iviettech.coffeeshop.entities.CategoryEntity;
import com.iviettech.coffeeshop.repositories.CategoryRepository;
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
    private CategoryRepository categoryRepository;
   
    public List<CategoryEntity> getCategories(){
        return (List<CategoryEntity>) categoryRepository.findAll();
    }

    public void addCategory(CategoryEntity category) {
        category.setProducts(null);
        categoryRepository.save(category);
    }
    public CategoryEntity findCategory(int id){
        return (CategoryEntity) categoryRepository.findOne(id);
    }
    public List<CategoryEntity> getCategoryByStatus(){
        return (List<CategoryEntity>) categoryRepository.getCategoryByStatus();
    }
}
