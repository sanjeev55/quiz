<!doctype html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang=''>
<head>
    <meta charset='utf-8'>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/styleMenu.css">
    <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
    <script src="js/script.js"></script>
    <title>Menu</title>
    <style>
        h1{
            text-align: center;
            padding-top: 200px;
            font: arial ;
        }
    </style>
</head>
<body>

<div id='cssmenu'>
    <ul>
        <c:if test="${r.role=='admin'}">
            <li><a  href="/add?page=createQuestion" >Add Question</a></li>
            <li><a  href="/add?page=list" >View Question List</a> </li>
            <li><a  href="/user?page=list" >View User List</a></li>
        </c:if>
        <li><a  href="/add?page=selectCategory" >Play Quiz</a></li>
        <li><a  href="#">About</a></li>
        <li><a  href="#">Contact</a></li>
        <li><a  href="/user?page=logout">Log Out</a></li>
        <li><a  href="#">Welcome ${u.name}</a></li>
    </ul><br>
    <h1>Welcome</h1>
</div>

</body>
<html>
