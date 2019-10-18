/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iviettech.coffeeshop.entities.CategoryEntity;
import com.iviettech.coffeeshop.entities.ProductEntity;
import com.iviettech.coffeeshop.entities.SizeEntity;
import com.iviettech.coffeeshop.services.CategoryService;
import com.iviettech.coffeeshop.services.ProductService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author admin
 */
@Controller
public class ShopController {
    @Autowired
    CategoryService categoryService;
    
    @Autowired
    ProductService productService;
    
    @RequestMapping(value = {"/*","/home"})
    public String viewHome(Model model, HttpServletRequest request){
        ArrayList<CategoryEntity> categories = (ArrayList) categoryService.getCategories();
<<<<<<< HEAD
=======
        
        model.addAttribute("products", productService.getBestProducts());
>>>>>>> 8d76b1ccc1cba4d28239ac9fcef05b1cca7ee284
        model.addAttribute("categories", categories);
        return "home";
    }
    
    @RequestMapping(value = {"/dang-nhap"})
    public String viewLogin(Model model,
            @RequestParam(name = "isError", required = false) boolean isError){
        if(isError){
            model.addAttribute("messageError","Sai tên đăng nhập hoặc mật khẩu");
        }
        return "login";
    }
    
    @RequestMapping(value = {"/dang-ky"})
    public String viewRegister(Model model){
        return "register";
    }
    
    @RequestMapping(value = {"/gio-hang"})
    public String viewCart(Model model){
        return "cart/cart";
    }
    
    @RequestMapping(value = {"/dat-hang"})
    public String viewCheckout(Model model){
        return "cart/check-out";
    }
    
    @RequestMapping(value = {"/list-san-pham"})
    public String getCategory(Model model,
            @RequestParam(name = "name") String nameCategory){
        List<ProductEntity> products = null;
        if(nameCategory.equalsIgnoreCase("best choose"))
            products = productService.getBestProducts();
        else
            products = productService.getProducts(nameCategory);
        
        model.addAttribute("products", products);
        return "ajax/listProduct";
    }
}
