<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Update Product Details</title>
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
        .alert {
            text-align: center;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<div class="form-container">
    

    <!-- Check for success or failure message -->
    <c:if test="${not empty message}">
        <div class="alert alert-info">${message}</div>
    </c:if>
    <h1>Please edit your product details</h1>

    <!-- Loop through the list of products -->
    <c:forEach var="product" items="${product}">
        <form action="UpdateProductServlet" method="post">
            <!-- Hidden field for product ID -->
            <input type="hidden" name="productId" value="${product.product_id}">

            <!-- Field to edit product name -->
            <div class="mb-3">
                <label for="productName" class="form-label">Product Name</label>
                <input type="text" class="form-control" id="productName" name="productName" value="${product.productName}" required>
            </div>

            <!-- Field to edit product price -->
            <div class="mb-3">
                <label for="productPrice" class="form-label">Product Price</label>
                <input type="text" step="0.01" class="form-control" id="productPrice" name="productPrice" value="${product.productPrice}" required>
            </div>

            <!-- Field to edit product image -->
            <div class="mb-3">
                <label for="productImage" class="form-label">Product Image URL</label>
                <input type="text" class="form-control" id="productImage" name="productImage" value="${product.productImage}">
            </div>

            <!-- Field to edit product description -->
            <div class="mb-3">
                <label for="productDescription" class="form-label">Product Description</label>
                <textarea class="form-control" id="productDescription" name="productDescription">${product.productDescription}</textarea>
            </div>

            <!-- Field to edit threshold -->
            <div class="mb-3">
                <label for="threshold" class="form-label">Threshold</label>
                <input type="number" class="form-control" id="threshold" name="threshold" value="${product.threshold}" required>
            </div>

            <!-- Field to edit quantity -->
            <div class="mb-3">
                <label for="quantity" class="form-label">Quantity</label>
                <input type="number" class="form-control" id="quantity" name="quantity" value="${product.quantity}" required>
            </div>

            <!-- Field to edit discount price -->
            <div class="mb-3">
                <label for="discountPrice" class="form-label">Discount Price</label>
                <input type="text" step="0.01" class="form-control" id="discountPrice" name="discountPrice" value="${product.discountPrice}">
            </div>

            <!-- Field to edit category ID -->
            <div class="mb-3">
                <label for="categoryId" class="form-label">Category ID</label>
                <input type="number" class="form-control" id="categoryId" name="categoryId" value="${product.categoryId}" required>
            </div>

            <button type="submit" class="btn btn-primary">Update Product</button>
        </form>
    </c:forEach>

</div>
</body>
</html>
