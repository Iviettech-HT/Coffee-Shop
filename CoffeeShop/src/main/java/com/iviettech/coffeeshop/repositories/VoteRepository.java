/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.repositories;

import com.iviettech.coffeeshop.entities.VoteEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author admin
 */
@Repository
public interface VoteRepository extends CrudRepository<VoteEntity, Integer>{
    @Query(value = "SELECT v FROM VoteEntity v WHERE v.product.id = ?1")
    public List<VoteEntity> getVotesByProductId(int id);
}
