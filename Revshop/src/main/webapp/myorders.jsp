<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Orders</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }
        .header {
            background-color: pink;
            color: #fff;
            padding: 10px;
            text-align: center;
        }
        .header a {
            color: #fff;
            text-decoration: none;
            padding: 10px;
            font-size: 16px;
        }
        .header a:hover {
            background-color: #555;
        }
        .container {
            max-width: 900px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #333;
        }
        .order-card {
            border: 1px solid #ddd;
            border-radius: 8px;
            margin-bottom: 20px;
            padding: 15px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .order-card img {
            max-width: 100px;
            height: auto;
            display: block;
            margin-bottom: 10px;
        }
        .order-details {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .order-details div {
            margin-right: 10px;
        }
        .order-total {
            font-weight: bold;
            color: #28a745;
        }
        .review-form {
            margin-top: 20px;
        }
        .review-form textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 10px;
        }
        .review-form select, .review-form input[type="submit"] {
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
            margin-right: 10px;
        }
        .review-form input[type="submit"] {
            background-color: yellow;
            color: #fff;
            border: none;
            cursor: pointer;
        }
        .review-form input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

    <!-- Header with navigation buttons -->
    <div class="header">
        <a href="continueShopping">Continue Shopping</a>
        <a href="login.jsp">Logout</a>
    </div>

    <!-- Main content -->
    <div class="container">
        <h1>My Orders</h1>

        <c:forEach var="order" items="${orderDetails}">
            <div class="order-card">
                <div class="order-details">
                    <div>
                        <strong>Product Name:</strong> ${order.product_name}
                    </div>
                    <div>
                        <strong>Price:</strong> $${order.product_price}
                    </div>
                    <div>
                        <strong>Quantity:</strong> ${order.quantity}
                    </div>
                </div>
                <div class="order-details">
                    <div>
                        <img src="${order.product_image}" alt="${order.product_name}">
                    </div>
                    <div>
                        <strong>Description:</strong> ${order.product_description}
                    </div>
                </div>
                <div class="order-details">
                    <div>
                        <strong>Order Date:</strong> ${order.orderdate}
                    </div>
                    <div class="order-total">
                        Total Amount: $${order.totalamount}
                    </div>
                </div>
                <div class="order-details">
                    <div>
                        <strong>Shipping Address:</strong> ${order.address}
                    </div>
                </div>

                <!-- Review Form for each product -->
                <div class="review-form">
                    <h3>Leave a Review</h3>
                    <form action="review" method="post">
                       
                        <textarea name="review" rows="4" placeholder="Write your review here..." required></textarea><br>
                        <label for="rating">Rating: </label>
                        <select name="rating" required>
                            <option value="5">5 - Excellent</option>
                            <option value="4">4 - Good</option>
                            <option value="3">3 - Average</option>
                            <option value="2">2 - Below Average</option>
                            <option value="1">1 - Poor</option>
                        </select>
                        <input type="submit" value="Submit Review">
                    </form>
                </div>

            </div>
        </c:forEach>

    </div>
</body>
</html>
