<%-- 
    Document   : login
    Created on : Oct 7, 2019, 11:42:27 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="images/favicon.ico">
        <link rel="stylesheet" type="text/css" href="resources/css/loginStyle.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Đăng nhập</title>
        <meta charset="utf-8">
    </head>
</head>
<body>
    <div id="form">
        <form id="container">
            <h1>Sign in</h1>
            <div class="group">
                <input type="text" name="userName" required id="username">
                <label for="username">Tên đăng nhập</label>
            </div>
            <div class="group">
                <input type="password" name="password" required id="password">
                <label for="password">Mật khẩu</label>				
            </div>
            <div class="button">
                <input type="submit" name="submit" value="Đăng nhập">
            </div>
            <div class="register">
                <h4>Nếu chưa có tài khoản vui lòng <a href='<c:url value="/dang-ky"/>'>Đăng ký</a>.
                    Trở về <a href="<c:url value="/home"/>">trang chủ</a></h4>
            </div>
        </form>
    </div>
</body>
</body>
</html>
