/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.controller;

import com.iviettech.coffeeshop.entities.CategoryEntity;
import com.iviettech.coffeeshop.entities.ImageEntity;
import com.iviettech.coffeeshop.entities.OrderEntity;
import com.iviettech.coffeeshop.entities.ProductEntity;
import com.iviettech.coffeeshop.entities.PromotionEntity;
import com.iviettech.coffeeshop.entities.SizeEntity;
import com.iviettech.coffeeshop.services.ProductService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import com.iviettech.coffeeshop.services.CategoryService;
import com.iviettech.coffeeshop.services.ImageService;
import com.iviettech.coffeeshop.services.OrderDetailService;
import com.iviettech.coffeeshop.services.OrderService;
import com.iviettech.coffeeshop.services.PromotionService;
import com.iviettech.coffeeshop.services.SizeService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.servlet.ServletContext;
import javax.ws.rs.POST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

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
public class AdminCotroller implements ResourceLoaderAware {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private SizeService sizeService;
    @Autowired
    private PromotionService promotionService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private ServletContext context;

    private ResourceLoader resourceLoader;

//-----Home----------------------------------------
    @RequestMapping(value = {"/*", "/home"})
    public String viewAdmin(Model model) {
        return "admin/home";
    }
//-----Product--------------------------------------------

    @RequestMapping(value = {"/product"}, method = RequestMethod.GET)
    public String product(Model model) {
        List<ProductEntity> product = productService.getProducts();
        model.addAttribute("products", productService.getProducts());
        return "admin/product";
    }

    @RequestMapping(value = {"/add-product"})
    public String viewForm(Model model) {
        model.addAttribute("product", new ProductEntity());
        model.addAttribute("sizes", sizeService.findSizes());
        model.addAttribute("categories", categoryService.getCategoryByStatus());
        model.addAttribute("action", "add-product");
        return "admin/add-product-form";
    }

    @RequestMapping(value = "/add-product", method = RequestMethod.POST)
    public String addProduct(Model model,
            @ModelAttribute("product") ProductEntity product,
            @RequestParam(name = "file", required = false) MultipartFile[] images,
            @RequestParam(name = "sizeTemp", required = false) List<Integer> sizeIds,
            @Value(value = "${pathSaveImage}") String pathSaveImages) {
        Set<SizeEntity> sizes = new HashSet<>();

        List<ImageEntity> listImage = new ArrayList<>();
        String savedPath;
        String messageError = "";
        boolean isValidated = true;
        if (product.getName().isEmpty()) {
            messageError = "Vui lòng không bỏ trống tên!!!";
            isValidated = false;
        } else {
            if (sizeIds == null) {
                messageError = "Vui lòng không bỏ trống size!!!";
                isValidated = false;
            } else {
                if (images.length != 0) {
                    if (images[0].getOriginalFilename().isEmpty() || images[1].getOriginalFilename().isEmpty()) {
                        messageError = "Vui lòng không bỏ trống ảnh!!!";
                        isValidated = false;
                    } else {
                        for (int sizeId : sizeIds) {
                            SizeEntity size = sizeService.findSize(sizeId);
                            sizes.add(size);
                        }
                        product.setSizes(sizes);
                        for (int i = 0; i < images.length; i++) {
                            MultipartFile image = images[i];
                            try {
                                byte[] bytes = image.getBytes();

                //Get path to resources
                String pathUrl = context.getRealPath("/images");
                int index = pathUrl.indexOf("target");
                String pathFolder = pathUrl.substring(0, index) + pathSaveImages;
                savedPath = "resources/images/landingPage/products/" + image.getOriginalFilename();
                //create temporary ImageEntityz
                ImageEntity imageTemp = new ImageEntity();
                imageTemp.setPath(savedPath);
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
                    }
                }
            }
        }
        if (isValidated) {
            product.setImages(listImage);
            model.addAttribute("product", product);
            productService.addProduct(product);
            return "redirect:/admin/product";
        } else {
            if (product.getId() == 0) {
                model.addAttribute("messageError", messageError);
                model.addAttribute("sizes", sizeService.findSizes());
                model.addAttribute("categories", categoryService.getCategories());
            } else {
                model.addAttribute("messageError", messageError);
                model.addAttribute("product", productService.getProductById(product.getId()));
                model.addAttribute("sizes", sizeService.findSizes());
                model.addAttribute("categories", categoryService.getCategories());
                model.addAttribute("action", "edit-product");
            }
            return "admin/add-product-form";
        }

    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader
    ) {
        this.resourceLoader = resourceLoader;
    }

    @RequestMapping(value = {"/edit-product/{id}"})
    public String editProduct(Model model,
            @PathVariable("id") int Id
    ) {
        model.addAttribute("product", productService.getProductById(Id));
        model.addAttribute("sizes", sizeService.findSizes());
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("action", "edit-product");
        return "admin/add-product-form";
    }

    @RequestMapping(value = "/edit-product/{id}", method = RequestMethod.POST)
    public String saveProduct(Model model,
            @PathVariable("id") int Id
    ) {
        ProductEntity product = productService.getProductById(Id);
        productService.saveProduct(product);
        return "redirect:admin/product";
    }

    @RequestMapping(value = {"/delete-image/{id}"})
    public String deleteImage(Model model,
            @PathVariable("id") int Id
    ) {
        imageService.deleteImageByProductId(Id);
        return "redirect:/admin/edit-product/" + Id;
    }

    @RequestMapping(value = {"/delete-product/{id}"})
    public String delteteProduct(Model model,
            @PathVariable("id") int Id
    ) {
        ProductEntity product = productService.getProductById(Id);
        product.setStatus(false);
        productService.saveProduct(product);
        return "redirect:/admin/product";
    }
//-----Category---------------------------------

    @RequestMapping(value = {"/category"}, method = RequestMethod.GET)
    public String viewCategory(Model model
    ) {
        model.addAttribute("category", categoryService.getCategories());
        return "admin/category";
    }

    @RequestMapping(value = {"/add-category"})
    public String addCategory(Model model
    ) {
        model.addAttribute("category", new CategoryEntity());
        model.addAttribute("action", "save-category");
        return "admin/add-category-form";
    }

    @RequestMapping(value = "/save-category", method = RequestMethod.POST)
    public String saveCategory(Model model,
            @ModelAttribute("category") CategoryEntity category
    ) {
        categoryService.addCategory(category);
        return "redirect:/admin/category";
    }

    @RequestMapping(value = {"/edit-category/{id}"})
    public String editCategory(Model model,
            @PathVariable("id") int id
    ) {
        model.addAttribute("category", categoryService.findCategory(id));
        model.addAttribute("action", "edit-category");
        return "admin/add-category-form";
    }

    @RequestMapping(value = {"/delete-category/{id}"})
    public String delteteCategory(Model model,
            @PathVariable("id") int Id
    ) {
        CategoryEntity category = categoryService.findCategory(Id);
        category.setStatus(false);
        categoryService.addCategory(category);
        return "redirect:/admin/category";
    }

//-----Promotion---------------------------------
    @RequestMapping(value = {"/promotion"}, method = RequestMethod.GET)
    public String viewPromotion(Model model
    ) {
        model.addAttribute("promotion", promotionService.findPromotion());
        return "admin/promotion";
    }

    @RequestMapping(value = {"/detail-promotion/{id}"})
    public String promotionDetail(Model model,
            @PathVariable("id") int id) {
        model.addAttribute("promotion", promotionService.findPromotionById(id));
        model.addAttribute("products", productService.getProductByPromotionId(id));
        return "admin/promotion-detail";
    }

    @RequestMapping(value = {"/add-promotion"})
    public String addPromotion(Model model
    ) {
        model.addAttribute("category", new PromotionEntity());
        model.addAttribute("action", "add-promotion");
        return "admin/promotion-form";
    }

    @RequestMapping(value = "/add-promotion", method = RequestMethod.POST)
    public String savePromotion(Model model,
            @ModelAttribute("promotion") PromotionEntity promotion,
            @RequestParam("file") MultipartFile image,
            @Value(value = "${pathSaveImage}") String pathSaveImages
    ) {

        String savedPath;
        try {
            byte[] bytes = image.getBytes();

            //Get path to resources
            String pathUrl = context.getRealPath("/images");
            int index = pathUrl.indexOf("target");
            String pathFolder = pathUrl.substring(0, index) + pathSaveImages;
            savedPath = "resources/images/landingPage/products/" + image.getOriginalFilename();
            promotion.setImage(savedPath);
            //Save file
            File storedFile = new File(pathFolder + File.separator + image.getOriginalFilename());
            BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream(storedFile));

            buffer.write(bytes);
            buffer.close();

        } catch (IOException ex) {
            model.addAttribute("errorMessage", "Error can't add product");
            return "error";
        }
        promotionService.addPromotion(promotion);
        return "redirect:/admin/promotion";
    }

    @RequestMapping(value = {"/edit-promotion/{id}"})
    public String editPromotion(Model model,
            @PathVariable("id") int id
    ) {
        model.addAttribute("promotion", promotionService.getPromotion(id));
        model.addAttribute("action", "add-promotion");
        return "admin/promotion-form";
    }

    @RequestMapping(value = {"/delete-promotion/{id}"})
    public String deltetePromotion(Model model,
            @PathVariable("id") int Id
    ) {
        PromotionEntity promotion = promotionService.getPromotion(Id);
        promotion.setStatus(false);
        promotionService.addPromotion(promotion);
        return "redirect:/admin/promotion";
    }

    @RequestMapping(value = {"/promotionForProduct/{id}"}, method = RequestMethod.GET)
    public String promotionForProduct(Model model,
            @PathVariable("id") int Id
    ) {
        model.addAttribute("promotion", promotionService.findPromotionById(Id));
        model.addAttribute("product", productService.findProducts());
        model.addAttribute("action", "promotionForProduct");
        return "admin/promotionForProduct";
    }

    @RequestMapping(value = {"/promotionForProduct"}, method = RequestMethod.POST)
    public String savePromotionForProduct(Model model,
            @RequestParam("id") int id,
            @RequestParam(name = "productTemp", required = false) List<Integer> prodpuctIds
    ) {
        PromotionEntity promotion = promotionService.findPromotionById(id);
        Set<ProductEntity> products = new HashSet<>();
        try {
            prodpuctIds.size();
        } catch (Exception ex) {
            promotion.setProducts(products);
            promotionService.addPromotion(promotion);
            return "redirect:/admin/promotion";
        }
        for (int productId : prodpuctIds) {
            ProductEntity product = productService.getProductById(productId);
            products.add(product);
        }
        promotion.setProducts(products);
        promotionService.addPromotion(promotion);
        return "redirect:/admin/promotion";
    }

//----Orders----------------------------------------------------------------------
    @RequestMapping("/order")
    public String getOrder(Model model) {
        model.addAttribute("order", orderService.findOrders());
        return "admin/order";
    }

    @RequestMapping("/orderDetail/{id}")
    public String getOrderDetails(Model model, @PathVariable("id") int Id) {
        model.addAttribute("orderDetail", orderDetailService.findByOrderId(Id));
        return "admin/orderDetail";
    }

    @RequestMapping(value = {"/searchOrder"})
    public String searchOrder(Model model,
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf.parse(startDate);
        Date e = sdf.parse(endDate);
        List<OrderEntity> o = orderService.getOrderByDate(d, e);
        model.addAttribute("order", orderService.getOrderByDate(d, e));

        return "admin/searchOrder";
    }

    //----Test----------------
    @RequestMapping("/test")
    public String test(Model model) {
        return "admin/tesst";
    }
}
