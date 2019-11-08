/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.services;

import com.iviettech.coffeeshop.entities.AccountEntity;
import com.iviettech.coffeeshop.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public AccountEntity findAccount(String username){
        return accountRepository.findByUsername(username);
    }
    
    public boolean isExistedUsername(String username){
        AccountEntity accountEntity = accountRepository.findByUsername(username);
        if(accountEntity != null)
            return true;
        return false;
    }
    
    public boolean isExistedEmail(String email){
        AccountEntity accountEntity = accountRepository.findByEmail(email);
        if(accountEntity != null)
            return true;
        return false;
    }
    
    public boolean isExistedPhone(String phone){
        AccountEntity accountEntity = accountRepository.findByPhone(phone);
        if(accountEntity != null)
            return true;
        return false;
    }
    
    public AccountEntity addAccount(AccountEntity account){
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepository.save(account);
    }
    
    public AccountEntity updateAccountStatus(String email, boolean status){
        AccountEntity account = accountRepository.findByEmail(email);
        account.setStatus(status);
        return accountRepository.save(account);
    }
}
