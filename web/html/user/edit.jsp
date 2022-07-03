<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/2/2017
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title></title>
    <style>
        h2{
            text-align: center;
            padding: 10px;
        }
        p{
           text-align: center;
            margin: 10px;
        }
    </style>
</head>
<body>
<form method="post" action="/user">
    <input type="hidden" name="page" value="editUser">
    <h2>Please Update the User info</h2>
    <p>ID:<input type="hidden" name="id" value="${u.id}"></p>
    <p>Name:<input type="text" name="name" value="${u.name}"></p>
    <p>Password:<input type="text" name="password" value="${u.password}"></p>
    <p> Email:<input type="text" name="email" value="${u.email}"></p>

    <p> <input type="submit" value="Update"></p>


</form>

</body>
</html>
