<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/10/2017
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category</title>
    <style>
        body{
            max-width: 1180px;
            width: 98%;
            margin: 0px auto;
            text-align: center;

        }
    </style>
</head>
<body background="/asset/Background.jpg">
<h1 style="text-align: center">Select a Category</h1>
<form method="get" action="/add">
<input type="hidden" name="page" value="selectDifficulty">
    <input type="hidden" name="category" value="Computer">
    <input type="submit" value="Computer">

    </form>
    <form method="get" action="/add">

        <input type="hidden" name="page" value="selectDifficulty">
        <input type="hidden" name="category" value="Health">
        <input type="submit" value="Health">

    </form>
    <form method="get" action="/add">
        <input type="hidden" name="page" value="selectDifficulty">
        <input type="hidden" name="category" value="Music">
        <input type="submit" value="Music">
    </form>
    <form method="get" action="/add" >
        <input type="hidden" name="page" value="selectDifficulty">
        <input type="hidden" name="category" value="Sports">
        <input type="submit" value="Sports">
</form>

</body>
</html>
