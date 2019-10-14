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
    private boolean status;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
    
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<ImageEntity> images;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "promotion_product",
            joinColumns = {
                @JoinColumn(name = "product_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "promotion_id")}
    )
    private Set<PromotionEntity> promotions;
    
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<OrderDetailEntity> orderDetails;
   
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "size_product",
            joinColumns = {
                @JoinColumn(name = "product_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "size_id")}
    )
    private Set<SizeEntity> product;
    
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<VoteEntity> votes;

    public ProductEntity(String name, int quantity, double price, boolean status, CategoryEntity category, List<ImageEntity> images, Set<PromotionEntity> promotions, List<OrderDetailEntity> orderDetails, List<VoteEntity> votes) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
        this.category = category;
        this.images = images;
        this.promotions = promotions;
        this.orderDetails = orderDetails;
        this.votes = votes;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public List<ImageEntity> getImages() {
        return images;
    }

    public void setImages(List<ImageEntity> images) {
        this.images = images;
    }

    public Set<PromotionEntity> getPromotions() {
        return promotions;
    }

    public void setPromotions(Set<PromotionEntity> promotions) {
        this.promotions = promotions;
    }

    public List<OrderDetailEntity> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailEntity> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Set<SizeEntity> getProduct() {
        return product;
    }

    public void setProduct(Set<SizeEntity> product) {
        this.product = product;
    }
    
}
