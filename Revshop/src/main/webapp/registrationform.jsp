<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
<script src="registration.js" defer></script>

<style>
    body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        background-color:white;
        font-family: 'Arial', sans-serif;
        margin: 0;
        background-repeat: no-repeat;
        background-size: cover;
    }

    .header {
        position: fixed;
        top: 0;
        left: 0;
        right: 0;
        background-color: pink;
        color: white;
        padding: 10px 20px;
        display: flex;
        justify-content: space-between;
        align-items: center;
        z-index: 1000;
    }

    .header h1 {
        margin: 0;
        font-size: 1.5rem;
    }

    .header a.home-btn {
        background-color: #007bff;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        text-decoration: none;
        font-size: 1rem;
        transition: background-color 0.3s ease;
    }

    .header a.home-btn:hover {
        background-color: #0056b3;
    }

    form {
        background-color: #fff;
        padding: 40px;
        border-radius: 10px;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        max-width: 500px;
        width: 100%;
        margin-top: 60px; /* Add margin to prevent overlap with the fixed header */
    }

    h1 {
        color: #333;
        margin-bottom: 30px;
        text-align: center;
        font-size: 2.5rem;
    }

    label {
        font-weight: bold;
        margin-bottom: 8px;
        color: #555;
        display: block;
        font-size: 1.1rem;
    }

    input[type="text"],
    input[type="email"],
    input[type="password"],
    input[type="number"] {
        width: 100%;
        padding: 12px;
        border: 1px solid #ccc;
        border-radius: 5px;
        margin-bottom: 20px;
        font-size: 1rem;
        transition: border-color 0.3s ease;
    }

    input[type="text"]:focus,
    input[type="email"]:focus,
    input[type="password"]:focus,
    input[type="number"]:focus {
        border-color: #007bff;
        outline: none;
    }

    input[type="radio"] {
        margin-right: 8px;
    }

    div {
        display: flex;
        justify-content: space-between;
        margin-bottom: 20px;
    }

    input[type="submit"] {
        background-color: violet;
        color: #fff;
        padding: 12px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        width: 100%;
        font-size: 1.2rem;
        transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }

    a {
        display: inline-block;
        margin-top: 15px;
        text-align: center;
        color: #007bff;
        font-size: 1rem;
        text-decoration: none;
        transition: color 0.3s ease;
    }

    a:hover {
        color: #0056b3;
    }
</style>



</head>
<body>
    <!-- Header -->
    <div class="header">
        <!-- Page Title -->
        <h1>Registration</h1>
        
        <!-- Home Button -->
        <a href="index2.jsp" class="home-btn">Home</a>
    </div>

    <!-- Registration Form -->
    <form method="post" action="RegistrationController"> 
        <label>Enter Your Name</label>
        <input type="text" name="username" placeholder="Enter your name" required>
        
        <label>Enter Your Email</label>
        <input type="email" name="email" placeholder="Enter your email" required>
        
        <label>Enter Your Password</label>
        <input type="password" name="password" placeholder="Enter your password" required>
        
        <label>Enter Your Mobile Number</label>
        <input type="number" name="mobilenumber" placeholder="Enter your mobile number" required>
        
        <label>Choose Your Role</label>
        <div>
            <label><input type="radio" value="seller" name="role" onclick="fun2()"> Seller</label>
            <label><input type="radio" value="buyer" name="role" onclick="fun1()"> Buyer</label>
        </div>

        <input type="submit" value="Register" onclick="fun3()"/>
    </form>
</body>
</html>
