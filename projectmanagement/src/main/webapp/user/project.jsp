<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Felix
  Date: 2018-07-18
  Time: 7:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zxx" class="no-js">

<head>
    <link rel="shortcut icon" href="../img/fav.png">
    <meta charset="UTF-8">
    <title>PMT</title>
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet">
    <link rel="stylesheet" href="../css/linearicons.css">
    <link rel="stylesheet" href="../css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/magnific-popup.css">
    <link rel="stylesheet" href="../css/nice-select.css">
    <link rel="stylesheet" href="../css/animate.min.css">
    <link rel="stylesheet" href="../css/owl.carousel.css">
    <link rel="stylesheet" href="../css/main.css">
    <link rel="stylesheet" href="../css/bootstrap-datepicker.css">
</head>
<body>
<header id="header">
    <div class="container main-menu">
        <div class="row align-items-center justify-content-between d-flex">
            <div id="logo">
                <a href="index.jsp"><img src="../img/logo.png" alt="" title=""/></a>
            </div>
            <nav id="nav-menu-container">
                <ul class="nav-menu">
                    <li><a href="/user/index.jsp">Home</a></li>
                    <li id="projectsadmin"><a href="/user/projects">Projects</a></li>
                    <li id="tasks"><a href="/user/tasks">Tasks</a></li>
                    <li id="generatereportadmin"><a href="/user/generate_report.jsp">Generate Report</a></li>
                    <li>
                        <form action="/logout" method="POST">
                            <input type="submit" value="Logout" class="btn btn-outline-primary"/>
                        </form>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</header>
<br>
<br>
<br>
<br>
<br>
<div class="input-group">
    <div class="input-group-prepend">
        <span class="input-group-text">Title</span>
    </div>
    <input type="text" class="form-control" name="title" disabled="disabled"
           value="<c:out value="${project.getProjectTitle()}"/>">

</div>
<br>
<div class="input-group">
    <div class="input-group-prepend">
        <span class="input-group-text">Description</span>
    </div>
    <textarea class="form-control" name="description" rows="7" disabled="disabled">
            <c:out value="${project.getProjectContent()}"/>
            </textarea>
</div>
<br>
<div class="input-group">
    <div class="input-group-prepend">
        <span class="input-group-text">Release Date</span>
    </div>
    <input class="form-control" id="datepicker" name="releasedate" placeholder="YYYY/MM/DD" type="text"
           disabled="disabled" value="<c:out value="${project.getReleaseDate()}"/>"/>
</div>
<br>

<div>
    <table style="width:100%">
        <tr>
            <th>Task ID</th>
            <th>Task Name</th>
            <th>Estimated time of Completion</th>
            <th>Status</th>
            <th>Time so far</th>
            <th>Assigned to</th>
        </tr>
        <c:forEach items="${project.getTasks()}" var="task">
            <tr>
                <td><c:out value="${task.getTaskId()}"/></td>
                <td><c:out value="${task.getTaskName()}"/></td>
                <td><c:out value="${task.getEstimatedTimeOfCompletion()}"/></td>
                <td><c:out value="${task.getStatus().getStatusName()}"/></td>
                <td><c:out value="${task.getHoursSoFar()}h"/></td>
                <td><c:out value="${task.getUser().getUserName()}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>


</body>
</html>
