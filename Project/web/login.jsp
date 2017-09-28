<%--
  Created by IntelliJ IDEA.
  User: nttej
  Date: 2017-09-22
  Time: 오후 6:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Language" content="ko">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
    <title>Login</title>
</head>
<body>

<section class="main">
    <form method = "post" action = "ServletLogin">
        <div class="form-group col-6 col-md-4">
            <input type="text" class="form-control" name="userId" aria-describedby="emailHelp" placeholder="user id">
            <input type="password" class="form-control" name="userPassword" placeholder="user passowrd">
        </div>
        <div class="form-check">
            <label class="form-check-label">
                <input type="checkbox" class="form-check-input">
                Remember Login
            </label>
        </div>
        </table>
        <button type="submit" class="btn btn-primary col-2 col-md-2">Today Login</button>
    </form>
</section>
</body>
</html>

<script src="bower_components/jquery/dist/jquery.min.js"></script>
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

