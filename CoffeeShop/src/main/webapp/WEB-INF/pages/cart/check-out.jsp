<%-- 
    Document   : check-out
    Created on : Oct 8, 2019, 11:50:50 AM
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
        <link rel="stylesheet" href="resources/css/checkoutStyle.css">
        <link rel="shortcut icon" href="images/landingPage/favicon.png">
        <title>Teaffee Shop</title>
    </head>
    <body>
        <jsp:include page="../include/header.jsp"/>
        <main>
            <div class="title main__element--background">
                <h1>ĐƠN HÀNG</h1>
            </div>
            <div class="container-info">

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
                                    2
                                </td>
                                <td>300</td>
                            </tr>
                            <tr>
                                <td>
                                    <img src="resources\images\landingPage\products\product.jpg" alt="product">
                                </td>
                                <td>Product1</td>
                                <td>150</td>
                                <td>
                                    2
                                </td>
                                <td>300</td>
                            </tr>
                            <tr>
                                <td>
                                    <img src="resources\images\landingPage\products\product.jpg" alt="product">
                                </td>
                                <td>Product1</td>
                                <td>150</td>
                                <td>
                                    2
                                </td>
                                <td>300</td>
                            </tr>
                            <tr>
                                <td colspan="6">
                                    <h2>Total price: 900</h2>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="personal-info">
                    <form action="" class="main__element--background">
                        <table>
                            <tr>
                                <td>
                                    <label for="name">Họ và tên:</label>
                                </td>
                                <td>
                                    <input type="text" name="name" id="name" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="name">Email:</label>
                                </td>
                                <td>
                                    <input type="text" name="email" id="name" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="name">SĐT:</label>
                                </td>
                                <td>
                                    <input type="text" name="phone" id="name" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label for="name">Địa chỉ:</label>
                                </td>
                                <td>
                                    <input type="text" name="address" id="name" />
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
            <div class="action">
                <div class="action__button main__element--background">
                    <p>Trở về</p>
                </div>
                <div class="action__button main__element--background">
                    <p>Xác nhận</p>
                </div>
            </div>
        </main>
        <jsp:include page="../include/footer.jsp"/>
        <script src="resources/js/standard.js"></script>
    </body>
</html>
