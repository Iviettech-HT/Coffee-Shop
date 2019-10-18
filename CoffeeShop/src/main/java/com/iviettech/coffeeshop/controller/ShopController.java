/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.controller;

import com.iviettech.coffeeshop.entities.CategoryEntity;
import com.iviettech.coffeeshop.services.CategoryService;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author admin
 */
@Controller
public class ShopController {
    @Autowired
    CategoryService categoryService;
    
    @RequestMapping(value = {"/*","/home"})
    public String viewHome(Model model, HttpServletRequest request){
        ArrayList<CategoryEntity> categories = (ArrayList) categoryService.getCategories();
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
    
//    @RequestMapping(value = {"/list-san-pham"})
//    public @ResponseBody String getCategory(@RequestParam(name = "name") String nameCategory){
//        ObjectMapper mapper = new ObjectMapper();
//        CategoryEntity categoryEntity
//        
//        
//    }
}
