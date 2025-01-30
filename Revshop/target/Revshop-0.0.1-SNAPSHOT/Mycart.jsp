<%@ page import="service.CartService" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>My Cart</title>
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

        .cart-container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border: 1px solid #ddd;
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

        .quantity-control {
            display: flex;
            align-items: center;
        }

        .quantity-control button {
            padding: 8px 12px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
        }

        .quantity-control button:hover {
            background-color: #0056b3;
        }

        .quantity-control input {
            width: 60px;
            text-align: center;
            margin: 0 10px;
            font-size: 16px;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
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
            font-size: 1.2em;
            font-weight: bold;
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

        .continue-shopping-btn {
            display: block;
            text-align: center;
            padding: 12px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            text-decoration: none;
            transition: background-color 0.3s;
            margin: 20px auto;
            max-width: 200px;
        }

        .continue-shopping-btn:hover {
            background-color: #0056b3;
        }

        .order-now-btn {
            display: inline-block;
            padding: 12px 20px;
            background-color: #28a745;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
            text-decoration: none;
            margin-left: 20px;
        }

        .order-now-btn:hover {
            background-color: #218838;
        }
    </style>
    <script>
        function updateQuantity(action, productId) {
            var quantityInput = document.getElementById('quantity-' + productId);
            var currentQuantity = parseInt(quantityInput.value, 10);
            var pricePerUnit = parseFloat(document.getElementById('price-' + productId).textContent.trim().replace('$', ''));

            if (isNaN(currentQuantity) || isNaN(pricePerUnit)) {
                console.error('Invalid quantity or price');
                return;
            }

            if (action === 'increment') {
                currentQuantity++;
            } else if (action === 'decrement' && currentQuantity > 1) {
                currentQuantity--;
            }

            quantityInput.value = currentQuantity;
            updateTotalPrice(productId, currentQuantity, pricePerUnit);

            // Send AJAX request to update the quantity
            var xhr = new XMLHttpRequest();
            xhr.open('POST', 'updateCart', true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            xhr.onreadystatechange = function() {
                if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
                    // Update the cart total on successful response
                    updateCartTotal();
                }
            };
            var params = 'productId=' + productId + '&quantity=' + currentQuantity + '&buyerId=' + document.getElementById('buyerId').value;
            xhr.send(params);
        }

        function updateTotalPrice(productId, quantity, pricePerUnit) {
            var totalPrice = quantity * pricePerUnit;
            document.getElementById('total-price-' + productId).textContent = '$' + totalPrice.toFixed(2);
        }

        function updateCartTotal() {
            var total = 0;
            var elements = document.getElementsByClassName('item-total');
            for (var i = 0; i < elements.length; i++) {
                var itemTotal = parseFloat(elements[i].textContent.trim().replace('$', ''));
                if (!isNaN(itemTotal)) {
                    total += itemTotal;
                }
            }
            document.getElementById('cart-total').textContent = 'Total: $' + total.toFixed(2);
        }

        window.onload = function() {
            updateCartTotal();
        }
    </script>
</head>
<body>

    <h1>My Cart</h1>
     
    <div class="cart-container">
        <!-- Continue Shopping Button -->
        <a href="continueShopping" class="continue-shopping-btn">Continue Shopping</a>

        <!-- Loop through cart items -->
        <c:forEach var="cart" items="${cartitems}">
            <div class="cart-item">
                <!-- Product Image -->
                <img src="${cart.productImage}" alt="${cart.productName}">
                <div class="cart-item-info">
                    <!-- Product Name and Details -->
                    <h3>${cart.productName}</h3>
                    <p>Price: $<span id="price-${cart.product_id}">${cart.productPrice}</span></p>
                    <p>Discount Price: ${cart.discountPrice}</p>

                    <!-- Update Quantity Form -->
                    <div class="quantity-control">
                        <button type="button" onclick="updateQuantity('decrement', ${cart.product_id})">-</button>
                        <input type="number" id="quantity-${cart.product_id}" name="quantity" value="${1*quantity}" min="1" />
                        <button type="button" onclick="updateQuantity('increment', ${cart.product_id})">+</button>
                    </div>
                    
                    <!-- Total Price for this Item -->
                    <p>Total: <span id="total-price-${cart.product_id}" class="item-total">${cart.productPrice * quantity}</span></p>
                </div>
                
                <!-- Remove Item Button -->
                <form action="removecart" method="post">
                    <input type="hidden" name="productId" value="${cart.product_id}" />
                    <input type="submit" value="Remove" class="remove-btn" />
                </form>
            </div>
        </c:forEach>
    </div>

    <!-- Cart Summary -->
    <div class="cart-summary">
        <div id="cart-total">
            Total: $${totalPrice}
        </div>
        <!-- Order Now Button -->
        <form action="CheckoutController" method="post" style="display: inline;">
            <input type="hidden" id="buyerId" name="buyerId" value="${buyerid}" />
            <input type="submit" value="Order Now" class="order-now-btn" />
        </form>
    </div>

    <!-- Hidden input to store buyer ID for AJAX requests -->
    <input type="hidden" id="buyerId" value="${buyerid}" />

</body>
</html>
