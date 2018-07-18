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

</body>
</html>
