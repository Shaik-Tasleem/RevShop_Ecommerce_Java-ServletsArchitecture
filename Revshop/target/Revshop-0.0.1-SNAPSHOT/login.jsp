<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<style>
body {
    display: flex;
    justify-content: flex-start;
    align-items: center;
    height: 100vh;
    background-color: #f7f7f7;
    font-family: Arial, sans-serif;
background-size: cover;
    padding-left: 100px; 
}

h1 {
    text-align: center;
    color: #333;
    margin-bottom: 20px;
}

form {
    background-color: white;
    padding: 40px;
    border-radius: 10px;
    box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
    width: 100%;
    max-width: 400px;
    margin-left: 150px;
}

input[type="email"],
input[type="password"] {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    margin-bottom: 15px;
    font-size: 16px;
}

label {
    font-weight: bold;
    margin-bottom: 5px;
}

input[type="radio"] {
    margin-right: 5px;
}

div {
    display: flex;
    justify-content: space-between;
    margin-bottom: 15px;
}

input[type="submit"] {
    background-color: #6a0dad; /* Purple color for button */
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    width: 100%;
    font-size: 16px;
}

input[type="submit"]:hover {
    background-color: #5a0cac;
}

a {
    display: block;
    text-align: center;
    margin-top: 10px;
    color: #6a0dad;
    text-decoration: none;
}

a:hover {
    text-decoration: underline;
}

.revshop-logo {
    position: absolute;
    top: 20px;
    left: 50px;
    color: #6a0dad;
    font-size: 32px;
    font-weight: bold;
    font-family: 'Arial', sans-serif;
    text-shadow: 1px 1px 2px #fff;
}

.error-message {
    color: red;
    text-align: center;
    font-weight: bold;
    margin-bottom: 10px;
}
</style>
</head>
<body>
     
    
     
    <form action="Login" method="post">
        <h1>Sign In</h1>
        <input type="email" name="email" placeholder="Enter Email" required />
        <input type="password" name="password" placeholder="Enter Password" required />
        <label>Role</label>
        <div>
            <label><input type="radio" value="seller" name="role" /> Seller</label>
            <label><input type="radio" value="buyer" name="role" /> Buyer</label>
        </div>
        <input type="submit" value="Sign In" />
        <a href="registrationform.jsp">Create Account</a>
        <a href="index2.jsp"> Home</a>

        <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
        <% if (errorMessage != null) { %>
            <div class="error-message"><%= errorMessage %></div>
        <% } %>
        
    </form>
</body>
</html>