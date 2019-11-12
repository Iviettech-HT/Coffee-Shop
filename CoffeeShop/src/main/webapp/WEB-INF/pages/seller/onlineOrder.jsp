<%-- 
    Document   : onlineOrder
    Created on : Nov 3, 2019, 10:48:44 AM
    Author     : admin
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<c:url value="/webjars/bootstrap/3.4.1/css/bootstrap.min.css"/>"/>
        <link rel="stylesheet" href="<c:url value="/resources/css/sellerTabStyle.css"/>"/>
        <title>Seller Page</title>
        <style>
            .container{
                width: 100%;
            }
        </style>
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="../include/sellerHeader.jsp"/>

            <div class="tab-content clearfix">

                <div class="tab-pane active  table-responsive" id="2a">
                    <h2>ĐƠN HÀNG ONLINE</h2>         
                    <c:forEach var="order" items="${orders}">
                        <div class="container">
                            <h3>
                                ${order.customer.name}
                                <c:if test="${order.status.toString() eq 'MAKING'}">
                                    (Đang thực hiện...)
                                </c:if>
                            </h3>
                            <p>${order.orderDate}</p>
                            <p>${order.totalPrice}</p>
                            <button type="button" class="btn btn-info" 
                                    data-toggle="collapse" 
                                    data-target="#order-${order.id}">Chi tiết</button>
                            <div id="order-${order.id}" class="collapse">

                                <table class="table table-striped table-bordered">
                                    <thead>
                                        <tr>
                                            <th>Tên</th>
                                            <th>Đơn giá</th>
                                            <th>Số lượng</th>
                                            <th>Giá</th>
                                            <th>Size</th>
                                            <th>Topping</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:set var="position" value="0"/>
                                        <c:forEach var="orderDetail" items="${order.orderDetails}">
                                            <tr>
                                                <td>${orderDetail.product.name}</td>
                                                <td>
                                                    <fmt:formatNumber type="number" pattern="###,###" value="${orderDetail.unitPrice}"/>đ
                                                </td>
                                                <td>
                                                    ${orderDetail.quantity}
                                                </td>
                                                <td>
                                                    <fmt:formatNumber type="number" pattern="###,###" value="${orderDetail.price}"/>đ
                                                </td>
                                                <td>${orderDetail.size}</td>
                                                <td>${orderDetail.topping}</td>
                                            </tr>
                                            <c:set var="position" value="${position + 1}"/>
                                        </c:forEach>
                                        <tr>
                                            <td colspan="7">
                                                <c:if test="${!(order.status.toString() eq 'MAKING')}">
                                                    <a href="<c:url value="/seller/lam-don-hang-online/${orderId}"/>" class="btn btn-primary">NHẬN ĐƠN HÀNG</a>
                                                </c:if>
                                                <c:if test="${order.status.toString() == 'MAKING'}">
                                                    <a href="<c:url value="/seller/xac-nhan-don-hang-online/${order.id}"/>" class="btn btn-success">BẮT ĐẦU SHIP</a>
                                                </c:if>
                                                <a href="<c:url value="/seller/huy-don-hang"/>" class="btn btn-danger">HỦY</a>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </div>
        </div>

        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </body>
</html>
