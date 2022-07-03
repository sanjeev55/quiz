<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html >
<head>
    <meta charset="UTF-8">
    <title>User List</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">


    <link rel="stylesheet" href="css/styleTable.css">


</head>

<body>
<section>
    <!--for demo wrap-->
    <h1>User List</h1>
    <div class="tbl-header">
        <table cellpadding="0" cellspacing="0" border="0">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
        </table>
    </div>
    <div class="tbl-content">
        <table cellpadding="0" cellspacing="0" border="0">
            <tbody>
            <c:forEach items="${user}" var="u">
                <tr >
                    <td>${u.id}</td>
                    <td>${u.name}</td><%--getter lai call garirako hunxa behind the scene--%>

                    <td>${u.email}</td>

                    <td><a href="/user?page=editUser&&id=${u.id}">Edit</a></td>
                    <td><a href="/user?page=deleteUser&&id=${u.id}">Delete</a></td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
</section>




<!-- follow me template -->

<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

<script  src="js/tableIndex.js"></script>

</body>
</html>