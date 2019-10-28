<%-- 
    Document   : listProduct
    Created on : Oct 17, 2019, 4:30:22 PM
    Author     : admin
--%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<c:forEach var="product" items="${products}">
    <div class="product__item" id="product${product.id}">
        <img src="${product.images[0].path}" alt="product">
        <a href="<c:url value="/chi-tiet-san-pham/${product.id}"/>" class="product__item--name">
            ${product.name}
            <c:if test="${product.status == false}">
                <span style="color: #999; font-size: 0.8em;">(Đã hết)</span>
            </c:if>
        </a>
        <c:if test="${product.promotions.size() > 0}">
            <c:set var="totalDiscount" value="${product.price}"/>
            <c:forEach var="promotion" items="${product.promotions}">
                <c:set var="totalDiscount" value="${totalDiscount*(1 - promotion.discount)}"/>
            </c:forEach>
            <p class="product__item--price">
                ${product.price}00 vnđ
                <span style="color: red">(-${Math.round((product.price-totalDiscount)*10)}00)</span>
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
                <a href="<c:url value="/them-vao-gio-hang/${product.id}/${size.id}"/>" 
                   class="size">Size ${size.size}</a>
            </c:forEach>
            <sec:authorize access="isAuthenticated()">
                <c:if test="${favorite == true}">
                    <a onclick="deleteFavoriteProduct(${product.id})" class="delete-favorite">Delete</a>
                </c:if>
                <c:if test="${favorite == false}">
                    <a href="<c:url value="/user/them-vao-yeu-thich/${product.id}"/>" class="favorite">Thêm vào yêu thích</a>
                </c:if>
            </sec:authorize>
        </div>
    </div>
</c:forEach>