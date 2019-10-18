/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.controller;

import com.iviettech.coffeeshop.entities.CategoryEntity;
<<<<<<< HEAD
import com.iviettech.coffeeshop.entities.ImageEntity;
import com.iviettech.coffeeshop.entities.ProductEntity;
import com.iviettech.coffeeshop.services.CategoryService;
import com.iviettech.coffeeshop.services.ProductService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
=======
import com.iviettech.coffeeshop.services.CategoryService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 9fbd6c4cfdc3e9b269926029e7efc30d9a53a20a
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author admin
 */
@Controller
@RequestMapping("/admin")
public class AdminCotroller {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    @RequestMapping("/home")
    public String viewAdmin(Model model) {
        return "admin/home";
    }
//-----Product--------------------------------------------
    @RequestMapping(value = {"/product"}, method = RequestMethod.GET)
    public String product(Model model) {
        model.addAttribute("product", productService.getProducts());
        return "admin/product";
    }

    @RequestMapping(value = {"/add-product"})
    public String viewForm(Model model) {
        model.addAttribute("product", new ProductEntity());
        return "uploadForm";
    }

    @RequestMapping(value = "add-product", method = RequestMethod.POST)
    public String addProduct(Model model,
            @ModelAttribute("product") ProductEntity product,
            @RequestParam("file") MultipartFile[] images,
            @Value(value = "${pathSaveImage}") String pathSaveImages) {
        
        List<ImageEntity> listImage = new ArrayList<>();
        String savedPath;
        if (images.length == 0) {
            model.addAttribute("errorMessage", "Please upload image");
            return "error";
        }
        for (int i = 0; i < images.length; i++) {
            MultipartFile image = images[i];
            try {
                byte[] bytes = image.getBytes();
                File file = new File(pathSaveImages);

                //Get path to resources
                String pathUrl = context.getRealPath("/images");
                int index = pathUrl.indexOf("target");
                String pathFolder = pathUrl.substring(0, index) + pathSaveImages;
                savedPath = "/resources/images/" + image.getOriginalFilename();
                //create temporary ImageEntity
                ImageEntity imageTemp = new ImageEntity();
                imageTemp.setPathImage(savedPath);
                listImage.add(imageTemp);
                //Save file
                File storedFile = new File(pathFolder + File.separator + image.getOriginalFilename());
                BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream(storedFile));

                buffer.write(bytes);
                buffer.close();

            } catch (IOException ex) {
                model.addAttribute("errorMessage", "Error can't add product");
                return "error";
            }
        }
        product.setListImages(listImage);
        productService.addProduct(product);
        return "redirect:/uploadForm";
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
//-----Category---------------------------------
    @RequestMapping(value = {"/category"}, method = RequestMethod.GET)
    public String viewCategory(Model model) {
        model.addAttribute("category", categoryService.getCategories());
        return "admin/category";
    }

    @RequestMapping(value = {"/add-category"}, method = RequestMethod.GET)
    public String addCategory(Model model) {
        model.addAttribute("category", new CategoryEntity());
        model.addAttribute("action", "save-category");
        return "admin/add-category-form";
    }

    @RequestMapping(value = "/save-category", method = RequestMethod.POST)
    public String saveCategory(Model model,
            @ModelAttribute("category") CategoryEntity category) {

        categoryService.addCategory(category);
        return "redirect:/admin/category";
    }

    //----Test----------------
    @RequestMapping("/test")
    public String test(Model model) {
        return "admin/tesst";
    }
}
