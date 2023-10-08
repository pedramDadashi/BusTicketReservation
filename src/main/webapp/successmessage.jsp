<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 7/19/2023
  Time: 1:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
            crossorigin="anonymous"></script>
    <title>Success Message</title>
    <!--    <link rel="stylesheet" href="SearchPageStyle.css">-->

</head>
<style>
    body {
        margin: 0;
        height: 100vh;
        width: 100vw;
        display: flex;
        color: white;
    }

    .parent-div {
        width: 100%;
        height: 100%;
        background-image: url("https://www.faw.co.zw/img/pics/Double-Axles-Bus.jpg");
        background-repeat: no-repeat;
        background-size: 100% 110%;
    }

    form {
        background-color: rgba(0, 0, 0, 0.5);
        width: 30%;
        height: 30%;
        margin-left: 35%;
        margin-top: 10%;
        border-radius: 10px;
        padding-top: 2%;
    }

    .mb-3{
        width: 80%;
        text-align:right;
        margin-left:10%;
        margin-top:5%;
    }

    .btn{
        margin-left:40%;
        margin-top:20%;
        width:20%;
        height:20%;
    }

    .text{
        font-size:90%;
        text-align:center;
        margin-bottom:8%;
        margin-top:5%;
    }

    .title{
        font-size:120%;
        text-align:center;

    }

    .form-check, .gender{
        margin-left: 10%;
        margin-bottom: 2%;
    }
    .gender{
        margin-top: 5%;
        margin-bottom: 5%;
    }

</style>
<body>
<div class="parent-div">
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <div class="container-fluid">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" href="home.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="search.jsp">Buy Ticket</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="bookinghistoryservlet">Booking History</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="signup.jsp">Sign Up</a>
                </li>
            </ul>
        </div>
    </nav>
    <form action="home.jsp">
        <p class = "title">Your ticket has been booked successfully</p>

        <div class = "d-grid"></div>
        <button type="submit" class="btn btn-primary px-4">OK</button>
    </form>

</div>

</body>
</html>

