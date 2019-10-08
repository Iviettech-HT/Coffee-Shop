<%-- 
    Document   : cart
    Created on : Oct 7, 2019, 11:56:33 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <link rel="stylesheet" href="resources/css/standard.css">
        <link rel="stylesheet" href="resources/css/cartStyle.css">
        <link rel="shortcut icon" href="images/landingPage/favicon.png">
        <title>Teaffee Shop</title>
    </head>
    <body>
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
                            <th>Tên</th>
                            <th>Đơn giá</th>
                            <th>Số lượng</th>
                            <th>Giá</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody style="text-align: center;">
                        <tr>
                            <td>
                                <img src="resources\images\landingPage\products\product.jpg" alt="product">
                            </td>
                            <td>Product1</td>
                            <td>150</td>
                            <td>
                                <input type="number" value="2">
                            </td>
                            <td>300</td>
                            <td>
                                <p class="delete-product">XÓA</p>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <img src="resources\images\landingPage\products\product.jpg" alt="product">
                            </td>
                            <td>Product1</td>
                            <td>150</td>
                            <td>
                                <input type="number" value="2">
                            </td>
                            <td>300</td>
                            <td>
                                <p class="delete-product">XÓA</p>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <img src="resources\images\landingPage\products\product.jpg" alt="product">
                            </td>
                            <td>Product1</td>
                            <td>150</td>
                            <td>
                                <input type="number" value="2">
                            </td>
                            <td>300</td>
                            <td>
                                <p class="delete-product">XÓA</p>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="6">
                                <h2>Total price: 900</h2>
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
                    <p onclick="window.location='dat-hang'">Đặt hàng</p>
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
