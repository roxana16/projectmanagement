<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx" class="no-js">
<body>

<c:set var="users" value="${users}" scope="request"/>

<form class="create-task" action="/createtask" METHOD="post">
    <div class="btn-group">
        <select name="username" type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
            <c:forEach items="${users}" var="user" varStatus="loop">
                <option value = ${user.getUserId()}><c:out value="${user.getUserName()}"/></option>
            </c:forEach>
        </select>
    </div>
    <div class="btn-group">
        <select name="projectname" type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
            <c:forEach items="${projects}" var="project" varStatus="loop">
                <option value = ${project.getProjectId()}><c:out value="${project.getProjectTitle()}"/></option>
            </c:forEach>
        </select>
    </div>
    <div class="btn-group">
        <select name="status" type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
            <c:forEach items="${statuses}" var="status" varStatus="loop">
                <option value = ${status.getStatusId()}><c:out value="${status.getStatusName()}"/></option>
            </c:forEach>
        </select>
    </div>
    <br><br>
    <div class="input-group">
        <div class="input-group-prepend">
            <span class="input-group-text">Task name</span>
        </div>
        <input type="text" class="form-control"  name="taskname">
    </div>
    <br>
    <div class="input-group">
        <div class="input-group-prepend">
            <span class="input-group-text">Remaining time</span>
        </div>
        <input name="remainingtime" type="number" value="0" min="0" class="form-control currency"/>
    </div>
    <br>
    <div class="input-group">
        <div class="input-group-prepend">
            <span class="input-group-text">Task Content</span>
        </div>
        <textarea class="form-control"  name="taskcontent" rows="1"></textarea>
    </div>
    <br>
    <input type="submit" value="Create" class="btn btn-outline-primary"/>
</form>

</body>
</html>



