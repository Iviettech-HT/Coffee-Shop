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
<<<<<<< HEAD
 * @author PC
 */
@Service
public class CategoryService {
<<<<<<< HEAD
        @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryEntity> getCategories() {
        return (List<CategoryEntity>) categoryRepository.findAll();
    }
    
    public void addCategory(CategoryEntity category) {
        categoryRepository.save(category);
=======
    @Autowired
    CategoryRepository categoryRepository;
//    public CategoryEntity getCategory(String name){
//        
//    }
    
    public ArrayList<CategoryEntity> getCategories(){
        ArrayList<CategoryEntity> categories = (ArrayList) categoryRepository.findAll();
        return categories;
>>>>>>> 8d76b1ccc1cba4d28239ac9fcef05b1cca7ee284
    }
}
