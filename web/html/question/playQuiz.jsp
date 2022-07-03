<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/3/2017
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Play Quiz</title>
    <script>
        var sec=20;
        function countdown(){
            if(parseInt(sec)>0){
                document.getElementById("timer").innerHTML="Time Remaining"+" "+sec+" "+"Seconds";
                sec=parseInt(sec)-1;
                var currentSec=document.getElementById("second");
                currentSec.value=sec;

                setTimeout("countdown()",1000);
            }
            else{
                if(parseInt(sec)==0){
                    document.getElementById("timer").innerHTML="Time Remaining"+" "+sec+" "+"Seconds";
                    alert("Time Up");
                    var inputs=document.getElementsByTagName('input');
                    for(var i=0;i<inputs.length;i++){
                        if(inputs[i].type=='radio'){
                            inputs[i].disabled=true;
                        }
                    }
                }
            }
        }
    </script>
    <style>
        body{
        <c:choose>
        <c:when test="${question.category=='Computer'}">
            background-image: url(/asset/computer.jpg);
        </c:when>
        <c:when test="${question.category=='Health'}">
            background-image: url(/asset/health.jpg);
        </c:when>
        <c:when test="${question.category=='Sports'}">
            background-image: url(/asset/sports.jpg);
        </c:when>
        <c:when test="${question.category=='Music'}">
            background-image: url(/asset/music.jpeg);
        </c:when>
        </c:choose>
            max-width: 1180px;
            width: 98%;
            margin: 0px auto;
            text-align: center;

        }
    </style>

</head>
<body onload="countdown()">
<div id="timer"></div>
<form method="post" action="/add">

    <input type="hidden" name="page" value="playQuizNext">
    <input type="hidden" name="id" value="${question.id}">
    <input type="hidden" name="correctAnswer" value="${question.correctAnswer}">
    <input type="hidden" name="category" value="${question.category}">
    <input type="hidden" name="difficulty" value="${question.difficulty}">
    <h1>${question.question}</h1>
    <input type="radio" name="option" value="${question.option1}">${question.option1}<br>
    <input type="radio" name="option" value="${question.option2}">${question.option2}<br>
    <input type="radio" name="option" value="${question.option3}">${question.option3}<br>
    <input type="radio" name="option" value="${question.option4}">${question.option4}<br><br>

    <input type="submit" value="Next">
    <input type="hidden" name="second" id="second" value="">
</form>
</body>
</html>
