/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author admin
 */
@Controller
public class ShopController {
    @RequestMapping(value = {"/*","/home"})
    public String viewHome(Model model){
        return "home";
    }
    
    @RequestMapping(value = {"/dang-nhap"})
    public String viewLogin(Model model){
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
}
