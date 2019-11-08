<%-- 
    Document   : slidebarMenuAdmin
    Created on : Oct 11, 2019, 4:21:06 PM
    Author     : PC
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="sidebar"><a href="#" class="visible-phone"><i class="icon icon-home"></i> Dashboard</a>
    <ul>
        <li class="active"><a href = "<c:url value = "/admin/home"/>"><i class="icon icon-home"></i> <span>Dashboard</span></a> </li>
        <li> <a href = "<c:url value = "/admin/category"/>"><i class="icon icon-signal"></i> <span>Category</span></a> </li>
        <li> <a href="<c:url value = "/admin/product"/>"><i class="icon icon-inbox"></i> <span>Product</span></a> </li>
        <li> <a href="<c:url value = "/admin/promotion"/>"><i class="icon icon-inbox"></i><span>Promotion</span> </a> </li>
        <li class="submenu"> <a href="#"><i class="icon icon-file"></i> <span>Orders</span></a>
            <ul>
                <li><a href="<c:url value = "/admin/order"/>"><i class="icon icon-tint"></i>All Orders</a></li>
                <li><a href="<c:url value = "/admin/new-order"/>"><i class="icon icon-tint"></i>New Orders</a></li>
                <li><a href="<c:url value = "/admin/making-order"/>"><i class="icon icon-tint"></i>Making Orders</a></li>
                <li><a href="<c:url value = "/admin/shipping-order"/>"><i class="icon icon-tint"></i>Shipping Orders</a></li>
                <li><a href="<c:url value = "/admin/cancel-order"/>"><i class="icon icon-tint"></i>Cancel Orders</a></li>
                <li><a href="<c:url value = "/admin/done-order"/>"><i class="icon icon-tint"></i>Done Orders</a></li>

            </ul>
        </li>
        <li><a href="<c:url value = "/admin/account"/>"><i class="icon icon-tint"></i> Account</a></li>
    </ul>
</div>