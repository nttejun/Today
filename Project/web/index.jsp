<%--
  Created by IntelliJ IDEA.
  User: nttej
  Date: 2017-09-20
  Time: 오후 5:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
    <title>Today</title>
</head>
<body>

<section id="main">

    <nav class="navbar navbar-light" style="background-color: #e3f2fd;">
        <a class="navbar-brand" href="#">Today</a>
        <a class="navbar-brand" href="#" onclick="issueEnrollBtn()">New Today</a>
        <a class="navbar-brand" href="#" id="loginBtn">Login</a>
        <form class="form-inline" style="float: right">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </nav>

    <div id="userArea"></div>

    <div class="container">
        <div class="col align-self-center">
            <p>
                <a href="#" class="list-group-item active col-12 col-md-8">
                    가장 최근 이슈
                </a>
                <a href="#" class="list-group-item list-group-item-action col-12 col-md-8">살충제 계란</a>
                <a href="#" class="list-group-item list-group-item-action col-12 col-md-8">광우병 논란</a>
                <a href="#" class="list-group-item list-group-item-action col-12 col-md-8">후쿠시마 생선</a>
            </p>
        </div>
    </div>

    <div class="container">
        <table class="table table-striped">
            <div class="col align-self-center">

                <nav aria-label="Page navigation example">
                    <ul class="pagination">
                        <li class="page-item">
                            <a class="page-link" href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                                <span class="sr-only">Previous</span>
                            </a>
                        </li>
                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item">
                            <a class="page-link" href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                                <span class="sr-only">Next</span>
                            </a>
                        </li>
                    </ul>
                </nav>

            </div>
        </table>
    </div>

</section>

</body>
</html>

<script type="text/javascript" src="public/js/sideCategory.js"></script>
<script src="bower_components/jquery/dist/jquery.min.js"></script>
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script type="text/javascript">

    var loginBtn = document.getElementById('loginBtn');
    loginBtn.onclick = function () {
        location.href = "login.jsp";
    }

</script>