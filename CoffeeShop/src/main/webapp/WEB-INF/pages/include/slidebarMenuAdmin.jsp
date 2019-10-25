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
        <li><a href="buttons.html"><i class="icon icon-tint"></i> <span>Buttons &amp; icons</span></a></li>
        <li><a href="interface.html"><i class="icon icon-pencil"></i> <span>Eelements</span></a></li>
        <li class="submenu"> <a href="#"><i class="icon icon-file"></i> <span>Addons</span> <span class="label label-important">5</span></a>
            <ul>
                <li><a href="index2.html">Dashboard2</a></li>
                <li><a href="gallery.html">Category</a></li>
                <li><a href="calendar.html">Product</a></li>
                <li><a href="invoice.html">Invoice</a></li>
                <li><a href="chat.html">Chat option</a></li>
            </ul>
        </li>
        <li class="submenu"> <a href="#"><i class="icon icon-info-sign"></i> <span>Error</span> <span class="label label-important">4</span></a>
            <ul>
                <li><a href="error403.html">Error 403</a></li>
                <li><a href="error404.html">Error 404</a></li>
                <li><a href="error405.html">Error 405</a></li>
                <li><a href="error500.html">Error 500</a></li>
            </ul>
        </li>

    </ul>
</div>