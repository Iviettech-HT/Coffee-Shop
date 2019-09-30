/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.entities;

import java.io.Serializable;

/**
 *
 * @author admin
 */
public class VoteId implements Serializable{
    protected int productId;
    protected int accountId;

    public VoteId(int productId, int accountId) {
        this.productId = productId;
        this.accountId = accountId;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.productId;
        hash = 59 * hash + this.accountId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VoteId other = (VoteId) obj;
        if (this.productId != other.productId) {
            return false;
        }
        if (this.accountId != other.accountId) {
            return false;
        }
        return true;
    }
    
}
