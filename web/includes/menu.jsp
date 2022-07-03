<c:if test="${r.role=='admin'}">
    <li><a  href="/add?page=createQuestion" >Add Question</a></li>
    <li><a  href="/add?page=list" >View Question List</a> </li>
    <li><a  href="/user?page=list" >View User List</a></li>
</c:if>
<li><a  href="/add?page=playQuiz" >Play Quiz</a></li>
<li><a  href="#">About</a></li>
<li><a  href="#">Contact</a></li>
<li><a  href="/user?page=logout">Log Out</a></li>
<li><a  href="#">Welcome ${u.name}</a></li>
