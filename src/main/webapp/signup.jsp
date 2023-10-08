<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 7/15/2023
  Time: 1:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
            crossorigin="anonymous"></script>
    <title>Sign Up Page</title>
    <!--  <link rel="stylesheet" href="SignUpPageStyle.css">-->
    <style>
        body {
            background: #007bff;
            background: linear-gradient(to right, #0062E6, #33AEFF);
        }

        .btn-login {
            font-size: 0.9rem;
            letter-spacing: 0.05rem;
            padding: 0.75rem 1rem;
        }

        .btn-google {
            color: white !important;
            background-color: #ea4335;
        }

        .btn-facebook {
            color: white !important;
            background-color: #3b5998;
        }

    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-9 col-md-7 col-lg-5 mx-auto my-5">
            <div class="card border-0 shadow rounded-3 my-5">
                <div class="card-body p-4 p-sm-5">
                    <h5 class="card-title text-center mb-5 fw-light fs-2">Sign Up</h5>
                    <form name="myForm" action="signupservlet" method="post" onsubmit="return validateForm()">
                        <div class="form-floating mb-3">
                            <input type="text" name="firstname" class="form-control" id="floatingFirstName"
                                   placeholder="First Name">
                            <label for="floatingFirstName">First Name</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="text" name="lastname" class="form-control" id="floatingLastName"
                                   placeholder="Last Name">
                            <label for="floatingLastName">Last Name</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="text" name="username" class="form-control" id="floatingInput" placeholder="Username">
                            <label for="floatingInput">Username</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="Password">
                            <label for="floatingPassword">Password</label>
                        </div>
                        <div class="form-check mb-3">
                            <input class="form-check-input" type="checkbox" value="" id="rememberPasswordCheck">
                            <label class="form-check-label" for="rememberPasswordCheck">
                                Remember password
                            </label>
                        </div>
                        <div class="d-grid">
                            <button class="btn btn-primary btn-login text-uppercase fw-bold" type="submit">Sign
                                Up
                            </button>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    function validateForm() {
        var firstname = document.forms["myForm"]["firstname"].value;
        var lastname = document.forms["myForm"]["lastname"].value;
        var username = document.forms["myForm"]["username"].value;
        var password = document.forms["myForm"]["password"].value;
        if (firstname == ""){
            alert("First Name must be filled out")
            return false;
        }
        if (lastname == ""){
            alert("Last Name must be filled out")
            return false;
        }
        if (username == "") {
            alert("Username must be filled out");
            return false;
        }
        if (password == "") {
            alert("Password must be filled out");
            return false;
        }
    }
</script>
</body>
</html>


