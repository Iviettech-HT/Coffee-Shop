<%-- 
    Document   : head
    Created on : Oct 7, 2019, 9:25:00 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<header>
    <div class="search">
        <img src="resources\images\landingPage\logo.jpg" alt="logo" class="logo"
             onclick="window.location = '<c:url value="/home"/>'" />
        <input type="text" name="" placeholder="Tìm kiếm" />
        <img src="resources\images\landingPage\search-icon.svg" alt="search" class="search__icon" />
    </div>
    <div class="control">
        <a href="#contact">LIÊN HỆ</a>
        <a>KHUYỄN MÃI</a>
        <a href="#">MENU</a>
        <img src="resources\images\landingPage\cart_icon.svg" alt="cart" onclick="window.location = '<c:url value="/gio-hang"/>'" />
        <div class="menu">
            <div class="line"></div>
            <div class="line"></div>
            <div class="line"></div>
            <ul class="menu__sub">
                <li class="menu-content-responsive">
                    <a href="#">MENU</a>
                </li>
                <li class="menu-content-responsive">
                    <a>KHUYỄN MÃI</a>
                </li>
                <li class="menu-content-responsive">
                    <a href="#contact">LIÊN HỆ</a>
                </li>
                <li>
                    <a>CHÍNH SÁCH</p>
                </li>
                <li>
                    <a href='<c:url value="/dang-nhap"/>'>ĐĂNG NHẬP</a>
                </li>
                <li>
                    <a href='<c:url value="/dang-ky"/>'>ĐĂNG KÝ</a>
                </li>
            </ul>
        </div>
    </div>
</header>