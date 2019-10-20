<%-- 
    Document   : cart
    Created on : Oct 7, 2019, 11:56:33 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/standard.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/productDetailStyle.css">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/landingPage/favicon.png">
        <title>Teaffee ABC</title>
    </head>
    <body>
        <jsp:include page="include/header.jsp"/>

        <main>
            <div class="container-product-info">
                <img src="${pageContext.request.contextPath}/${product.images[0].path}" alt="">
                <div class="product-info">
                    <div class="product-info__name">
                        <h1>${product.name}</h1>
                    </div>
                    <p class="product-info__decription">
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Assumenda, nemo, iusto, expedita, aliquid neque nisi placeat non ad illum amet praesentium obcaecati labore dignissimos voluptate at. Deleniti et saepe assumenda?
                    </p>
                    <c:if test="${product.promotions.size() > 0}">
                        <c:set var="totalDiscount" value="${product.price}"/>
                        <c:forEach var="promotion" items="${product.promotions}">
                            <c:set var="totalDiscount" value="${totalDiscount*(1 - promotion.discount)}"/>
                        </c:forEach>
                        <p class="product-info__price">
                            ${product.price}00 VNĐ
                            <span style="color: red">(-${Math.round((product.price-totalDiscount)*10)}00)</span>
                        </p>
                    </c:if>
                    <c:if test="${product.promotions.size() == 0}">
                        <p class="product-info__price">
                            ${product.price}00 VNĐ
                        </p>
                    </c:if>
                    <div class="product-info__sizes">
                        <p>Cỡ:</p>

                        <c:forEach var="size" items="${product.sizes}">
                            <div class="product-info__sizes__button"><p>${size.size}</p></div>
                                </c:forEach>
                    </div>
                    <div class="product-info__buy-button">
                        <p>Thêm vào giỏ</p>
                    </div>
                </div>
            </div>
        </main>    

        <script type="text/javascript">
            let sizes = document.getElementsByClassName('product-info__sizes__button');
            let addToCart = document.getElementsByClassName('product-info__buy-button')[0];
            let sizeId = ${product.sizes.iterator().next().id};
            for (let size of sizes) {
                size.onclick = () => {
                    for (let size of sizes)
                        size.classList.remove('product-info__sizes__button--active');
                    size.classList.add('product-info__sizes__button--active');
                    if (size.children[0].innerHTML == "S")
                        sizeId = 1;
                    else if (size.children[0].innerHTML == "M")
                        sizeId = 2;
                    else if (size.children[0].innerHTML == "L")
                        sizeId = 3;
                }
            }
            
            addToCart.onclick = () => {
                window.location = '<c:url value="/them-vao-gio-hang/${product.id}/"/>' + sizeId;
            }
        </script>
        <jsp:include page="include/footer.jsp"/>
        <jsp:include page="include/script/productDetailScript.jsp"/>
    </body>
</html>
