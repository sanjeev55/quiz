<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html >
<head>
    <meta charset="UTF-8">
    <title>Question List</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">


    <link rel="stylesheet" href="css/styleTable.css">


</head>

<body>
<section>
    <!--for demo wrap-->
    <h1>Question List</h1>
    <div class="tbl-header">
        <table cellpadding="0" cellspacing="0" border="0">
            <thead>
            <tr>
                <th>ID</th>
                <th>Question</th>
                <th>Option1</th>
                <th>Option2</th>
                <th>Option3</th>
                <th>Option4</th>
                <th>Correct Answer</th>
                <th>Category</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
        </table>
    </div>
    <div class="tbl-content">
        <table cellpadding="0" cellspacing="0" border="0">
            <tbody>
            <c:forEach items="${question}" var="q">
                <tr >
                    <td>${q.id}</td>
                    <td>${q.question}</td><%--getter lai call garirako hunxa behind the scene--%>
                    <td>${q.option1}</td>
                    <td>${q.option2}</td>
                    <td>${q.option3}</td>
                    <td>${q.option4}</td>
                    <td>${q.correctAnswer}</td>
                    <td>${q.category}</td>
                    <td><a href="/add?page=editQuestion&&id=${q.id}">Edit</a></td>
                    <td><a href="/add?page=deleteQuestion&&id=${q.id}">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

</a>
    </div>
</section>
     <a href="/add?page=createQuestion" style="margin-left: 50px">
    <button>Add New Question</button>





<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

<script  src="js/tableIndex.js"></script>

</body>
</html>



