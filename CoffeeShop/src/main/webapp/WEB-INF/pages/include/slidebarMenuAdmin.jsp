<%-- 
    Document   : slidebarMenuAdmin
    Created on : Oct 11, 2019, 4:21:06 PM
    Author     : PC
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="sidebar"><a href="#" class="visible-phone"><i class="icon icon-home"></i> Dashboard</a>
    <ul>
        <li class="active"><a href="home.html"><i class="icon icon-home"></i> <span>Dashboard</span></a> </li>
        <li> <a href = "<c:url value = "/admin/category"/>"><i class="icon icon-signal"></i> <span>Category</span></a> </li>
        <li> <a href="<c:url value = "/admin/product"/>"><i class="icon icon-inbox"></i> <span>Product</span></a> </li>
        <li class="submenu"> <a href=<c:url value = "/admin/promotion"/>"><i class="icon icon-th-list"></i> <span>Promotion</span> <span class="label label-important">2</span></a>
            <ul>
                <li><a href="<c:url value = "/admin/promotion"/>">Promotion</a></li>
                <li><a href="<c:url value = "/admin/promotionForProduct"/>">Promotion for Product</a></li>
            </ul>
        </li>
        <li><a href="<c:url value = "/admin/order"/>"><i class="icon icon-tint"></i> Orders</a></li>
        <li><a href="<c:url value = "/admin/order"/>"><i class="icon icon-tint"></i> Orders</a></li>
    </ul>
</div>