/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "favorite")
@IdClass(AccountProductId.class)
public class FavoriteEntity {
    @Id
    private int productId;
    
    @Id
    private int accountId;
    
    private boolean status;

    public FavoriteEntity(int productId, int accountId, boolean status) {
        this.productId = productId;
        this.accountId = accountId;
        this.status = status;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
