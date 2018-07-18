<!DOCTYPE html>
<html lang="zxx" class="no-js">
<body>

<form class="create-task" action="#" METHOD="post">
    <div class="btn-group">
        <button name="username" type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            User
        </button>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="#">User 1</a>
            <a class="dropdown-item" href="#">User 2</a>
            <a class="dropdown-item" href="#">User 3</a>
        </div>
    </div>
    <div class="btn-group">
        <button name="projectname" type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Project
        </button>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="#">Project 1</a>
            <a class="dropdown-item" href="#">Project 2</a>
            <a class="dropdown-item" href="#">Project 3</a>
        </div>
    </div>
    <div class="btn-group">
        <button name="status" type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Status
        </button>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="#">Open</a>
            <a class="dropdown-item" href="#">On hold</a>
            <a class="dropdown-item" href="#">Closed</a>
        </div>
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



