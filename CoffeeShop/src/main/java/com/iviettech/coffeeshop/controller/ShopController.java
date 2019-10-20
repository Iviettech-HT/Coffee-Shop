/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.controller;

import com.iviettech.coffeeshop.entities.OrderDetailEntity;
import com.iviettech.coffeeshop.entities.ProductEntity;
import com.iviettech.coffeeshop.entities.PromotionEntity;
import com.iviettech.coffeeshop.services.CategoryService;
import com.iviettech.coffeeshop.services.ProductService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    ProductService productService;

    @RequestMapping(value = {"/*", "/home"})
    public String viewHome(Model model, HttpServletRequest request) {
        model.addAttribute("products", productService.getBestProducts());
        model.addAttribute("categories", categoryService.getCategories());
        return "home";
    }

    @RequestMapping(value = {"/dang-nhap"})
    public String viewLogin(Model model,
            @RequestParam(name = "isError", required = false) boolean isError) {
        if (isError) {
            model.addAttribute("messageError", "Sai tên đăng nhập hoặc mật khẩu");
        }
        return "login";
    }

    @RequestMapping(value = {"/dang-ky"})
    public String viewRegister(Model model) {
        return "register";
    }

    @RequestMapping(value = {"/gio-hang"})
    public String viewCart(Model model) {
        return "cart/cart";
    }
    
    @RequestMapping(value = "/chi-tiet-san-pham/{productId}")
    public String viewProductDetail(Model model,
            @PathVariable("productId") int id){
        model.addAttribute("product", productService.getProductById(id));
        return "productDetail";
    }
    
    @RequestMapping(value = "/them-vao-gio-hang/{productId}/{sizeId}")
    public String addToCart(Model model,
            @PathVariable("productId") int productId,
            @PathVariable("sizeId") int sizeId,
            HttpServletRequest request) {
        List<OrderDetailEntity> orderDetails = new ArrayList<>();
        
        if (request.getSession().getAttribute("orderDetails") == null) {
            request.getSession().setAttribute("orderDetails", orderDetails);
        } else {
            orderDetails = (List<OrderDetailEntity>) request.getSession().getAttribute("orderDetails");
        }
        ProductEntity product = productService.getProductByIdAndSizeId(productId, sizeId);
        OrderDetailEntity orderDetail = new OrderDetailEntity();

        boolean isExistProduct = false;
        for (OrderDetailEntity orderDetailTemp : orderDetails) {
            if (product.getId() == orderDetailTemp.getProduct().getId() 
                    && product.getSizes().iterator().next().getSize().equals(orderDetailTemp.getSize())) {
                isExistProduct = true;
                orderDetailTemp.setQuantity(orderDetailTemp.getQuantity() + 1);
                orderDetailTemp.setPrice(orderDetailTemp.getUnitPrice() * orderDetailTemp.getQuantity());
                break;
            }
        }
        if (isExistProduct == false) {
            orderDetail.setProduct(product);
            orderDetail.setQuantity(1);
            orderDetail.setSize(product.getSizes().iterator().next().getSize());
            double unitPriceTemp = product.getPrice() + product.getSizes().iterator().next().getAddition();

            if (!product.getPromotions().isEmpty()) {
                for (PromotionEntity promotion : product.getPromotions()) {
                    unitPriceTemp *= (1 - promotion.getDiscount());
                }

                unitPriceTemp = Math.round(unitPriceTemp * 10) / 10.0;
            }
            orderDetail.setUnitPrice(unitPriceTemp);

            orderDetail.setPrice(unitPriceTemp * orderDetail.getQuantity());
            orderDetails.add(orderDetail);
        }
        request.getSession().setAttribute("orderDetails", orderDetails);

        return "redirect:/gio-hang";
    }
    
    @RequestMapping(value = "/xoa-san-pham")
    public String deleteProduct(Model model,
            @RequestParam(name = "pos") int pos,
            HttpServletRequest request){
        List<OrderDetailEntity> orderDetails = (List<OrderDetailEntity>) request.getSession().getAttribute("orderDetails");
        orderDetails.remove(orderDetails.get(pos));
        
        request.setAttribute("orderDetails", orderDetails);
        return "cart/cart";
    }
    
    @RequestMapping(value = "/dat-hang")
    public String viewCheckout(Model model) {
        return "cart/check-out";
    }

    @RequestMapping(value = "/list-san-pham")
    public String getCategory(Model model,
            @RequestParam(name = "name") String nameCategory) {
        List<ProductEntity> products = null;
        if (nameCategory.equalsIgnoreCase("best choose")) {
            products = productService.getBestProducts();
        } else {
            products = productService.getProducts(nameCategory);
        }

        model.addAttribute("products", products);
        return "ajax/listProduct";
    }
    @RequestMapping(value = "/tim-kiem-san-pham")
    public String searchProducts(Model model,
            @RequestParam(name = "name") String productName){
        model.addAttribute("products", productService.searchProducts(productName));
        return "ajax/listProduct";
    }
}
