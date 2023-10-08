<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 7/19/2023
  Time: 10:47 AM
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
  <title>Passenger Info</title>
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
    height: 60%;
    margin-left: 35%;
    margin-top: 8%;
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
    margin-left:10%;
    margin-top:5%;
    width:80%;
    height:10%;
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
    margin-bottom: 10%;
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
  <form name="myForm" action="passengerinfoservlet" method="post" onsubmit="return validateForm()">
    <p class = "title">Enter the passenger information</p>
    <div class="form-floating mb-3 my-4">
      <input type="text" class="form-control" id="InputFrom" name="firstName">
      <label for="InputFrom" class="form-label form-inline">First Name</label>
    </div>
    <div class="form-floating mb-3 my-4">
      <input type="text" class="form-control" id="InputDestination" name="lastName">
      <label for="InputDestination" class="form-label">Last Name</label>
    </div>
    <div>
      <h6 class="gender">Gender :</h6>
    </div>
    <div class="form-check">
      <input class="form-check-input" value="MALE" type="radio" name="gender" id="flexRadioDefault1" checked>
      <label class="form-check-label" for="flexRadioDefault1">
        Male
      </label>
    </div>
    <div class="form-check">
      <input class="form-check-input" value="FEMALE" type="radio" name="gender" id="flexRadioDefault2">
      <label class="form-check-label" for="flexRadioDefault2">
        Female
      </label>
    </div>
    <div class = "d-grid"></div>
    <button type="submit" class="btn btn-primary px-4">Submit</button>
  </form>

</div>

<script>
  function validateForm() {
    var firstName = document.forms["myForm"]["firstName"].value;
    var lastName = document.forms["myForm"]["lastName"].value;

    if (firstName == "") {
      alert("First Name must be filled out");
      return false;
    }
    if (lastName == "") {
      alert("Last Name must be filled out");
      return false;
    }
  }
</script>

</body>
</html>
