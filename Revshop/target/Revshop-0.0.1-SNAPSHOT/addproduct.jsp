<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<style>
    <style>
    body {
        background-color: #f4f6f9;
        font-family: 'Arial', sans-serif;
        margin: 0;
        padding: 0;
    }

    /* Header styles */
    .header {
        background-color: yellow; /* Blue background */
        padding: 15px;
        color: #fff;
        display: flex;
        align-items: center;
        justify-content: space-between; /* Align items to the edges */
        position: sticky;
        top: 0;
        z-index: 1000;
    }

    .header h1 {
        margin: 0;
        font-size: 24px;
    }

    .header .home-btn {
        background-color: violet; /* Same as header background */
        color: white;
        border: none;
        padding: 10px 20px;
        font-size: 16px;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s ease;
        text-decoration: none;
    }

    .header .home-btn:hover {
        background-color: pink; /* Darker blue on hover */
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
        font-size: 24px;
        margin-bottom: 20px;
    }

    label {
        font-weight: 600;
        color: #495057;
    }

    .form-control {
        border-radius: 8px;
        padding: 10px;
        font-size: 16px;
        margin-bottom: 15px;
        border: 1px solid #ced4da;
        transition: all 0.3s ease;
    }

    .form-control:focus {
        border-color: #80bdff;
        box-shadow: 0 0 5px rgba(0, 123, 255, 0.25);
    }

    textarea.form-control {
        resize: none;
        height: 100px;
    }

    .form-group {
        margin-bottom: 15px;
    }

    .btn {
        background-color: #28a745;
        color: #fff;
        border: none;
        border-radius: 8px;
        padding: 10px 20px;
        width: 100%;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    .btn:hover {
        background-color: #218838;
    }

    .info-text p {
        font-size: 14px;
        color: #6c757d;
        margin: 5px 0;
    }

    .home-icon {
        font-size: 24px;
        color: #007bff;
        text-decoration: none;
        display: inline-block;
        margin-bottom: 20px;
    }

    .home-icon:hover {
        color: #0056b3;
    }
    #selhome{
    background-color:#007bff;
    outline:none;
    border:0px solid #007bff;
    }
</style>
    
</head>
<body>

<!-- Header -->
<div class="header">
    <!-- Home Button -->
   <form action="sellerhome" method="post">
   <input type="submit" value="Home" id="selhome"/>
   </form>
    
    <!-- Page Title -->
    <h1>Please ...........Add New Product</h1>
</div>

<div class="form-container">
    <!-- Display message -->
    <c:if test="${not empty message}">
        <div class="message">${message}</div>
    </c:if>

    <h1>Add your product</h1>
    <form action="ProductController" method="POST">
        <div class="form-group">
            <label>Product Name</label>
            <input type="text" class="form-control" name="productname" required/>
        </div>

        <div class="form-group">
            <label>Product Price</label>
            <input type="number" class="form-control" name="price" required/>
        </div>

        <div class="form-group">
            <label>Product Image (URL)</label>
            <input type="url" class="form-control" name="image" required/>
        </div>

        <div class="form-group">
            <label>Product Description</label>
            <textarea class="form-control" name="description" required></textarea>
        </div>

        <div class="form-group">
            <label>Threshold</label>
            <input type="number" class="form-control" name="threshold" required/>
        </div>

        <div class="form-group">
            <label>Quantity</label>
            <input type="number" class="form-control" name="quantity" required/>
        </div>

        <div class="form-group">
            <label>Discount Price</label>
            <input type="number" class="form-control" name="discount_price"/>
        </div>

        <div class="info-text">
        <h1>Below are our categories,Can u choose one from them to buy</h1>
            <p>1. Enter category id 1 for electronic gadgets</p>
            <p>2. Toys</p>
            <p>3. Home</p>
            <p>4. Cloths</p>
        </div>

        <div class="form-group">
            <label>Category ID</label>
            <input type="number" class="form-control" name="category_id" required/>
        </div>

        <button type="submit" class="btn">Add Product</button>
    </form>
</div>

</body>
</html>
