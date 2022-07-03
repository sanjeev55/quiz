<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html >
<head>
    <meta charset="UTF-8">
    <title>Result</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">


    <link rel="stylesheet" href="css/styleTable.css">


</head>

<body>
<section>
    <!--for demo wrap-->
    <h1>Result</h1>
    <div class="tbl-header">
        <table cellpadding="0" cellspacing="0" border="0">
            <thead>
            <tr>
                <th>Question ID</th>
                <th>User ID</th>
                <th>Marks</th>
                <th>Time Taken</th>
                <th>Status</th>

            </tr>
            </thead>
        </table>
    </div>
    <div class="tbl-content">
        <table cellpadding="0" cellspacing="0" border="0">
            <tbody>
            <c:set var="total" value="${0}"/>
            <c:forEach items="${result}" var="r">
                <tr>

                    <td>${r.questionId}</td>
                    <td>${r.userId}</td>
                    <td>${r.marks}</td>
                    <td>${r.timeTaken}</td>
                    <c:set var="total" value="${total+r.marks}"/>
                    <td>
                        <c:choose>
                            <c:when test="${r.marks==5}">
                                <img src="/asset/right.png" alt="correct" width="25" height="25">
                            </c:when>
                            <c:when test="${r.marks==0}">
                                <img src="/asset/wrong.png" alt="wrong" width="25" height="25">
                            </c:when>

                        </c:choose>
                    </td>

                </tr>
            </c:forEach>
            <tr>
                <td colspan="2">Total</td>
                <td colspan="2"> <c:out value="${total}"/></td>
            </tr>
            </tbody>

        </table>
    </div>
</section>
<a href="/add?page=selectCategory" style="margin-left: 50px"><button>Play Again</button></a>

<a href="/add?page=quit" style="margin-left: 100px"><button>Quit</button></a>


<!-- follow me template -->

<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

<script  src="js/tableIndex.js"></script>

</body>
</html>
