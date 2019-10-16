<%-- 
    Document   : home
    Created on : Sep 29, 2019, 7:55:06 PM
    Author     : admin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />

        <link rel="stylesheet" href="resources/css/style.css">
        <link rel="stylesheet" href="resources/css/standard.css">
        <link rel="shortcut icon" href="resources/images/landingPage/favicon.png">
        <title>Teaffee Shop</title>
    </head>
    <body>
        <jsp:include page="include/header.jsp"/>
        <div class="show-image">
            <div class="animation-shop">
                <a href="#main">SHOP NOW</a>
                <img src="resources\images\landingPage\angle-arrow-down-icon.svg" alt="down-arrow">
            </div>
        </div>
        <main id="main">
            <div class="sale">
                <div class="sale__info">
                    <h4>Title:</h4>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. At, necessitatibus tempore sit impedit cupiditate incidunt eveniet ad possimus recusandae fugit. Quidem, dicta vitae nihil deleniti dolore dolorem voluptatibus reprehenderit laudantium.</p>
                </div>
                <div class="sale__info">
                    <h4>Title:</h4>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. At, necessitatibus tempore sit impedit cupiditate incidunt eveniet ad possimus recusandae fugit. Quidem, dicta vitae nihil deleniti dolore dolorem voluptatibus reprehenderit laudantium.</p>
                </div>
                <div class="sale__info">
                    <h4>Title:</h4>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. At, necessitatibus tempore sit impedit cupiditate incidunt eveniet ad possimus recusandae fugit. Quidem, dicta vitae nihil deleniti dolore dolorem voluptatibus reprehenderit laudantium.</p>
                </div>
            </div>
            <div class="filter">
                <p class="spacing">Bộ Lọc:</p>
                <div class="filter__selection">
                    <a href="" class="spacing">Giá từ thấp đến cao</a>
                    <a href="" class="spacing">Giá từ cao xuống thấp</a>
                    <a href="" class="spacing">Sản phẩm được mua nhiều</a>

                </div>
            </div>
            <nav>
                <ul class="category">
                    <li class="category__item-header">
                        <h2>Danh mục:</h2>
                    </li>
                    <li class="category__item category__item--border category__item--active">
                        <p>Best choose</p>
                    </li>
                    <li class="category__item">
                        <p>Cà phê
                    </li>
                    <li class="category__item">
                        <p>Soda/Mojito</p>
                    </li>
                    <li class="category__item">
                        <p>Trà kem sữa</p>
                    </li>
                    <li class="category__item">
                        <p>Nước ép</p>
                    </li>
                    <li class="category__item">
                        <p>Sữa chua</p>
                    </li>
                    <li class="category__item">
                        <p>Trà trái cây</p>
                    </li>
                    <li class="category__item">
                        <p>Trà sữa</p>
                    </li>
                    <li class="category__item">
                        <p>Đá xay</p>
                    </li>
                    <li class="category__item">
                        <p>Topping</p>
                    </li>
                    <li class="category__item">
                        <p>Ăn nhẹ</p>
                    </li>
                </ul>
            </nav>
            <div class="product">
                <div class="product__item">
                    <img src="resources\images\landingPage\products\product.jpg" alt="product">
                    <p class="product__item--name">Product name</p>
                    <p class="product__item--price">20000 vnđ</p>
                    <p class="product__item--vote">5<span style="vertical-align: text-bottom">&#11088;</span></p>
                    <div class="product__info">
                        <img src="resources\images\landingPage\products\add-to-cart-icon.svg" alt="add-to-cart">
                        <p>Thêm vào giỏ</p>
                        <a class="size">Size M</a>
                        <a class="size">Size L</a>
                        <a class="vote">Vote</a>
                        <a class="favorite">Thêm vào yêu thích</a>
                    </div>
                </div>
                <div class="product__item">
                    <img src="resources\images\landingPage\products\product.jpg" alt="product">
                    <p class="product__item--name">Product name</p>
                    <p class="product__item--price">20000 vnđ</p>
                    <p class="product__item--vote">5<span style="vertical-align: text-bottom">&#11088;</span></p>
                    <div class="product__info">
                        <img src="resources\images\landingPage\products\add-to-cart-icon.svg" alt="add-to-cart">
                        <p>Thêm vào giỏ</p>
                        <a class="size">Size M</a>
                        <a class="size">Size L</a>
                        <a class="vote">Vote</a>
                        <a class="favorite">Thêm vào yêu thích</a>
                    </div>
                </div>
                <div class="product__item">
                    <img src="resources\images\landingPage\products\product.jpg" alt="product">
                    <p class="product__item--name">Product name</p>
                    <p class="product__item--price">20000 vnđ</p>
                    <p class="product__item--vote">5<span style="vertical-align: text-bottom">&#11088;</span></p>
                    <div class="product__info">
                        <img src="resources\images\landingPage\products\add-to-cart-icon.svg" alt="add-to-cart">
                        <p>Thêm vào giỏ</p>
                        <a class="size">Size M</a>
                        <a class="size">Size L</a>
                        <a class="vote">Vote</a>
                        <a class="favorite">Thêm vào yêu thích</a>
                    </div>
                </div>
                <div class="product__item">
                    <img src="resources\images\landingPage\products\product.jpg" alt="product">
                    <p class="product__item--name">Product name</p>
                    <p class="product__item--price">20000 vnđ</p>
                    <p class="product__item--vote">5<span style="vertical-align: text-bottom">&#11088;</span></p>
                    <div class="product__info">
                        <img src="resources\images\landingPage\products\add-to-cart-icon.svg" alt="add-to-cart">
                        <p>Thêm vào giỏ</p>
                        <a class="size">Size M</a>
                        <a class="size">Size L</a>
                        <a class="vote">Vote</a>
                        <a class="favorite">Thêm vào yêu thích</a>
                    </div>
                </div>
                <div class="product__item">
                    <img src="resources\images\landingPage\products\product.jpg" alt="product">
                    <p class="product__item--name">Product name</p>
                    <p class="product__item--price">20000 vnđ</p>
                    <p class="product__item--vote">5<span style="vertical-align: text-bottom">&#11088;</span></p>
                    <div class="product__info">
                        <img src="resources\images\landingPage\products\add-to-cart-icon.svg" alt="add-to-cart">
                        <p>Thêm vào giỏ</p>
                        <a class="size">Size M</a>
                        <a class="size">Size L</a>
                        <a class="vote">Vote</a>
                        <a class="favorite">Thêm vào yêu thích</a>
                    </div>
                </div>
                <div class="product__item">
                    <img src="resources\images\landingPage\products\product.jpg" alt="product">
                    <p class="product__item--name">Product name</p>
                    <p class="product__item--price">20000 vnđ</p>
                    <p class="product__item--vote">5<span style="vertical-align: text-bottom">&#11088;</span></p>
                    <div class="product__info">
                        <img src="resources\images\landingPage\products\add-to-cart-icon.svg" alt="add-to-cart">
                        <p>Thêm vào giỏ</p>
                        <a class="size">Size M</a>
                        <a class="size">Size L</a>
                        <a class="vote">Vote</a>
                        <a class="favorite">Thêm vào yêu thích</a>
                    </div>
                </div>
                <div class="product__item">
                    <img src="resources\images\landingPage\products\product.jpg" alt="product">
                    <p class="product__item--name">Product name</p>
                    <p class="product__item--price">20000 vnđ</p>
                    <p class="product__item--vote">5<span style="vertical-align: text-bottom">&#11088;</span></p>
                    <div class="product__info">
                        <img src="resources\images\landingPage\products\add-to-cart-icon.svg" alt="add-to-cart">
                        <p>Thêm vào giỏ</p>
                        <a class="size">Size M</a>
                        <a class="size">Size L</a>
                        <a class="vote">Vote</a>
                        <a class="favorite">Thêm vào yêu thích</a>
                    </div>
                </div>
                <div class="product__item">
                    <img src="resources\images\landingPage\products\product.jpg" alt="product">
                    <p class="product__item--name">Product name</p>
                    <p class="product__item--price">20000 vnđ</p>
                    <p class="product__item--vote">5<span style="vertical-align: text-bottom">&#11088;</span></p>
                    <div class="product__info">
                        <img src="resources\images\landingPage\products\add-to-cart-icon.svg" alt="add-to-cart">
                        <p>Thêm vào giỏ</p>
                        <a class="size">Size M</a>
                        <a class="size">Size L</a>
                        <a class="vote">Vote</a>
                        <a class="favorite">Thêm vào yêu thích</a>
                    </div>
                </div>
        </main>
        <div id="container-vote">
            <div id="vote">
                <div class="star"></div>
                <div class="star"></div>
                <div class="star"></div>
                <div class="star"></div>
                <div class="star"></div>
            </div>
        </div>
        <jsp:include page="include/footer.jsp"/>

        <script src="resources/js/landingPage.js"></script>
        <script src="resources/js/standard.js"></script>
    </body>
</html>
