<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>RevShop - Product List</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome for icons -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        /* Header Styling */
        header {
            background-color: #333;
            padding: 20px;
            text-align: center;
            color: white;
            position: relative;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
        }

        nav {
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .left-text {
            color: white;
            margin-left: 20px;
            font-size: 18px;
        }

        .search-bar {
            width: 300px;
            margin: 0 auto;
            display: flex;
        }

        .search-bar input {
            flex: 1;
            padding: 10px;
            border-radius: 5px 0 0 5px;
            border: none;
            outline: none;
        }

        .search-bar button {
            padding: 10px;
            border-radius: 0 5px 5px 0;
            border: none;
            background-color: #e67e22;
            color: white;
            cursor: pointer;
        }

        .search-bar button:hover {
            background-color: #d35400;
        }

        /* Button Styling */
        .btn-custom {
            background-color: #333;
            color: white;
            border: none;
        }

        .btn-custom:hover {
            background-color: #555;
        }

        .profile-icon {
            margin-left: 10px;
        }

        .profile-icon form {
            display: inline;
        }

        .profile-icon .btn {
            background-color: #e67e22;
            color: white;
            border: none;
            font-size: 24px;
        }

        .profile-icon .btn:hover {
            background-color: #d35400;
        }

        /* Main Content Styling */
        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        /* Product Card Styling */
        .product-card {
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 8px;
            padding: 20px;
            margin: 15px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
            transition: transform 0.3s ease;
        }

        .product-card:hover {
            transform: translateY(-5px);
        }

        .product-card img {
            max-width: 100%;
            height: auto;
            border-bottom: 1px solid #ddd;
            margin-bottom: 10px;
        }

        .product-card h3 {
            font-size: 18px;
            margin-bottom: 10px;
            color: #333;
        }

        .product-card p {
            margin: 5px 0;
            font-size: 14px;
            color: #777;
        }

        .product-card .price {
            font-size: 18px;
            font-weight: bold;
            color: #e67e22;
            margin-bottom: 5px;
        }

        .product-card .discount-price {
            font-size: 16px;
            text-decoration: line-through;
            color: #999;
            margin-bottom: 10px;
        }

        .product-card .btn-group {
            display: flex;
            justify-content: space-between;
            margin-top: 10px;
        }

        .product-card .btn {
            padding: 10px 15px;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            font-size: 14px;
        }

        .product-card .btn-info {
            background-color: #3498db;
            color: #fff;
        }

        .product-card .btn-info:hover {
            background-color: #2980b9;
        }

        .product-card .btn-secondary {
            background-color: #333;
            color: #fff;
        }

        .product-card .btn-secondary:hover {
            background-color: #555;
        }

        /* Footer Styling */
        footer {
            background-color: #333;
            color: white;
            padding: 10px 0;
            text-align: center;
            position: relative;
            bottom: 0;
            width: 100%;
        }

        footer p {
            margin: 0;
            padding: 10px;
        }

        /* Responsive Media Queries */
        @media (max-width: 768px) {
            .product-card {
                width: 45%;
            }

            .search-bar {
                width: 80%;
            }
        }

        @media (max-width: 480px) {
            .product-card {
                width: 100%;
            }

            nav a {
                font-size: 16px;
            }
        }
    </style>
</head>
<body>

    <!-- Header and Navigation Bar -->
    <header>
        <nav>
            <div class="left-text">
            
                <p>Welcome , to Revshop .we are glad that you are here</p>
            </div>
            <div class="search-bar">
                <form action="search" method="get">
                    <input type="text" name="pname" placeholder="Search for products...">
                    <button type="submit"><i class="fas fa-search"></i></button>
                </form>
            </div>
            <div>
                <form action="myitems" method="post" class="d-inline">
                    <input type="submit" value="Cart" class="btn btn-custom">
                </form>
                <form action="mywishlist" method="post" class="d-inline ml-2">
                    <input type="submit" value="Favorites" class="btn btn-custom">
                </form>
                <form action="myorders" method="post" class="d-inline ml-2">
                    <input type="submit" value="My Orders" class="btn btn-custom">
                </form>
                <form action="profile" method="post" class="d-inline ml-2">
                    <input type="submit" value="Profile" class="btn btn-custom">
                </form>
                <form action="login.jsp" method="post" class="d-inline ml-2">
                    <input type="submit" value="Logout" class="btn btn-custom">
                </form>
            </div>
        </nav>
    </header>

    <!-- Main Product Section -->
    <div class="container">
        <h2> Products available</h2>
        <div class="row">
            <c:forEach var="product" items="${products}">
                <div class="col-md-4">
                    <div class="product-card">
                        <img src="${product.productImage}" alt="${product.productName}">
                        <h3>${product.productName}</h3>
                        <p class="price">Rs${product.discountPrice}</p>
                        <p class="discount-price">Rs${product.productPrice}</p>
                        <p>${product.productDescription}</p>
                        
                        <div class="btn-group">
                            <form action="addcart" method="post" class="d-inline">
                                <input type="hidden" name="productid" value="${product.product_id}"/>
                                <input type="submit" value="Add To Cart" class="btn btn-info"/>
                            </form>
                            <form action="addtoWishlist" method="post" class="d-inline ml-2">
                                <input type="hidden" name="productid" value="${product.product_id}"/>
                                <input type="submit" value="Add to Wishlist" class="btn btn-secondary"/>
                            </form>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <!-- Footer Section -->
    <footer>
        <p>&copy; 2024 RevShop. All rights reserved.</p>
    </footer>


    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
