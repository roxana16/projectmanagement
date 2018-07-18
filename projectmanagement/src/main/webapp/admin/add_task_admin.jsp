<!DOCTYPE html>
<html lang="zxx" class="no-js">
<body>

<form class="create-task" action="#" METHOD="post">
    <div class="btn-group">
    <select name="username" type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
        <option value="#">User 1</option>
        <option value="#">User 2</option>
        <option value="#">User 3</option>
    </select>
    </div>
    <div class="btn-group">
        <select name="projectname" type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
            <option value="#">Project 1</option>
            <option value="#">Project 2</option>
            <option value="#">Project 3</option>
        </select>
    </div>
    <div class="btn-group">
        <select name="status" type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
            <option value="#">Open</option>
            <option value="#">On Hold</option>
            <option value="#">Closed</option>
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



