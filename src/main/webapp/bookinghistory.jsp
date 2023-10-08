<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 7/19/2023
  Time: 11:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.entity.Travel" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>
<%@ page import="org.example.entity.Ticket" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 7/19/2023
  Time: 12:07 AM
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
    <title>Search Page</title>
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
        width: 70%;
        height: 80%;
        margin-left: 15%;
        margin-top: 5%;
        border-radius: 10px;
        padding-top: 2%;
        padding-left: 5%;
    }

    .mb-3 {
        width: 80%;
        text-align: right;
        margin-left: 10%;
        margin-top: 5%;
    }

    .btn {
        margin-left: 10%;
        margin-top: 5%;
        width: 80%;
        height: 10%;
    }

    .text {
        font-size: 90%;
        text-align: center;
        margin-bottom: 8%;
        margin-top: 5%;
    }

    .title {
        font-size: 120%;
        text-align: center;
    }

    table {
        width: 90%;
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
    <form action="bookinghistoryservlet" method="get">
        <%
            HttpSession session1 = request.getSession();
            List<Ticket> tickets = new ArrayList<>((Collection<Ticket>) session1.getAttribute("tickets"));
        %>
        <table>
            <tr>
                <th style="font-family: sans-serif"> tickets booked by  <%=
                tickets.get(0).getPassenger().getUsername()
                %>
                </th>
                <th>
                </th>
                <th>
                </th>
                <th>
                </th>
            </tr>
            <tr>
                <td>first name</td>
                <td>last name</td>
                <td>gender</td>
                <td>ticket ID</td>
                <td>travel ID</td>
            </tr>
            <%for (int i = 0; i < tickets.size(); i++) {%>
            <tr>
                <td>
                    <%=tickets.get(i).getFirstName()%>
                </td>
                <td>
                    <%=tickets.get(i).getLastName()%>
                </td>
                <td>
                    <%=tickets.get(i).getPassengerGender()%>
                </td>
                <td>
                    <%=tickets.get(i).getId()%>
                </td>
                <td>
                    <%=
                    tickets.get(i).getTravel().getId()
                    %>
                </td>
            </tr>
            <%}%>

        </table>
    </form>

</div>
</body>
</html>
