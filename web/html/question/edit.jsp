<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/2/2017
  Time: 3:14 PM
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
    </style>
</head>
<body>

<form method="post" action="/add">
    <input type="hidden" name="page" value="editQuestion">
    <h2>Please Update the question</h2>
    <p style="text-align: center">ID:<input type="hidden" name="id" value="${q.id}"></p>
    <p style="text-align: center">Question:<input type="text" name="question" value="${q.question}" style="margin: 10px "></p>
    <p style="text-align: center">Option1:<input type="text" name="option1" value="${q.option1}" style="margin: 10px "></p>
    <p style="text-align: center">Option2:<input type="text" name="option2" value="${q.option2}" style="margin: 10px "></p>
    <p style="text-align: center">Option3:<input type="text" name="option3" value="${q.option3}" style="margin: 10px "></p>
    <p style="text-align: center">Option4:<input type="text" name="option4" value="${q.option4}" style="margin: 10px "></p>
    <p style="text-align: center"> Correct Answer:<input type="text" name="answer" value="${q.correctAnswer}" style="margin: 10px "></p>
    <p style="text-align: center">Category<input type="text" name="category" value="${q.category}" style="margin: 10px "></p>
    <p style="text-align: center"><input type="submit" value="Update"></p>


</form>

</body>
</html>
