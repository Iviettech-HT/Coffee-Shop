/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "vote")
@IdClass(VoteId.class)
public class VoteEntity {
    @Id
    private int productId;
    
    @Id
    private int accountId;
    
    private int star;
    
    @ManyToOne
    @JoinColumn(name = "productId", insertable = false, updatable = false)
    private ProductEntity product;
    
    @ManyToOne
    @JoinColumn(name = "accountId", insertable = false, updatable = false)
    private AccountEntity account;
    
    public VoteEntity(int productId, int accountId, int star) {
        this.productId = productId;
        this.accountId = accountId;
        this.star = star;
    }

    public VoteEntity(int productId, int accountId, int star, ProductEntity product, AccountEntity account) {
        this.productId = productId;
        this.accountId = accountId;
        this.star = star;
        this.product = product;
        this.account = account;
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

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }
    
}
