/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.services;

import com.iviettech.coffeeshop.entities.ImageEntity;
import com.iviettech.coffeeshop.repositories.ImageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository;
    
    public List<ImageEntity> getImagesByProductId(int productId){
        return imageRepository.getImagesByProductId(productId);
    }
}
