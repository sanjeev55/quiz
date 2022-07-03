<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/10/2017
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title></title>
    <style>
        body{
            max-width: 1180px;
            width: 98%;
            margin: 0px auto;
            text-align: center;

        }
    </style>
</head>
<body  background="/asset/Background.jpg">
<h1 style="text-align: center">Select Difficulty</h1>
<form method="get" action="/add">
    <input type="hidden" name="category" value="${category}">
    <input type="hidden" name="page" value="playQuiz">
    <input type="hidden" name="difficulty" value="Easy">
    <input type="submit" value="Easy">
</form>

<form method="get" action="/add">
    <input type="hidden" name="category" value="${category}">
    <input type="hidden" name="page" value="playQuiz">
    <input type="hidden" name="difficulty" value="Medium">
    <input type="submit" value="Medium">
</form>

<form method="get" action="/add">
    <input type="hidden" name="category" value="${category}">
    <input type="hidden" name="page" value="playQuiz">
    <input type="hidden" name="difficulty" value="Hard">
    <input type="submit" value="Hard">
</form>

</body>
</html>
