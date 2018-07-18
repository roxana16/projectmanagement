<%--
  Created by IntelliJ IDEA.
  User: Felix
  Date: 2018-07-17
  Time: 12:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<table>
    <c:forEach items="${projects}" var="project">
        <tr>
            <td>${project.getProjectTitle()}</td>
            <td>${project.getProjectContent()}</td>

        </tr>
    </c:forEach>
</table>
<br>
<h3>All tasks</h3>
<table style="width:100%">
    <tr>
        <th>Task ID</th>
        <th>Task Name</th>
        <th>Estimated time of Completion</th>
        <th>Status</th>
        <th>Time so far</th>
        <th>Assigned to</th>
    </tr>
    <tr>
        <td>Task ID</td>
        <td>Task Name</td>
        <td>Estimated time of Completion</td>
        <td>Status</td>
        <td>Time so far</td>
        <td>Assigned to</td>
    </tr>
</table>
</body>
</html>

