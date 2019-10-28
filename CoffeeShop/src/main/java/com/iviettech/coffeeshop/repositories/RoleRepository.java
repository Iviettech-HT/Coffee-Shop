/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.repositories;

import com.iviettech.coffeeshop.entities.RoleEntity;
import com.iviettech.coffeeshop.enums.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Integer>{
    public RoleEntity findByRole(Role role);
}
