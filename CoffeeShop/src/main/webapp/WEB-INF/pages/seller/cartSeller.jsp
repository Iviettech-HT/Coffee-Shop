<%-- 
    Document   : cartSeller
    Created on : Nov 2, 2019, 9:09:44 PM
    Author     : admin
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link rel="stylesheet" href="<c:url value="/resources/css/sellerTabStyle.css"/>"/>
        <title>JSP Page</title>
        <style>
            .container{
                width: 100%;
            }
        </style>
    </head>
    <body>
        <c:set var="sellerOrderDetails" value="${sessionScope.sellerOrderDetails}"/>
        <div class="container">
            <h1>TRANG BÁN HÀNG</h1>
        </div>
        <div id="exTab1" class="container" style="width: 100%">	
            <ul  class="nav nav-pills">
                <li>
                    <a  href="<c:url value="/seller/home"/>" data-toggle="tab">Sản phẩm</a>
                </li>
                <li class="active"><a href="<c:url value="/seller/gio-hang"/>">Giỏ hàng 
                        <span class="badge">${sellerOrderDetails.size()}</span></a>
                </li>
                <li><a href="<c:url value="/seller/don-hang-online"/>" data-toggle="tab">Đơn hàng online</a>
                </li>
                <li><a href="<c:url value="/seller/don-hang-dang-ship"/>" data-toggle="tab">Đơn hàng đang ship</a>
                </li>
                <li>
                    <a  href="" data-toggle="tab">Quản lý</a>
                </li>
            </ul>

            <div class="tab-content clearfix">

                <div class="tab-pane active  table-responsive" id="2a">
                    <h2>ĐƠN HÀNG</h2>         

                    <c:if test="${sellerOrderDetails.size() > 0}">
                        <table class="table table-striped table-bordered">
                            <thead>
                                <tr>
                                    <th>Tên</th>
                                    <th>Đơn giá</th>
                                    <th>Số lượng</th>
                                    <th>Giá</th>
                                    <th>Size</th>
                                    <th>Topping</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:set var="position" value="0"/>
                                <c:forEach var="orderDetail" items="${sellerOrderDetails}">
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
                                        <td><a href="<c:url value="/seller/xoa-don-hang/${position}"/>"
                                               class="btn btn-danger">Xóa</a></td>
                                    </tr>
                                    <c:set var="position" value="${position + 1}"/>
                                </c:forEach>
                                <tr>
                                    <td colspan="7">
                                        <a href="<c:url value="/seller/dat-hang"/>" class="btn btn-success">XÁC NHẬN</a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </c:if>
                    <c:if test="${empty sellerOrderDetails}">
                        <h4>Không có sản phẩm nào</h4>
                        <a href="<c:url value="/seller/home"/>" class="btn btn-success">Chọn sản phẩm</a>
                    </c:if>
                </div>
            </div>
        </div>
    </body>
</html>
