package org.example.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ChooseTicketServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String buy = req.getParameter("buy");
        HttpSession session = req.getSession();
        session.setAttribute("buy",buy);
        resp.sendRedirect("http://localhost:8085/BusTravelManagement_war_exploded/passengerinfo.jsp");
    }
}
