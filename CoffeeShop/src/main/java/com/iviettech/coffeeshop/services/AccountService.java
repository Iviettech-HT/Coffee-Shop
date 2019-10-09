/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.services;

import com.iviettech.coffeeshop.entities.AccountEntity;
import com.iviettech.coffeeshop.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    
    public AccountEntity findAccount(String username, String password){
        return accountRepository.findByUsernameAndPassword(username, password);
    }
}
