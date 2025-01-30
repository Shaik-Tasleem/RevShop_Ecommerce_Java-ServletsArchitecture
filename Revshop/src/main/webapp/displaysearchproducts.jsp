<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>RevShop - Product List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 95%;
            margin: 20px auto;
            position: relative;
        }

        h2 {
            text-align: center;
            font-weight: normal;
            color: #333;
            margin-bottom: 30px;
        }

        /* Continue Shopping Button at Top Right */
        .continue-shopping {
            position: absolute;
            top: 10px;
            right: 10px; /* Change to "left: 10px" if you want it on the left */
            background-color: #28a745;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            font-size: 14px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .continue-shopping:hover {
            background-color: #218838;
        }

        .filter-section {
            width: 25%;
            float: left;
            padding: 10px;
            background-color: #fff;
            border-right: 1px solid #ddd;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.05);
        }

        .filter-section h3 {
            font-size: 18px;
            color: #333;
            margin-bottom: 15px;
        }

        .filter-section label {
            font-size: 14px;
            color: #555;
        }

        .filter-section input {
            margin-right: 10px;
        }

        .filter-section button {
            padding: 10px 20px;
            border: none;
            background-color: #007bff;
            color: white;
            cursor: pointer;
            border-radius: 3px;
            margin-top: 10px;
        }

        .filter-section button:hover {
            background-color: #0056b3;
        }

        .product-list {
            width: 70%;
            float: right;
        }

        .row {
            display: flex;
            flex-wrap: wrap;
            justify-content: flex-start;
        }

        .product-card {
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 5px;
            padding: 15px;
            margin: 10px;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
            text-align: left;
            width: 30%;
            transition: transform 0.3s;
        }

        .product-card:hover {
            transform: scale(1.02);
        }

        .product-card img {
            max-width: 100%;
            height: auto;
            margin-bottom: 15px;
            border-radius: 5px;
        }

        .product-card h3 {
            color: #333;
            font-size: 18px;
            margin-bottom: 10px;
        }

        .product-card p {
            font-size: 14px;
            color: #555;
            margin-bottom: 10px;
        }

        .price {
            font-size: 16px;
            color: #007bff;
            font-weight: bold;
        }

        .discount-price {
            font-size: 14px;
            color: #555;
            text-decoration: line-through;
            margin-bottom: 10px;
        }

        .btn-group {
            display: flex;
            justify-content: flex-start;
            gap: 20px; /* Add space between the buttons */
            margin-bottom: 10px;
        }

        .btn {
            padding: 10px 15px;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 14px;
            transition: background-color 0.3s ease;
        }

        .btn-addtocart {
            background-color: #ffc107; /* Yellow */
        }

        .btn-addtocart:hover {
            background-color: #e0a800;
        }

        .btn-wishlist {
            background-color: #000; /* Black */
        }

        .btn-wishlist:hover {
            background-color: #333;
        }

        .clearfix::after {
            content: "";
            display: table;
            clear: both;
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            .product-card {
                width: 45%;
            }

            .filter-section {
                width: 100%;
                float: none;
                margin-bottom: 20px;
            }

            .product-list {
                width: 100%;
                float: none;
            }
        }

        @media (max-width: 576px) {
            .product-card {
                width: 100%;
            }

            .btn {
                width: 100%;
                margin-bottom: 5px;
            }

            .btn-group {
                flex-direction: column;
            }
        }
    </style>
</head>
<body>

    <div class="container clearfix">
        <!-- Continue Shopping Button -->
        <a href="continueShopping" class="continue-shopping">Continue Shopping</a>

        <!-- Filter Section -->
        <div class="filter-section">
            <h3>Filter By</h3>
            <form action="filterProducts" method="post">
                <label>
                    <input type="checkbox" name="category" value="electronics"> Electronics
                </label><br>
                <label>
                    <input type="checkbox" name="category" value="fashion"> Fashion
                </label><br>
                <label>
                    <input type="checkbox" name="category" value="home"> Home Appliances
                </label><br>

                <label for="priceRange">Price Range:</label><br>
                <input type="radio" name="priceRange" value="low"> Low to High<br>
                <input type="radio" name="priceRange" value="high"> High to Low<br>

                <button type="submit">Apply Filters</button>
            </form>
        </div>

        <!-- Product List Section -->
        <div class="product-list">
            <h2>Our Products</h2>
            <div class="row">
                <c:choose>
                    <c:when test="${not empty products}">
                        <c:forEach var="product" items="${products}">
                            <div class="product-card">
                                <img src="${product.productImage}" alt="${product.productName}">
                                <h3>${product.productName}</h3>
                                <p class="price">$${product.discountPrice}</p>
                                <p class="discount-price">$${product.productPrice}</p>
                                <p>${product.productDescription}</p>

                                <div class="btn-group">
                                    <form action="addcart" method="post">
                                        <input type="hidden" name="productid" value="${product.product_id}"/>
                                        <input type="submit" value="Add To Cart" class="btn btn-addtocart"/>
                                    </form>

                                    <form action="addtoWishlist" method="post">
                                        <input type="hidden" name="productid" value="${product.product_id}"/>
                                        <input type="submit" value="Wishlist" class="btn btn-wishlist"/>
                                    </form>
                                </div>
                            </div>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <h3>No products available</h3>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>

</body>
</html>
