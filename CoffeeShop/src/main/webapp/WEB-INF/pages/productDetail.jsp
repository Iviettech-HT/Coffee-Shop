<%-- 
    Document   : cart
    Created on : Oct 7, 2019, 11:56:33 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
        <title>Teaffee Shop</title>
    </head>
    <body>
        <jsp:include page="include/header.jsp"/>

        <main>
            <div class="container-product-info">
                <img src="${pageContext.request.contextPath}/${product.images[0].path}" alt="">
                <div class="product-info">
                    <div class="product-info__name">
                        <h1>
                            ${product.name}
                            <c:if test="${product.status == false}">
                                <span style="color: #999; font-size: 0.5em;">-Đã hết-</span>
                            </c:if>
                        </h1>
                    </div>
                    <p class="product-info__decription">
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Assumenda, nemo, iusto, expedita, aliquid neque nisi placeat non ad illum amet praesentium obcaecati labore dignissimos voluptate at. Deleniti et saepe assumenda?
                    </p>
                    <c:if test="${product.promotions.size() > 0}">
                        <c:set var="totalDiscount" value="${product.price}"/>
                        <c:forEach var="promotion" items="${product.promotions}">
                            <c:set var="totalDiscount" value="${totalDiscount*(1 - promotion.discount)}"/>
                        </c:forEach>

                        <p class="product-info__price--promotion">
                            <fmt:formatNumber type="number" pattern="###,###" value="${product.price}"/>đ
                        </p>
                        <p class="product-info__price">
                            <fmt:formatNumber type="number" pattern="###,###" value="${Math.round(totalDiscount)}"/>đ
                        </p>
                    </c:if>
                    <c:if test="${product.promotions.size() == 0}">
                        <p class="product-info__price">
                            <fmt:formatNumber type="number" pattern="###,###" value="${product.price}"/>đ
                        </p>
                    </c:if>

                    <c:if test="${product.status == true}">
                        <div class="product-info__sizes">
                            <p>Cỡ:</p>
                            <c:forEach var="size" items="${product.sizes}">
                                <div class="product-info__sizes__button"><p>${size.size}</p></div>
                                    </c:forEach>
                        </div>
                        <div class="product-info__buy-button">
                            <p>Thêm vào giỏ</p>
                        </div>
                    </c:if>
                    <c:set var="countStar" value="0"/>
                    <c:set var="totalStar" value="0"/>
                    <c:forEach var="star" items="${product.votes}">
                        <c:set var="countStar" value="${countStar + 1}"/>
                        <c:set var="totalStar" value="${totalStar + star.star}"/>
                    </c:forEach>
                    <div id="vote">
                        <div class="star"></div>
                        <div class="star"></div>
                        <div class="star"></div>
                        <div class="star"></div>
                        <div class="star"></div>
                    </div>
                </div>
            </div>
        </main>    

        <script type="text/javascript">
            let sizes = document.getElementsByClassName('product-info__sizes__button');
            let addToCart = document.getElementsByClassName('product-info__buy-button')[0];
            let sizeId = ${product.sizes.iterator().next().id};
            let stars = document.getElementsByClassName('star');
            let totalStar = ${totalStar/countStar};
            let vote = document.getElementById('vote');
            console.log(totalStar);
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
//          Star
            addSelectedToStars(totalStar);
            <sec:authorize access="isAuthenticated()">
                <sec:authentication var="user" property="principal"/>
                <sec:authorize access="${user.status}">
            vote.onmouseover = () => {
                for (let star of stars) {
                    star.classList.remove('selected');
                }
            }
            vote.onmouseout = () => addSelectedToStars(totalStar);
//          set onclick per star
            for (let i = 0; i < 5; i++) {
                stars[i].onclick = () => {
                    let xhttp = new XMLHttpRequest();
                    xhttp.open('GET', '${pageContext.request.contextPath}/user/them-danh-gia/${product.id}/' + (5 - i), true);
                    xhttp.send();
                    xhttp.onreadystatechange = () => {
                        if (xhttp.readyState == 4 && xhttp.status == 200) {
                            totalStar = parseInt(xhttp.responseText);
                        }
                    }
                }
            }
//
                </sec:authorize>
            </sec:authorize>
            addToCart.onclick = () => {
                window.location = '<c:url value="/them-vao-gio-hang/${product.id}/"/>' + sizeId;
            }

            function addSelectedToStars(numberStar) {
                numberStar = Math.round(numberStar);
                for (let star of stars) {
                    star.classList.remove('selected');
                }
                for (let i = 4; i >= 5 - numberStar; i--) {
                    stars[i].classList.add('selected');
                }
            }
        </script>
        <jsp:include page="include/footer.jsp"/>
        <jsp:include page="include/script/standardScript.jsp"/>
    </body>
</html>
