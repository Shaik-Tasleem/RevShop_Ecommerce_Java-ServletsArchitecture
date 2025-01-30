<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Seller Profile</title>
    <!-- Bootstrap CSS and Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet"> <!-- FontAwesome for icons -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

    <style>
        body {
            background-color: #f4f6f9;
            font-family: 'Arial', sans-serif;
        }
        .profile-container {
            max-width: 600px;
            margin: 50px auto;
            padding: 30px;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1); /* Box shadow */
        }
        h1 {
            text-align: center;
            color: #343a40;
            font-size: 24px;
            margin-bottom: 20px;
        }
        .form-group {
            position: relative;
        }
        .form-control {
            padding-left: 40px; /* Extra padding for icons */
        }
        .form-icon {
            position: absolute;
            left: 10px;
            top: 50%;
            transform: translateY(-50%);
            font-size: 18px;
            color: #6c757d;
        }
        .btn {
            margin-top: 20px;
            width: 100%;
            background-color: #007bff;
            color: white;
        }
        .btn:hover {
            background-color: #0056b3;
        }
        .logout-btn {
            position: absolute;
            right: 20px;
            top: 20px;
            background-color: transparent;
            border: none;
        }
        .logout-btn i {
            color: #dc3545;
            font-size: 24px;
        }
        .logout-btn:hover i {
            color: #a71b2a;
        }
        
    /* Style for the "Home" form and button */
    .logout-form input[type="submit"] {
        background-color: #007bff; /* Blue background */
        color: white; /* White text */
        border: none; /* Remove border */
        padding: 10px 20px; /* Padding for the button */
        font-size: 16px; /* Font size */
        border-radius: 5px; /* Rounded corners */
        cursor: pointer; /* Pointer on hover */
        transition: background-color 0.3s ease; /* Smooth transition for hover */
    }

    /* Change background on hover */
    .logout-form input[type="submit"]:hover {
        background-color: #0056b3; /* Darker blue on hover */
    }

        
    </style>
</head>
<body>

<!-- Logout Button (Right aligned) -->
<form action="login.jsp" method="post" class="logout-form">
    <button type="submit" class="logout-btn" title="Logout">
        <i class="fas fa-sign-out-alt"></i>
    </button>
</form>
<form action="sellerhome" method="post" class="logout-form">
    <input type="submit" value="Home"/>
</form>

<div class="profile-container">
    <h1>Seller Profile</h1>
    
    <!-- Display success or failure message -->
    <c:if test="${not empty message}">
        <div class="alert alert-info" role="alert">
            ${message}
        </div>
    </c:if>

    <form action="UpdateSellerProfile" method="post">
        <!-- Name Field -->
        <div class="form-group mb-3">
            <label for="s_name" class="form-label">Name</label>
            <i class="fas fa-user form-icon"></i>
            <input type="text" class="form-control" id="s_name" name="s_name" value="${SellerDetails.s_name}" required>
        </div>

        <!-- Email Field (Read-Only) -->
        <div class="form-group mb-3">
            <label for="s_email" class="form-label">Email</label>
            <i class="fas fa-envelope form-icon"></i>
            <input type="email" class="form-control" id="s_email" name="s_email" value="${SellerDetails.s_email}" readonly>
        </div>

        <!-- Phone Number Field -->
        <div class="form-group mb-3">
            <label for="s_number" class="form-label">Phone Number</label>
            <i class="fas fa-phone form-icon"></i>
            <input type="text" class="form-control" id="s_number" name="s_number" value="${SellerDetails.s_number}" required>
        </div>

        <!-- Address Field -->
        <div class="form-group mb-3">
            <label for="s_address" class="form-label">Business Name</label>
            <i class="fas fa-home form-icon"></i>
            <input type="text" class="form-control" id="s_address" name="s_address" value="${SellerDetails.s_address}" required>
        </div>

        <!-- Password Field -->
        <div class="form-group mb-3">
            <label for="s_password" class="form-label">Password</label>
            <i class="fas fa-lock form-icon"></i>
            <input type="password" class="form-control" id="s_password" name="s_password" placeholder="Enter your password" required>
        </div>

        <!-- Submit Button -->
        <button type="submit" class="btn btn-primary">Update Profile</button>
    </form>
</div>

</body>
</html>
