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
                    <li><a href="/admin/index.jsp">Home</a></li>
                    <li id="projectsadmin"><a href="/admin/projects">Projects</a></li>
                    <li id="tasks"><a href="/admin/tasks">Tasks</a></li>
                    <li id="generatereportadmin"><a href="/admin/generate_report.jsp">Generate Report</a></li>
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


<br>
<form class="update-task" action="/admin/updatetask" METHOD="POST">
    <div class="input-group">
        <div class="input-group-prepend">
            <span class="input-group-text">Title</span>
        </div>
        <input type="text" class="form-control" name="title" disabled="disabled"
               value="<c:out value="${task.getTaskName()}"/>">
        <div class="input-group">
            <div class="input-group-prepend">
                <span class="input-group-text">Description</span>
            </div>
            <textarea class="form-control" name="taskcontent" rows="7"><c:out value="${task.getTaskContent()}"/></textarea>
        </div>
        <br>
        <div class="input-group">
            <div class="input-group-prepend">
                <span class="input-group-text">Hours remaining</span>
            </div>
            <input name="remainingtime" type="number" value="<c:out value="${task.getHoursLeft()}"/>" min="0"
                   class="form-control currency"/>
        </div>
        <br>
        <div class="btn-group">
            <div class="input-group-prepend">
                <span class="input-group-text">Status</span>
            </div>
            <select name="status" type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                <c:forEach items="${statuses}" var="status" varStatus="loop">
                    <option  <c:if test="${status.getStatusId() == task.getStatus().getStatusId()}">selected="selected"</c:if> value= "${status.getStatusId()}">
                        <c:out value="${status.getStatusName()}"/>
                    </option>
                </c:forEach>
            </select>
        </div>
    </div>
    <br>
    <input type="submit" value="Update" class="btn btn-outline-primary"/>
    <input type="hidden" id="taskId1" name="taskid" value="${param.taskid}">
</form>
<br>
<div>

    <c:forEach items="${task.getComments()}" var="comment">
        <div>
            <div class="input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text"><c:out value="${comment.getUser().getUserName()}"/></span>
                </div>
                <input type="text" class="form-control" name="title" disabled="disabled"
                       value="<c:out value="${comment.getCommentContent()}"/>">

            </div>
        </div>
    </c:forEach>

</div>

<br>
<form class="add-comment" action="/admin/addcomment" METHOD="POST">
    <div class="input-group">
        <div class="input-group">
            <textarea class="form-control" name="commentcontent" rows="7"></textarea>
        </div>
    </div>
    <br>
    <input type="submit" value="Post Comment" class="btn btn-outline-primary"/>
    <input type="hidden" id="taskid2" name="taskid" value="${param.taskid}">
</form>

</body>
</html>
