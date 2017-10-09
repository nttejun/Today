<%--
  Created by IntelliJ IDEA.
  User: nttej
  Date: 2017-09-20
  Time: 오후 5:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <a class="navbar-brand" onclick="todayReset()" href="#">Today</a>
        <a class="navbar-brand" href="#" id="modal" data-toggle="modal" data-target="#exampleModal">NEW ISSUE</a>
        <c:choose>
            <c:when test="${sessionScope.userLoginStatus == null}">
                <a class="navbar-brand" href="#" id="loginBtn">Login</a>
            </c:when>
            <c:otherwise>
                <form action="ServletLogout" method="post">
                    <a type="submit" class="navbar-brand" href="#">Logout</a>
                        ${sessionScope.userLoginStatus} 님 접속 On
                </form>
            </c:otherwise>
        </c:choose>
        <form class="form-inline" style="float: right">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </nav>

    <div class="container">
        <div class="col align-self-center">
            <p>
                <a href="#" class="list-group-item active col-12 col-md-8">
                    가장 최근 이슈
                </a>
            <div id="userArea"></div>
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

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>

            <div class="modal-body">
                <p><input type="text" id="titleEnroll" placeholder="ISSUE 주제"></p>
                <p><input type="text" id="contentsEnroll" placeholder="ISSUE 내용"></p>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" onclick="issueEnrollBtn()" class="btn btn-primary" data-dismiss="modal">Issue
                        Enroll
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>

<script type="text/javascript" src="public/js/login.js"></script>
<script src="bower_components/jquery/dist/jquery.min.js"></script>
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
<script type="text/javascript">

    var todayReset = function todayReset() {

        $('#userArea').empty();

        $.ajax({
                type: "POST",
                cache: false,
                url: "IndexServlet",
                success: function (result) {

                    console.log("success");

                    var issueList = JSON.parse(result);

                    for (var index = 0; (issueList.data).length > index; index++) {

                        var view = "";

                        view += "<a href='#' class='list-group-item list-group-item-action col-12 col-md-8' data-id='" + index + "' id='" + issueList.seq[index] + "'>";
                        view += issueList.data[index]
                        view += "</a>"
                        view += "<div class='page-header' data-id='" + index + "' style='display: none'>"
                        view += "<h3>" + issueList.contents[index]
                        view += "<small>  Proceed with the discussion </small>"
                        view += "</h3></div>"

                        $('#userArea').append(view);

                    };

                }, error: function (error) {

                    console.log("error");

                }
            }
        );
    }

    $("#userArea a").live("click", function () {

        var indexNumber = ($(this).attr('data-id'));

        if ($("div[data-id='" + indexNumber + "']").css("display") == "none") {

            $("div[data-id='" + indexNumber + "']").css("display", "");

        } else {

            $("div[data-id='" + indexNumber + "']").css("display", "none");
        }

    });


    $('a[id=modal]').on('click', function () {

        $("div.modal").modal();

    })


    var issueEnrollBtn = function issueEnrollBtn() {

        var title = $("#titleEnroll").val();
        var contents = $("#contentsEnroll").val();

        var enrollData = {"title": title, "contents": contents};

        console.log(contents);

        var json;
        $.ajax({
            method: 'GET',
            data: enrollData,
            url: 'IssueEnrollServlet',
            success: function (result) {
                console.log("success");
            }, error: function (error) {
                alert("지금은 등록할 수 없습니다");
            }

        })

    }

</script>
