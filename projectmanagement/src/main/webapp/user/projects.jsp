<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
!DOCTYPE html>
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
                    <li><a href="index.jsp">Home</a></li>
                    <li id="projectsadmin"><a href="/user/projects">Projects</a></li>
                    <li id="tasks"><a href="/user/tasks">Tasks</a></li>
                    <li id="generatereportuser"><a href="generate_report.jsp">Generate Report</a></li>
                    <li>
                        <form action="/logout" method="POST">
                            <button type="submit">Logout</button>
                        </form>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</header>
<section class="banner-area"><br><br><br>
    <div class="container">
        <div class="row fullscreen align-items-left justify-content-between">
            <div class="col-lg-12 col-md-12 banner">
                <div id="accordion">
                    <div class="card">
                        <div class="card-header" id="headingOne">
                            <h5 class="mb-0">
                                <button class="btn btn-link" data-toggle="collapse" data-target="#collapseOne"
                                        aria-expanded="true" aria-controls="collapseOne">
                                    View all projects
                                </button>
                            </h5>
                        </div>

                        <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
                            <div class="card-body">
                                <div>
                                    <c:forEach items="${projects}" var="project">
                                        <p><c:out value="${project.getProjectTitle()}"/></p>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<!-- start footer Area -->
<footer class="footer">
    <p>&copy; 2018 by Team 1</p>
</footer>

<script src="../js/vendor/jquery-2.2.4.min.js"></script>
<script src="../js/popper.min.js"></script>
<script src="../js/vendor/bootstrap.min.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>
<script src="../js/easing.min.js"></script>
<script src="../js/hoverIntent.js"></script>
<script src="../js/superfish.min.js"></script>
<script src="../js/jquery.ajaxchimp.min.js"></script>
<script src="../js/jquery.magnific-popup.min.js"></script>
<script src="../js/jquery.tabs.min.js"></script>
<script src="../js/jquery.nice-select.min.js"></script>
<script src="../js/isotope.pkgd.min.js"></script>
<script src="../js/waypoints.min.js"></script>
<script src="../js/jquery.counterup.min.js"></script>
<script src="../js/simple-skillbar.js"></script>
<script src="../js/owl.carousel.min.js"></script>
<script src="../js/mail-script.js"></script>
<script src="../js/main.js"></script>

</body>
</html>
