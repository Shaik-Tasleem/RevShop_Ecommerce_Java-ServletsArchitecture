<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Place Order</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 800px;
            margin: 30px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            display: block;
            font-weight: bold;
            margin-bottom: 10px;
            color: #333;
        }

        .form-group input,
        .form-group textarea,
        .form-group select {
            width: 100%;
            padding: 12px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }

        .form-group input[readonly] {
            background-color: #f5f5f5;
            color: #333;
        }

        .status {
            color: #dc3545;
            font-weight: bold;
        }

        .btn {
            display: block;
            width: 100%;
            padding: 15px;
            background-color: #28a745;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            text-align: center;
            text-decoration: none;
            transition: background-color 0.3s;
            margin-top: 10px;
        }

        .btn:hover {
            background-color: #218838;
        }

        .btn-secondary {
            background-color: #dc3545;
        }

        .btn-secondary:hover {
            background-color: #c82333;
        }

        .summary {
            margin-top: 20px;
            font-size: 1.2em;
            font-weight: bold;
            text-align: right;
        }

        .actions {
            margin-top: 20px;
            display: flex;
            justify-content: space-between;
        }

        .actions a {
            width: 32%;
            text-align: center;
        }

        .message {
            color: #28a745;
            font-weight: bold;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>Place Your Order</h1>

        <!-- Display Message -->
        <c:if test="${not empty message}">
            <div class="message">${message}</div>
        </c:if>

        <form action="orderConfirmation" method="post">
            <!-- Delivery Address -->
            <div class="form-group">
                <label for="deliveryAddress">Delivery Address:</label>
                <textarea id="deliveryAddress" name="deliveryAddress" rows="4" >123 Main St, City, Country</textarea>
            </div>

            <!-- Order Status -->
            <div class="form-group">
                <label>Status:</label>
                <p class="status">Pending</p>
            </div>

            <!-- Total Price -->
            <div class="form-group">
                <label for="totalPrice">Total Price:</label>
                <input type="text" id="totalPrice" name="totalPrice" value="${totalprice}" readonly />
            </div>

            <!-- Payment Options -->
            <div class="form-group payment-options">
                <label for="paymentMethod">Payment Method:</label>
                <select id="paymentMethod" name="paymentMethod" required>
                    <option value="credit_card">Credit Card</option>
                    <option value="paypal">PayPal</option>
                    <option value="bank_transfer">Bank Transfer</option>
                    <option value="cash_on_delivery">Cash on Delivery</option>
                </select>
            </div>

            <!-- Buyer ID (Hidden) -->
            <input type="hidden" name="buyerId" value="${buyerId}" />

            <!-- Buttons -->
            <div class="actions">
                <button type="submit" class="btn">Place Order</button>
                
                <a href="cancelOrder" class="btn btn-secondary">Cancel Order</a>
                <a href="continueShopping" class="btn">Continue Shopping</a>
            </div>
        </form>
    </div>

</body>
</html>
