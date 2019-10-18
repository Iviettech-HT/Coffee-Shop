/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.repositories;

import com.iviettech.coffeeshop.entities.CategoryEntity;
<<<<<<< HEAD
=======
import java.io.Serializable;
>>>>>>> 9fbd6c4cfdc3e9b269926029e7efc30d9a53a20a
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
<<<<<<< HEAD
 * @author PC
 */
@Repository
public interface CategoryRepository extends
        CrudRepository<CategoryEntity, Integer>{
=======
 * @author admin
 */
@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer>{
>>>>>>> 9fbd6c4cfdc3e9b269926029e7efc30d9a53a20a
    
}
