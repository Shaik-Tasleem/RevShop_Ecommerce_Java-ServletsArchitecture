<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Update Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f4f6f9;
            font-family: 'Arial', sans-serif;
        }
        .form-container {
            max-width: 600px;
            margin: 50px auto;
            padding: 30px;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #343a40;
            font-size: 2rem;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h1>Update Product</h1>

    <!-- Form to update product details -->
    <form action="UpdateProductServlet" method="post">
        <input type="hidden" name="product_id" value="${product.product_id}">

        <div class="mb-3">
            <label for="productName" class="form-label">Product Name</label>
            <input type="text" class="form-control" id="productName" name="product_name" value="${product.product_name}" required>
        </div>

        <div class="mb-3">
            <label for="productPrice" class="form-label">Price</label>
            <input type="number" class="form-control" id="productPrice" name="product_price" value="${product.product_price}" required>
        </div>

        <div class="mb-3">
            <label for="quantity" class="form-label">Quantity</label>
            <input type="number" class="form-control" id="quantity" name="quantity" value="${product.quantity}" required>
        </div>

        <div class="mb-3">
            <label for="productDescription" class="form-label">Description</label>
            <textarea class="form-control" id="productDescription" name="product_description" rows="3">${product.product_description}</textarea>
        </div>

        <div class="mb-3">
            <label for="discountPrice" class="form-label">Discount Price</label>
            <input type="number" class="form-control" id="discountPrice" name="discount_price" value="${product.discount_price}" required>
        </div>

        <div class="mb-3">
            <label for="threshold" class="form-label">Threshold</label>
            <input type="number" class="form-control" id="threshold" name="threshold" value="${product.threshold}" required>
        </div>
  
        <div class="mb-3">
            <label for="categoryId" class="form-label">Category ID</label>
            <input type="number" class="form-control" id="categoryId" name="category_id" value="${product.category_id}" required>
        </div>
        <div class="mb-3">
            <label for="Image" class="form-label">Image</label>
            <input type="text" class="form-control" id="Image" name="product_image" value="${product.product_image}" required>
        </div>

        <button type="submit" class="btn btn-primary">Update Product</button>
    </form>
</div>
</body>
</html>
