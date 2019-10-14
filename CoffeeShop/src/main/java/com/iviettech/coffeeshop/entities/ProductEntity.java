/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "product")
public class ProductEntity {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int quantity;
    private double price;
    private String size;
    private boolean status;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
    
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<ImageEntity> imageEntitys;
    
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<PromotionEntity> promotionEntitys;
    
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<OrderDetailsEntity> orderDetailsEntitys;
   
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "size_product",
            joinColumns = {
                @JoinColumn(name = "size_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "product_id")}
    )
    private Set<SizeEntity> product = new HashSet<SizeEntity>();
    
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<VoteEntity> votes;

    public ProductEntity(String name, double price, boolean status, List<VoteEntity> votes) {
        this.name = name;
        this.price = price;
        this.status = status;
        this.votes = votes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSize() {
        return name;
    }

    public void setSize(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<VoteEntity> getVotes() {
        return votes;
    }

    public void setVotes(List<VoteEntity> votes) {
        this.votes = votes;
    }
    
}
