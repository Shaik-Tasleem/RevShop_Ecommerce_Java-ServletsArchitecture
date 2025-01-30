<%@ page import="service.CartService" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>My Wish List</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            color: #333;
            margin: 20px 0;
            font-size: 2em;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
        }

        .cart-container {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border: 1px solid #ddd;
            padding: 20px;
        }

        .cart-item {
            display: flex;
            align-items: center;
            border-bottom: 1px solid #eee;
            padding: 15px 0;
            transition: background-color 0.3s;
        }

        .cart-item:hover {
            background-color: #f9f9f9;
        }

        .cart-item img {
            max-width: 120px;
            height: auto;
            margin-right: 20px;
            border-radius: 8px;
        }

        .cart-item-info {
            flex: 1;
        }

        .cart-item-info h3 {
            margin: 0;
            color: #333;
            font-size: 1.2em;
        }

        .cart-item-info p {
            margin: 5px 0;
            color: #666;
        }

        .remove-btn {
            padding: 8px 12px;
            background-color: #dc3545;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
        }

        .remove-btn:hover {
            background-color: #c82333;
        }

        .cart-summary {
            text-align: right;
            padding: 20px 0;
            border-top: 1px solid #ddd;
            display: flex;
            justify-content: flex-end;
            align-items: center;
        }

        .btn {
            padding: 12px 20px;
            background-color: #28a745;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            font-size: 16px;
            transition: background-color 0.3s;
        }

        .btn:hover {
            background-color: #218838;
        }

        .continue-shopping {
            margin-left: auto;
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>My Wish List</h1>

        <div class="cart-container">
            <!-- Loop through wish list items -->
            <c:forEach var="cart" items="${wishitems}">
                <div class="cart-item">
                    <!-- Product Image -->
                    <img src="${cart.productImage}" alt="${cart.productName}">
                    <div class="cart-item-info">
                        <!-- Product Name and Details -->
                        <h3>${cart.productName}</h3>
                        <p>Price: $${cart.productPrice}</p>
                        <p>Discount Price: ${cart.discountPrice}</p>
                    </div>
                    
                    <!-- Remove Item Button -->
                    <form action="removewish" method="post" style="margin-left: auto;">
                        <input type="hidden" name="productId" value="${cart.product_id}" />
                        <input type="submit" value="Remove" class="remove-btn" />
                    </form>
                </div>
            </c:forEach>
        </div>

        <!-- Navigation Button -->
        <div class="cart-summary">
            <form action="continueShopping" method="post" class="continue-shopping">
                <button type="submit" class="btn">Continue Shopping</button>
            </form>
        </div>
    </div>

</body>
</html>
