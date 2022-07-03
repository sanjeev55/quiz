<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 10/31/2017
  Time: 9:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <style>
        h2{
            text-align: center;
            padding-bottom: 30px;
        }

    </style>
</head>
<body>

<form method="post" action="/add">
     <input type="hidden" name="page" value="addQuestion">
    <h2>--------Enter the question--------</h2>
    <p style="text-align: center">Question:<input type="text" name="question" placeholder="Enter a question" style="margin: 10px " ></p>
    <p style="text-align: center">Option1:<input type="text" name="option1" placeholder="Enter Option1" style="margin: 10px "></p>
    <p style="text-align: center">Option2:<input type="text" name="option2" placeholder="Enter Option2" style="margin: 10px "></p>
    <p style="text-align: center">Option3:<input type="text" name="option3" placeholder="Enter Option3" style="margin: 10px "></p>
    <p style="text-align: center">Option4:<input type="text" name="option4" placeholder="Enter Option4" style="margin: 10px "></p>
    <p style="text-align: center">Correct Answer:<input type="text" name="answer" placeholder="Enter the correct answer"style="margin: 5px "></p>
    <p style="text-align: center">Category<input type="text" name="category" placeholder="Enter a Category" style="margin: 10px "></p>
    <p style="text-align: center"> <input type="submit" value="Add"></p>

</form>

</body>
</html>
