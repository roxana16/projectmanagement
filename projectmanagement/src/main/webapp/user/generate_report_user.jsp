<!DOCTYPE html>
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

    <style>
        canvas {
            -moz-user-select: none;
            -webkit-user-select: none;
            -ms-user-select: none;
        }
    </style>

</head>

<body>
<header id="header">
    <div class="container main-menu">
        <div class="row align-items-center justify-content-between d-flex">
            <div id="logo">
                <a href="index_user.jsp"><img src="../img/logo.png" alt="" title=""/></a>
            </div>
            <nav id="nav-menu-container">
                <ul class="nav-menu">
                    <li><a href="index_user.jsp">Home</a></li>
                    <li id="projectsuser"><a href="projects_user.jsp">Projects</a></li>
                    <li id="myopenissues"><a href="my_open_issues_user.jsp">My open issues</a></li>
                    <li id="allissues"><a href="all_issues_user.jsp">All issues</a></li>
                    <li id="generatereportuser"><a href="generate_report_user.jsp">Generate Report</a></li>
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
<section class="generate-reports-user">
    <div class="container">
        <!--    <div class="row fullscreen align-items-center justify-content-between"> -->
        <div class="generating">
            <h4>My reports</h4>
            <div class="charts-result">
                <form action=""
                <canvas id="pie-chart"></canvas>
            </div>
        </div>
    </div>
</section>

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

<script src="../js/Chart.bundle.min.js"></script>
<script src="../js/utils.js"></script>


<script>
    new Chart(document.getElementById("pie-chart"), {
        type: 'pie',
        data: {
            labels: ["Closed", "Open", "On Hold"],
            datasets: [{
                label: "Population (millions)",
                backgroundColor: ["#E90909", "#00FF00", "#FF8000"],
                data: [35, 22, 10]
            }]
        },
        options: {
            title: {
                display: true,
                text: 'Task Status'
            }
        }
    });
</script>

</body>
</html>