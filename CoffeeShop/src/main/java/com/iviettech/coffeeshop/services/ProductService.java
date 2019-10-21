/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.services;

import com.iviettech.coffeeshop.entities.ImageEntity;
import com.iviettech.coffeeshop.entities.ProductEntity;
import com.iviettech.coffeeshop.entities.SizeEntity;
import com.iviettech.coffeeshop.repositories.ImageRepository;
import com.iviettech.coffeeshop.repositories.ProductRepository;
import com.iviettech.coffeeshop.repositories.PromotionRepository;
import com.iviettech.coffeeshop.repositories.VoteRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
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

    public ProductEntity getProductByIdAndSizeId(int id, int sizeId) {
        ProductEntity product = productRepository.getProductByIdAndSizeId(id, sizeId);
        product.setSizes(this.sortSizes(product.getSizes()));
        product.setImages(imageRepository.getImagesByProductId(product.getId()));
        product.setVotes(voteRepository.getVotesByProductId(product.getId()));
        product.setPromotions(promotionRepository.getPromotionsByProductId(product.getId(), new Date()));
        return product;
    }
    
    public ProductEntity getProductById(int id){
        ProductEntity product = productRepository.getProductById(id);
        product.setSizes(this.sortSizes(product.getSizes()));
        product.setImages(imageRepository.getImagesByProductId(product.getId()));
        product.setVotes(voteRepository.getVotesByProductId(product.getId()));
        product.setPromotions(promotionRepository.getPromotionsByProductId(product.getId(), new Date()));
        return product;
    }
    
    public List<ProductEntity> getProducts() {

        List<ProductEntity> products = (List<ProductEntity>) productRepository.getAll();

        for (ProductEntity product : products) {
            product.setSizes(this.sortSizes(product.getSizes()));
            product.setImages(imageRepository.getImagesByProductId(product.getId()));
            product.setVotes(voteRepository.getVotesByProductId(product.getId()));
            product.setPromotions(promotionRepository.getPromotionsByProductId(product.getId(), new Date()));
        }
        return products;
    }

    public List<ProductEntity> getProducts(int CategoryId) {
        return productRepository.getProductsByCategoryId(CategoryId);
    }

    public List<ProductEntity> getProducts(String name) {
        List<ProductEntity> products = productRepository.getProductsByCategoryName(name);
        for (ProductEntity product : products) {
            product.setSizes(this.sortSizes(product.getSizes()));
            product.setImages(imageRepository.getImagesByProductId(product.getId()));
            product.setVotes(voteRepository.getVotesByProductId(product.getId()));
            product.setPromotions(promotionRepository.getPromotionsByProductId(product.getId(), new Date()));
        }
        return products;
    }
    
    public List<ProductEntity> searchProducts(String name){
        name = '%' + name + '%';
        List<ProductEntity> products = productRepository.getProductsByName(name);
        for (ProductEntity product : products) {
            product.setSizes(this.sortSizes(product.getSizes()));
            product.setImages(imageRepository.getImagesByProductId(product.getId()));
            product.setVotes(voteRepository.getVotesByProductId(product.getId()));
            product.setPromotions(promotionRepository.getPromotionsByProductId(product.getId(), new Date()));
        }
        return products;
    }
    
    public List<ProductEntity> getBestProducts() {
        List<Integer> productIds = productRepository.getBestProducts();
        List<ProductEntity> products = new ArrayList<ProductEntity>();

        for (Integer productId : productIds) {
            ProductEntity product = new ProductEntity();
            product = productRepository.getProductById(productId);
            product.setSizes(this.sortSizes(product.getSizes()));
            products.add(product);
        }

        for (ProductEntity product : products) {
            product.setImages(imageRepository.getImagesByProductId(product.getId()));
            product.setVotes(voteRepository.getVotesByProductId(product.getId()));
            product.setPromotions(promotionRepository.getPromotionsByProductId(product.getId(), new Date()));
        }
        return products;
    }

    public ProductEntity addProduct(ProductEntity product) {
        List<ImageEntity> listImages = product.getImages();
        product.setImages(null);
        ProductEntity newProduct = productRepository.save(product);
        for (ImageEntity image : listImages) {
            image.setProduct(newProduct);
            imageRepository.save(image);
        }
        newProduct.setImages(listImages);
        return newProduct;
    }

    public List<ProductEntity> findProducts() {
        return (List<ProductEntity>) productRepository.findAll();
    }

    private Set<SizeEntity> sortSizes(Set<SizeEntity> sizes) {
        List<SizeEntity> lSizes = new ArrayList<>(sizes);

        Collections.sort(lSizes, (a, b) -> Integer.compare(a.getId(), b.getId()));
        return new LinkedHashSet<SizeEntity>(lSizes);
    }
    public void saveProduct(ProductEntity product) {
        productRepository.save(product);
    }
}
