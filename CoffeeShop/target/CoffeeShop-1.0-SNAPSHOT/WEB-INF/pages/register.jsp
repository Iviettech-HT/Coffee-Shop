<%-- 
    Document   : register
    Created on : Oct 7, 2019, 11:54:17 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign in</title>
	<link rel="shortcut icon" href="images/favicon.ico">
	<link rel="stylesheet" type="text/css" href="resources/css/loginStyle.css">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta charset="utf-8">
    </head>
    <body>
        <style>
            .group input{
                margin : 5% 0;
            }
            .group input:focus ~ label, .group input:valid ~ label{
                top: -10%;
            }
        </style>
        <div id="form">
            <form id="container">
                <h1>Register</h1>
                <div class="group">
                    <input type="text" name="fullName" required id="username">
                    <label for="username">Họ và tên</label>
                </div>
                <div class="group">
                    <input type="email" name="email" required id="email">
                    <label for="email">Email</label>
                </div>
                <div class="group">
                    <input type="number" name="phoneNumber" required id="phoneNumber" min="0">
                    <label for="phoneNumber">Số điện thoại</label>
                </div>
                <div class="group">
                    <input type="text" name="username" required id="username">
                    <label for="username">Tên đăng nhập</label>
                </div>
                <div class="group">
                    <input type="password" name="password" required id="password">
                    <label for="password">Mật khẩu</label>
                </div>
                <div class="group">
                    <input type="password" name="rePassword" required id="re-password">
                    <label for="re-password">Nhập lại mật khẩu</label>
                </div>
                <div class="button">
                    <input type="submit" name="submit" value="Đăng ký">
                </div>
                <div class="register">
                    <h4>Nếu đã có tài khoản vui lòng <a href="<c:url value="/dang-nhap"/>">Đăng nhập</a>.
                        Trở về <a href="<c:url value="/home"/>">trang chủ</a></h4>
                </div>
            </form>
        </div>
    </body>
</html>
