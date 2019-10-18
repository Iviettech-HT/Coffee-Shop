/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.services;

import com.iviettech.coffeeshop.entities.ProductEntity;
import com.iviettech.coffeeshop.entities.PromotionEntity;
import com.iviettech.coffeeshop.repositories.ImageRepository;
import com.iviettech.coffeeshop.repositories.ProductRepository;
import com.iviettech.coffeeshop.repositories.PromotionRepository;
import com.iviettech.coffeeshop.repositories.VoteRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
<<<<<<< HEAD
 * @author PC
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> getProducts() {
        return (List<ProductEntity>) productRepository.findAll();
    }

    public void addProduct(ProductEntity category) {
        productRepository.save(category);
=======
 * @author admin
 */
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ImageRepository imageRepository;
    @Autowired
    VoteRepository voteRepository;
    @Autowired
    PromotionRepository promotionRepository;
    
    public List<ProductEntity> getProducts(int CategoryId){
<<<<<<< HEAD
        return productRepository.getProductByCategoryId(CategoryId);
>>>>>>> 9fbd6c4cfdc3e9b269926029e7efc30d9a53a20a
=======
        return productRepository.getProductsByCategoryId(CategoryId);
    }
    
    public List<ProductEntity> getProducts(String name){
        List<ProductEntity> products = productRepository.getProductsByCategoryName(name);
        for(ProductEntity product : products){
            product.setImages(imageRepository.getImagesByProductId(product.getId()));
            product.setVotes(voteRepository.getVotesByProductId(product.getId()));
            product.setPromotions(promotionRepository.getPromotionsByProductId(product.getId(),new Date()));
        }
        return products;
    }
    
    public List<ProductEntity> getBestProducts(){
        List<Integer> productIds = productRepository.getBestProducts();
        List<ProductEntity> products = new ArrayList<ProductEntity>();
        
        for(Integer productId : productIds){
            ProductEntity product = new ProductEntity();
            product = productRepository.getProductById(productId);
            products.add(product);
        }
        
        for(ProductEntity product : products){
            product.setImages(imageRepository.getImagesByProductId(product.getId()));
            product.setVotes(voteRepository.getVotesByProductId(product.getId()));
            product.setPromotions(promotionRepository.getPromotionsByProductId(product.getId(), new Date()));
        }
        return products;
>>>>>>> 8d76b1ccc1cba4d28239ac9fcef05b1cca7ee284
    }
}
