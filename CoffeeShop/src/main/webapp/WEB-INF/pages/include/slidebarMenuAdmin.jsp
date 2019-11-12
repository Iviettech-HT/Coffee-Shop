<%-- 
    Document   : slidebarMenuAdmin
    Created on : Oct 11, 2019, 4:21:06 PM
    Author     : PC
--%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="sidebar"><a href="#" class="visible-phone"><i class="icon icon-home"></i> Dashboard</a>
    <ul>

        <sec:authorize access="hasRole('ROLE_MANAGER')">
            <li class="active"><a href = "<c:url value = "/admin/home"/>"><i class="icon icon-home"></i> <span>Dashboard</span></a> </li>
            <li> <a href = "<c:url value = "/admin/category"/>"><i class="icon icon-signal"></i> <span>Category</span></a> </li>
            <li> <a href="<c:url value = "/admin/product"/>"><i class="icon icon-inbox"></i> <span>Product</span></a> </li>
            <li> <a href="<c:url value = "/admin/promotion"/>"><i class="icon icon-star"></i><span>Promotion</span> </a> </li>
            <li class="submenu"> <a href="#"><i class="icon icon-file"></i> <span>Orders</span><i class="icon icon-chevron-right"></i></a>
                <ul>
                     <li><a href="<c:url value = "/admin/order"/>"><i class="icon icon-list-ul"></i>All Orders</a></li>
                    <li><a href="<c:url value = "/admin/new-order"/>"><i class="icon icon-tag"></i>New Orders</a></li>
                    <li><a href="<c:url value = "/admin/making-order"/>"><i class="icon icon-cog"></i>Making Orders</a></li>
                    <li><a href="<c:url value = "/admin/shipping-order"/>"><i class="icon icon-truck"></i>Shipping Orders</a></li>
                    <li><a href="<c:url value = "/admin/cancel-order"/>"><i class="icon icon-remove"></i>Cancel Orders</a></li>
                    <li><a href="<c:url value = "/admin/done-order"/>"><i class="icon icon-thumbs-up"></i>Done Orders</a></li>

                </ul>
            </li>
        </sec:authorize>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <li class="active"><a href = "<c:url value = "/admin/home"/>"><i class="icon icon-home"></i> <span>Dashboard</span></a> </li>
            <li> <a href = "<c:url value = "/admin/category"/>"><i class="icon icon-signal"></i> <span>Category</span></a> </li>
            <li> <a href="<c:url value = "/admin/product"/>"><i class="icon icon-inbox"></i> <span>Product</span></a> </li>
            <li> <a href="<c:url value = "/admin/promotion"/>"><i class="icon icon-gift"></i><span>Promotion</span> </a> </li>
            <li class="submenu"> <a href="#"><i class="icon icon-file"></i> <span>Orders</span><i class="icon icon-chevron-right"></i></a>
                <ul>
                    <li><a href="<c:url value = "/admin/order"/>"><i class="icon icon-list-ul"></i>All Orders</a></li>
                    <li><a href="<c:url value = "/admin/new-order"/>"><i class="icon icon-tag"></i>New Orders</a></li>
                    <li><a href="<c:url value = "/admin/making-order"/>"><i class="icon icon-cog"></i>Making Orders</a></li>
                    <li><a href="<c:url value = "/admin/shipping-order"/>"><i class="icon icon-truck"></i>Shipping Orders</a></li>
                    <li><a href="<c:url value = "/admin/cancel-order"/>"><i class="icon icon-remove"></i>Cancel Orders</a></li>
                    <li><a href="<c:url value = "/admin/done-order"/>"><i class="icon icon-thumbs-up"></i>Done Orders</a></li>

                </ul>
            <li><a href="<c:url value = "/admin/account"/>"><i class="icon icon-user"></i> Account</a></li>
            </li>
        </sec:authorize>


    </ul>
</div>