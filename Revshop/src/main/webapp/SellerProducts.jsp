<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>My Products</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container mt-5">
    <h1>My Products</h1>
    
    <table class="table table-bordered table-striped">
        <thead>
            <tr>
                <th>Product Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <!-- Loop through the list of products -->
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.product_name}</td>
                    <td>${product.description}</td>
                    <td>${product.price}</td>
                    <td>
                        <!-- Update button -->
                        <a href="updateProduct.jsp?product_id=${product.product_id}" class="btn btn-warning btn-sm">Update</a>

                        <!-- Delete button -->
                        <form action="DeleteProduct" method="post" style="display:inline;">
                            <input type="hidden" name="product_id" value="${product.product_id}">
                            <button type="submit" class="btn btn-danger btn-sm">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
