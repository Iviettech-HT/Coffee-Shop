/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iviettech.coffeeshop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iviettech.coffeeshop.entities.AccountEntity;
import com.iviettech.coffeeshop.entities.CustomerEntity;
import com.iviettech.coffeeshop.entities.OrderDetailEntity;
import com.iviettech.coffeeshop.entities.OrderEntity;
import com.iviettech.coffeeshop.entities.ProductEntity;
import com.iviettech.coffeeshop.entities.PromotionEntity;
import com.iviettech.coffeeshop.entities.RoleEntity;
import com.iviettech.coffeeshop.entities.ToppingEntity;
import com.iviettech.coffeeshop.enums.OrderStatus;
import com.iviettech.coffeeshop.enums.Role;
import com.iviettech.coffeeshop.services.AccountService;
import com.iviettech.coffeeshop.services.CategoryService;
import com.iviettech.coffeeshop.services.OrderService;
import com.iviettech.coffeeshop.services.ProductService;
import com.iviettech.coffeeshop.services.PromotionService;
import com.iviettech.coffeeshop.services.RoleService;
import com.iviettech.coffeeshop.services.ToppingService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author admin
 */
@Controller
public class ShopController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ToppingService toppingService;
    @Autowired
    private PromotionService promotionService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private JavaMailSender jvs;
    @Autowired
    private ServletContext context;

    private StringBuilder textHtml;
    private static int mailCode;

    @RequestMapping(value = {"/*", "/home"})
    public String viewHome(Model model, HttpSession session) {
        model.addAttribute("products", productService.getBestProducts());
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("promotions", promotionService.getPromotionsAvailable());
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
        model.addAttribute("toppings", toppingService.findToppings());
        return "cart/cart";
    }

    @RequestMapping(value = "/chi-tiet-san-pham/{productId}")
    public String viewProductDetail(Model model,
            @PathVariable("productId") int id) {
        model.addAttribute("product", productService.getProductById(id));
        return "productDetail";
    }

    @RequestMapping(value = "/them-vao-gio-hang/{productId}/{sizeId}")
    public String addToCart(Model model,
            @PathVariable("productId") int productId,
            @PathVariable("sizeId") int sizeId,
            HttpSession session) {
        List<OrderDetailEntity> orderDetails = new ArrayList<>();

        if (session.getAttribute("orderDetails") == null) {
            session.setAttribute("orderDetails", orderDetails);
        } else {
            orderDetails = (List<OrderDetailEntity>) session.getAttribute("orderDetails");
        }
        ProductEntity product = productService.getProductByIdAndSizeId(productId, sizeId);
        OrderDetailEntity orderDetail = new OrderDetailEntity();

        //Check the product is exist in session
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

                unitPriceTemp = Math.round(unitPriceTemp/100)*100;
            }
            orderDetail.setUnitPrice(unitPriceTemp);

            orderDetail.setPrice(unitPriceTemp * orderDetail.getQuantity());
            orderDetails.add(orderDetail);
        }
        session.setAttribute("orderDetails", orderDetails);

        return "redirect:/gio-hang";
    }

    @RequestMapping(value = "/thay-doi-so-luong/{pos}/{quantity}")
    public String updateQuantity(@PathVariable("pos") int pos,
            @PathVariable("quantity") int quantity,
            HttpSession session) {

        List<OrderDetailEntity> orderDetails = (List<OrderDetailEntity>) session.getAttribute("orderDetails");
        orderDetails.get(pos).setQuantity(quantity);
        int totalToppingPrice = 0;
        try {
            for (ToppingEntity topping : orderDetails.get(pos).getToppings()) {
                totalToppingPrice += topping.getPrice();
            }
        } catch (Exception ex) {
            Logger.getLogger(ShopController.class.getName()).log(Level.SEVERE, null, ex);
        }

        orderDetails.get(pos).setPrice((orderDetails.get(pos).getUnitPrice() + totalToppingPrice) * orderDetails.get(pos).getQuantity());
        orderDetails.get(pos).setPrice(Math.round(orderDetails.get(pos).getPrice() * 10) / 10);
        session.setAttribute("orderDetails", orderDetails);
        return "redirect:/gio-hang";
    }

    @RequestMapping(value = "/xoa-san-pham")
    public String deleteProduct(Model model,
            @RequestParam(name = "pos") int pos,
            HttpSession session) {
        List<OrderDetailEntity> orderDetails = (List<OrderDetailEntity>) session.getAttribute("orderDetails");
        orderDetails.remove(orderDetails.get(pos));

        session.setAttribute("orderDetails", orderDetails);
        return "redirect:/gio-hang";
    }

    @RequestMapping(value = "/them-topping", method = RequestMethod.POST)
    public String addTopping(Model model,
            @RequestParam(name = "orderDetailPosition") int pos,
            @RequestParam(name = "topping", required = false) List<Integer> toppingIds,
            HttpSession session) {
        try {
            Set<ToppingEntity> toppings = toppingService.getToppingsByIds(toppingIds);
            List<OrderDetailEntity> orderDetails = (List<OrderDetailEntity>) session.getAttribute("orderDetails");
            orderDetails.get(pos).setToppings(toppings);

            int totalToppingPrice = 0;
            for (ToppingEntity topping : orderDetails.get(pos).getToppings()) {
                totalToppingPrice += topping.getPrice();
            }
            orderDetails.get(pos).setPrice(orderDetails.get(pos).getPrice() + totalToppingPrice * orderDetails.get(pos).getQuantity());
            session.setAttribute("orderDetails", orderDetails);
        } catch (Exception ex) {
            Logger.getLogger(ShopController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:/gio-hang";
    }

    @RequestMapping(value = "/dat-hang")
    public String viewCheckout(Model model, HttpSession session) {
        List<OrderDetailEntity> orderDetails = (List<OrderDetailEntity>) session.getAttribute("orderDetails");
        for (OrderDetailEntity orderDetail : orderDetails) {
            StringBuilder toppingStr = new StringBuilder();
            if (orderDetail.getToppings() != null) {
                for (ToppingEntity topping : orderDetail.getToppings()) {
                    toppingStr.append(topping.getName() + ",");
                }
                toppingStr.deleteCharAt(toppingStr.length() - 1);
            }
            orderDetail.setTopping(toppingStr.toString());
        }
        model.addAttribute("customer", new CustomerEntity());
        session.setAttribute("orderDetails", orderDetails);
        return "cart/check-out";
    }

    @RequestMapping(value = "/dat-hang", method = RequestMethod.POST)
    public String addOrder(HttpSession session,
            @ModelAttribute(name = "customer") CustomerEntity customer,
            @RequestParam(name = "totalPrice") double totalPrice,
            @Value(value = "${fileForSend}") String fileForSend,
            Authentication a) {
        if (a != null) {
            customer.setAccount((AccountEntity) a.getPrincipal());
        }
        List<OrderDetailEntity> orderDetails = (List<OrderDetailEntity>) session.getAttribute("orderDetails");
        OrderEntity order = new OrderEntity(new Date(), new Date(), totalPrice, OrderStatus.MAKING, orderDetails, customer);
        orderService.addOrder(order);
//        Send mail order
        fileForSend += "emailSendOrder.html";
        textHtml = new StringBuilder();
        File f = new File(context.getRealPath(fileForSend));
        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(f), "UTF-8"));) {

            String line;
            int check = 1;
            while ((line = reader.readLine()) != null) {
                //Custom name at Line 16 for total price and 17 for empty
                if (check == 2) {
                    textHtml.append("Tổng cộng:"+order.getTotalPrice());
                } else if (check == 3) {
                    textHtml.append("<table>");
                    textHtml.append("<tr><td>Tên</td><td>Đơn giá</td><td>Số lượng</td><td>Giá</td><td>Size</td><td>Topping</td></tr>");
                    for(OrderDetailEntity orderDetail : orderDetails){
                        textHtml.append(String.format("<tr><td>%s</td><td>%f</td><td>%d</td><td>%f</td><td>%s</td><td>%s</td></tr>", 
                                orderDetail.getProduct().getName(), orderDetail.getUnitPrice(), orderDetail.getQuantity(),
                                orderDetail.getPrice(), orderDetail.getSize().toString(), orderDetail.getTopping()));
                    }
                    
                    textHtml.append("</table>");
                } else {
                    textHtml.append(line);
                }
                check++;
            }
            MimeMessagePreparator preparator = new MimeMessagePreparator() {
                @Override
                public void prepare(MimeMessage mm) throws Exception {
                    MimeMessageHelper helper = new MimeMessageHelper(mm, false, "UTF-8");
                    helper.setSubject("Coffe Shop Order");
                    helper.setTo(customer.getEmail());
                    helper.setText(textHtml.toString(), true);
                }
            };
            jvs.send(preparator);
            textHtml = new StringBuilder();
        } catch (Exception ex) {
            Logger.getLogger(ShopController.class.getName()).log(Level.SEVERE, null, ex);
        }

        session.removeAttribute("orderDetails");
        return "orderSuccess";
    }

    @RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
    public String addAccount(Model model,
            @ModelAttribute(name = "account") AccountEntity account,
            @RequestParam(name = "rePassword") String rePassword,
            @Value(value = "${fileForSend}") String fileForSend) {
        // validate infomation
        boolean isValidated = true;
        String messageError = "";
        if (!account.getPassword().equals(rePassword)) {
            messageError = "Nhập lại mật khẩu không đúng";
            isValidated = false;
        } else if (accountService.isExistedUsername(account.getUsername())) {
            messageError = "Tài khoản đã tồn tại";
            isValidated = false;
        } else if (accountService.isExistedEmail(account.getEmail())) {
            messageError = "Email đã được sử dụng";
            isValidated = false;
        } else if (accountService.isExistedPhone(account.getPhone())) {
            messageError = "Số điện thoại đã được sử dụng";
            isValidated = false;
        } else if (account.getPassword().length() <= 6) {
            messageError = "Mật khẩu phải nhiều hơn 6 ký tự";
            isValidated = false;
        } else if (!account.getEmail().contains("@") && !account.getEmail().contains(".")) {
            messageError = "Email không chính xác";
            isValidated = false;
        }

        if (isValidated == false) {
            model.addAttribute("messageError", messageError);
            model.addAttribute("account", account);
            return "register";
        }

        account.setStatus(false);
        RoleEntity role = roleService.getRole(Role.ROLE_USER);
        account.setRoles(new LinkedHashSet<RoleEntity>());
        account.getRoles().add(role);
        accountService.addAccount(account);
        model.addAttribute("email", account.getEmail());

        fileForSend += "emailSendCode.html";
        this.sendCodeEmail(account.getEmail(), fileForSend);

        return "validateEmail";
    }

    @RequestMapping(value = "/xac-thuc-dang-ky", method = RequestMethod.POST)
    public String completeRegister(Model model,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "code") int code) {
        if (code != this.mailCode) {
            model.addAttribute("messageError", "Mã xác thực không chính xác");
            model.addAttribute("email", email);
            return "validateEmail";
        }
        accountService.updateAccountStatus(email, true);
        return "redirect:/dang-nhap";
    }

    @RequestMapping(value = "/xac-thuc-email")
    public String viewFormValidateEmail(Model model,
            @RequestParam(name = "email") String email,
            @Value(value = "${fileForSend}") String fileForSend) {

        fileForSend += "emailSendCode.html";
        this.sendCodeEmail(email, fileForSend);
        model.addAttribute("email", email);
        return "validateEmail";
    }
//    AJAX 

    @RequestMapping(value = "/list-san-pham")
    public String getCategory(Model model,
            @RequestParam(name = "name") String nameCategory) {
        List<ProductEntity> products = null;
        if (nameCategory.equalsIgnoreCase("best choose")) {
            products = productService.getBestProducts();
        } else {
            products = productService.getProductsByCategoryName(nameCategory);
        }

        model.addAttribute("products", products);
        model.addAttribute("favorite", false);
        return "ajax/listProducts";
    }

    @RequestMapping(value = "/tim-kiem-san-pham")
    public String searchProducts(Model model,
            @RequestParam(name = "name") String productName) {
        model.addAttribute("products", productService.searchProducts(productName));
        return "ajax/listProducts";
    }

    @RequestMapping(value = "/tim-ids-topping/{pos}")
    public @ResponseBody
    String searchTopping(@PathVariable("pos") int pos,
            HttpSession session) {
        String responseText = "";
        Set<ToppingEntity> toppings = ((List<OrderDetailEntity>) session.getAttribute("orderDetails"))
                .get(pos)
                .getToppings();
        List<Integer> ids = new ArrayList<>();
        if (toppings == null) {
            return responseText;
        } else {
            for (ToppingEntity topping : toppings) {
                ids.add(topping.getId());
            }
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            responseText = mapper.writeValueAsString(ids);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ShopController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return responseText;
    }

    @RequestMapping("/gui-code")
    public @ResponseBody
    String sendCodeEmail(
            @RequestParam(name = "email") String email,
            @Value(value = "${fileForSend}") String fileForSend) {

        mailCode = (int) Math.round(Math.random() * 1000000);
        textHtml = new StringBuilder();
        File f = new File(context.getRealPath(fileForSend));
        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(f), "UTF-8"));) {

            String line;
            int check = 1;
            while ((line = reader.readLine()) != null) {
                //Custom name at Line 35
                if (check == 2) {
                    textHtml.append(mailCode);
                } else {
                    textHtml.append(line);
                }
                check++;
            }
            MimeMessagePreparator preparator = new MimeMessagePreparator() {
                @Override
                public void prepare(MimeMessage mm) throws Exception {
                    MimeMessageHelper helper = new MimeMessageHelper(mm, false, "UTF-8");
                    helper.setSubject("Coffe Shop Validation");
                    helper.setTo(email);
                    helper.setText(textHtml.toString(), true);
                }
            };
            jvs.send(preparator);
            textHtml = new StringBuilder();
        } catch (Exception ex) {
            Logger.getLogger(ShopController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "ok";
    }
}
