/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author PC
 */
@Entity
@Table(name="promotion")
public class PromotionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;
    private String description;
    private String discount;
    private String image;
    private String status;
    
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    private Date endDate;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;
}

