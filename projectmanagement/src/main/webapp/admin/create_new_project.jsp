<!DOCTYPE html>
<body>

<form class="create-project" action="/admin/createproject" METHOD="GET">
    <div class="input-group">
        <div class="input-group-prepend">
            <span class="input-group-text">Title</span>
        </div>
        <input type="text" class="form-control"  name="title">
    </div>
    <br>
    <div class="input-group">
        <div class="input-group-prepend">
            <span class="input-group-text">Description</span>
        </div>
        <textarea class="form-control"  name="description" rows="1"></textarea>
    </div>
    <br>
    <div class="input-group">
        <div class="input-group-prepend">
            <span class="input-group-text">Release Date</span>
        </div>
        <input class="form-control" id="datepicker" name="releasedate" placeholder="YYYY/MM/DD" type="text"/>
    </div>
    <br>
        <input type="submit" value="Create" class="btn btn-outline-primary"/>
</form>

</body>
</html>
