<%-- 
    Document   : listProduct
    Created on : Oct 17, 2019, 4:30:22 PM
    Author     : admin
--%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<c:forEach var="product" items="${products}">
    <div class="product__item">
        <img src="${product.images[0].path}" alt="product">
        <p class="product__item--name">${product.name}</p>
        <c:if test="${product.promotions.size() > 0}">
            <c:set var="totalDiscount" value="0"/>
            <c:forEach var="promotion" items="${product.promotions}">
                <c:set var="totalDiscount" value="${totalDiscount + promotion.discount}"/>
            </c:forEach>
            <p class="product__item--price">
                ${product.price}00 vnđ
                <span style="color: red">(-${Math.round(product.price*totalDiscount*10)}00)</span>
            </p>
        </c:if>
        <c:if test="${product.promotions.size() == 0}">
            <p class="product__item--price">
                ${product.price}00 vnđ
            </p>
        </c:if>
        <p class="product__item--vote">
            <c:set var="countStar" value="0"/>
            <c:set var="totalStar" value="0"/>
            <c:forEach var="star" items="${product.votes}">
                <c:set var="countStar" value="${countStar + 1}"/>
                <c:set var="totalStar" value="${totalStar + star.star}"/>
            </c:forEach>
            ${totalStar/countStar}
            <span style="vertical-align: text-bottom">&#11088;</span>
        </p>
        <div class="product__info">
            <img src="resources\images\landingPage\products\add-to-cart-icon.svg" alt="add-to-cart">
            <p>Thêm vào giỏ</p>
            <c:forEach var="size" items="${product.sizes}">
                <a class="size">Size ${size.size}</a>
            </c:forEach>
            <sec:authorize access="isAuthenticated()">
                <a class="vote">Vote</a>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <a class="favorite">Thêm vào yêu thích</a>
            </sec:authorize>
        </div>
    </div>
</c:forEach>