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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/cartStyle.css">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/landingPage/favicon.png">
        <title>Teaffee Shop</title>
    </head>
    <body>
        <c:set var="orderDetails" value="${sessionScope.orderDetails}"/>
        <jsp:include page="../include/header.jsp"/>
        <main>
            <div class="title main__element--background">
                <h1>GIỎ HÀNG</h1>
            </div>
            <div class="list-product main__element--background">
                <table>
                    <thead>
                        <tr>
                            <th></th>
                            <th>Tên sản phẩm</th>
                            <th>Đơn giá</th>
                            <th>Số lượng</th>
                            <th>Giá</th>
                            <th>Size</th>
                            <th>Topping</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody style="text-align: center;">
                        <c:set var="totalPrice" value="0"/>
                        <c:set var="position" value="0"/>
                        <c:forEach var="orderDetail" items="${orderDetails}">
                            <tr>
                                <td>
                                    <img src="${pageContext.request.contextPath}/${orderDetail.product.images[0].path}" alt="${orderDetail.product.name}">
                                </td>
                                <td>${orderDetail.product.name}</td>
                                <td>${orderDetail.unitPrice}00</td>
                                <td><input type="number" value="${orderDetail.quantity}"></td>
                                <td>${orderDetail.price}00</td>
                                <td>${orderDetail.size}</td>
                                <td></td>
                                <td>
                                    <a href="<c:url value="/xoa-san-pham?pos=${position}"/>" class="delete-product">XÓA</a>
                                </td>
                            </tr>
                            <c:set var="totalPrice" value="${totalPrice + orderDetail.price}"/>
                            <c:set var="position" value="${position + 1}"/>
                        </c:forEach>
                        <tr>
                            <td colspan="8">
                                <h2>Total price: ${totalPrice}00 VNĐ</h2>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="action">
                <div class="action__button main__element--background">
                    <p>Tiếp tục mua</p>
                </div>
                <div class="action__button main__element--background">
                    <p onclick="window.location = 'dat-hang'">Đặt hàng</p>
                </div>
                <div class="action__button main__element--background">
                    <p>Cập nhật giỏ hàng</p>
                </div>
            </div>
        </main>
        <jsp:include page="../include/footer.jsp"/>
        <script src="resources/js/standard.js"></script>
    </body>
</html>
