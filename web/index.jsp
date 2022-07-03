<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 10/30/2017
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="css/style.css">

</head>
<body>
<div class="login-page">
    <div class="form">
        <form class="register-form" method="post" action="/user">
            <input type="hidden" name="page" value="register">
            <input type="text" name="name"placeholder="Name">
            <input type="password" name="password"placeholder="Password">
            <input type="text" name="email" placeholder="Email Address">
            <input type="submit" value="Register">
            <p class="message">Already registered? <a href="#">Sign In</a></p>
        </form>
        <form class="login-form" method="post" action="/user">
            <input type="hidden" name="page" value="Login">
            <input type="text" name="email" placeholder="Name">
            <input type="password" name="password" placeholder="Password">
            <input type="submit" value="Login">
            <p class="message">Not registered? <a href="#">Create an account</a></p>
        </form>
    </div>
</div>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

<script  src="js/index.js"></script>
</body>
</html>
