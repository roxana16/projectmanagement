<!DOCTYPE html>
<html lang="zxx" class="no-js">

<head>
    <link rel="shortcut icon" href="img/fav.png">
    <meta charset="UTF-8">
    <title>PMT</title>
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet">
    <link rel="stylesheet" href="css/linearicons.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/magnific-popup.css">
    <link rel="stylesheet" href="css/nice-select.css">
    <link rel="stylesheet" href="css/animate.min.css">
    <link rel="stylesheet" href="css/owl.carousel.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
</head>

<body>
<header id="header">
    <div class="container main-menu">
        <div class="row align-items-center justify-content-between d-flex">
            <div id="logo">
                <a href="index.jsp"><img src="img/logo.png" alt="" title=""/></a>
            </div>
            <nav id="nav-menu-container">
                <ul class="nav-menu">
                    <li><a href="index.jsp">Home</a></li>
                    <li id="about"><a href="#">About</a></li>
                    <li id="team"><a href="#">Team</a></li>
                    <li id="help"><a href="#">Help</a></li>
                </ul>
            </nav>
        </div>
    </div>
</header>
<section class="banner-area">
    <div class="container">
        <div class="row fullscreen align-items-center justify-content-between">
            <div class="col-lg-6 col-md-6 banner-left">
            <div class="view-data">
                <div class="login">
                    <form action="login" method="POST">
                        <h4>Log in</h4><br>
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text">Username</span>
                            </div>
                            <input type="text" class="form-control" name="username" placeholder="Username">
                        </div>
                        <br>
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text">Password</span>
                            </div>
                            <input type="password" class="form-control" name="password" placeholder="Password">
                        </div>
                        <br>
                        <br>
                            <input type="submit" value="LOGIN" class="btn btn-outline-primary"/>
                    </form>
                    <br>
                    <p>Don't have an account?</p>
                    <a href="signup.jsp">
                        <input type="submit" value="SIGNUP" class="btn btn-outline-primary"/>
                    </a>
                </div>
            </div>
            </div>
            <div class="col-lg-6 col-md-6 banner-right d-flex align-self-end">
                <img class="img-fluid" src="img/firstpage.png" alt="">
            </div>

    </div>
    </div>
</section>

<section class="home-about-area pt-120" id="myAbout">
    <div class="container">
        <div class="row align-items-center justify-content-between">
            <div class="col-lg-6 col-md-6 home-about-left">
                <img class="img-fluid" src="img/about.png" width="450" height="120" alt="">
            </div>
            <div class="col-lg-5 col-md-6 home-about-right">
                <h6>PMT - PRODUCTIVE | MOTIVATED | THINKING outside the box</h6>
                <h3 class="text-uppercase">About PMT</h3>
                <br><br>
                <p>
                    PMT is our newest tool to help you enhance your project management.
                    If you're looking to bring some extra efficiency to your team,try PMT and you will skyrocket your
                    project performance.</p>

                <a id="but_detalii" class="primary-btn text-uppercase" onclick="myFunction();">View Full Details</a>
                <div id="myDIV" class="myDIV" style="display: none">
                    <p>PMT is a innovative tool that helps you create insightful reports about completed tasks and team
                        members performance.The unscheduled time helps you set realistic deadlines and avoid overbooking
                        people. Try it out and if you have feedback please contact us!</p>
                </div>

            </div>
        </div>
    </div>
</section>

<section class="team" id="myTeam">
    <div class="container">
        <div class="row d-flex justify-content-center">
            <div class="menu-content pb-70 col-lg-8">
                <div class="title text-center">
                    <h1 class="mb-10">Team 1</h1>
                    <ul>
                        <li>Felix-Malte Lindner Barth</li>
                        <li>Cristian Vistieru</li>
                        <li> Roxana Banciu</li>
                        <li>Mangeac Alin</li>
                        <li>Berbece Andrei</li>
                        <li>Lungu Cosmin-Ioan</li>
                        <li>Cristina Natea</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="recent-blog-area section-gap" id="myHelp">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-8 pb-30 header-text">
                <h1>Do you need help?</h1>

                <p>Email us with any question or inquiries or call 0734/543.210.We would be happy
                    to answer your questions and set up a meeting with you. PMT can help you manage the workload on a
                    busy day!</p>
                <div class="container" align="center">


                    <form action="help" method="POST">
                        <h6>First Name</h6>
                        <input type="text" name="firstname">
                        <h6>Last Name</h6>
                        <input name="lastname"><br>
                        <h6>Email</h6>
                        <input name="email"><br>
                        <h6>Subject</h6>
                        <textarea id="subject" name="subject" placeholder="Write something.."
                                  style="height:200px"></textarea><br>
                        <br>
                        <input type="submit" value="Send"/>
                    </form>
                </div>

            </div>
        </div>
    </div>
</section>

<footer class="footer">
    <p>&copy; 2018 by Team 1</p>
</footer>

<script src="js/vendor/jquery-2.2.4.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/vendor/bootstrap.min.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>
<script src="js/easing.min.js"></script>
<script src="js/hoverIntent.js"></script>
<script src="js/superfish.min.js"></script>
<script src="js/jquery.ajaxchimp.min.js"></script>
<script src="js/jquery.magnific-popup.min.js"></script>
<script src="js/jquery.tabs.min.js"></script>
<script src="js/jquery.nice-select.min.js"></script>
<script src="js/isotope.pkgd.min.js"></script>
<script src="js/waypoints.min.js"></script>
<script src="js/jquery.counterup.min.js"></script>
<script src="js/simple-skillbar.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/mail-script.js"></script>
<script src="js/main.js"></script>
<script src="js/bootstrap-datepicker.js"></script>

<script>
    $(document).ready(function () {
        $("#about").click(function () {
            $('html, body').animate({
                scrollTop: $("#myAbout").offset().top
            }, 2000);
        });
    })

    $(document).ready(function () {
        $("#team").click(function () {
            $('html, body').animate({
                scrollTop: $("#myTeam").offset().top
            }, 2000);
        });
    })

    $(document).ready(function () {
        $("#help").click(function () {
            $('html, body').animate({
                scrollTop: $("#myHelp").offset().top
            }, 2000);
        });
    })

    function myFunction() {
        var x = document.getElementById("myDIV");
        x.style.display = "block";

        x = document.getElementById("but_detalii");
        x.style.display = "none";
    }
</script>
</body>
</html>