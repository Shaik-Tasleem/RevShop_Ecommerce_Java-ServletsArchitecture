<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>My Profile</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome for Icons -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    
    <style>
        /* Full Height for HTML and Body */
        html, body {
            height: 100%;
            margin: 0;
        }

        /* General Body Styling */
        body {
            background-color: #f4f4f4;
            font-family: 'Arial', sans-serif;
            display: flex;
            flex-direction: column;
        }

        /* Container Styling */
        .container {
            flex: 1;
            display: flex;
            flex-direction: column;
            max-width: 100%;
            padding: 20px;
        }

        /* Profile Header Styling */
        .profile-header {
            background-color: #2874f0;
            color: white;
            padding: 15px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            border-radius: 8px;
            margin-bottom: 20px;
        }

        .profile-header h1 {
            font-size: 1.8rem;
            margin: 0;
        }

        .profile-header i {
            margin-right: 10px;
            font-size: 1.8rem;
        }

        .profile-header .btn {
            color: white;
            background-color: transparent;
            border: none;
            font-size: 1rem;
        }

        /* Profile Card Styling */
        .profile-card {
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
            flex: 1;
        }

        .profile-info {
            margin-bottom: 20px;
        }

        .profile-info p {
            font-size: 1rem;
            margin: 10px 0;
        }

        /* Form Styling */
        .form-control {
            border: none;
            border-bottom: 2px solid #ccc;
            border-radius: 0;
            height: 40px;
            padding: 10px;
            margin-bottom: 20px;
            font-size: 0.95rem;
            transition: border-color 0.3s;
        }

        .form-control:focus {
            border-bottom: 2px solid #2874f0;
            box-shadow: none;
        }

        /* Button Styling */
        .btn-primary {
            background-color: #2874f0;
            border: none;
            border-radius: 30px;
            padding: 10px 20px;
        }

        .btn-primary:hover {
            background-color: #0056b3;
        }

        /* Responsive Media Queries */
        @media (max-width: 768px) {
            .profile-header {
                flex-direction: column;
                align-items: flex-start;
            }

            .profile-header h1 {
                font-size: 1.5rem;
            }
        }
    </style>
</head>
<body>
    <!-- Header Section -->
    <div class="container">
        <div class="profile-header">
            <div>
                <i class="fas fa-user-circle"></i>
                <h1>My Profile</h1>
            </div>
            <div>
            <a href="continueShopping" class="btn">
                <i class="fas fa-shopping-cart"></i> Continue Shopping
            </a>
                <a href="myOrders.jsp" class="btn">
                    <i class="fas fa-box"></i> My Orders
                </a>
                <a href="login.jsp" class="btn">
                    <i class="fas fa-sign-out-alt"></i> Logout
                </a>
            </div>
        </div>

        <!-- Profile Card Section -->
        <div class="profile-card">
            <h3 class="mb-4">Profile Information</h3>
            <jsp:useBean id="buyerDetails" type="dto.BuyerDto" scope="request" />

            <!-- Display Profile Information -->
            <div class="profile-info">
                <p><strong>Email:</strong> ${buyerDetails.b_email}</p>
                <p><strong>Name:</strong> ${buyerDetails.b_name}</p>
                <p><strong>Phone:</strong> ${buyerDetails.b_number}</p>
                <p><strong>Address:</strong> ${buyerDetails.b_address}</p>
            </div>

            <!-- Form to Update Profile Details -->
            <form action="updateProfile" method="post">
                <input type="hidden" name="email" value="${buyerDetails.b_email}" />

                <div class="form-group">
                    <input type="text" class="form-control" id="name" name="name" value="${buyerDetails.b_name}" placeholder="Update Name" required />
                </div>

                <div class="form-group">
                    <input type="text" class="form-control" id="number" name="number" value="${buyerDetails.b_number}" placeholder="Update Phone" required />
                </div>

                <div class="form-group">
                    <input type="email" class="form-control" id="email" name="new_email" value="${buyerDetails.b_email}" placeholder="Update Email" required />
                </div>

                <div class="form-group">
                    <input type="password" class="form-control" id="password" name="password" placeholder="Change Password" required />
                </div> 
                <div class="form-group">
                    <input type="password" class="form-control" id="password" name="password" placeholder="Change Password" required />
                </div> 

                <div class="form-group">
                    <input type="text" class="form-control" id="address" name="address" value="${buyerDetails.b_address}" placeholder="Update Address" required />
                </div>

                <button type="submit" class="btn btn-primary btn-block">Update Profile</button>
            </form>
        </div>
    </div>

    <!-- Bootstrap JS, Popper.js, and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
