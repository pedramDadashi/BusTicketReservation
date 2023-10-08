package org.example.controller;

import org.example.entity.Ticket;
import org.example.entity.Travel;
import org.example.repository.impl.TicketRepositoryImpl;
import org.example.service.TicketService;
import org.example.service.impl.TicketServiceImpl;
import org.example.util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookingHistoryServlet extends HttpServlet {

    TicketService ticketService = new TicketServiceImpl(new TicketRepositoryImpl(HibernateUtil.getEntityMangerFactory().createEntityManager()));

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getSession().getAttribute("username");
//        Travel travel = (Travel) req.getSession().getAttribute("travel");
        System.out.println(username);
//        System.out.println(travel.getId());
        List<Ticket> tickets = ticketService.findAllTicketsByUsername(username);
        if (tickets.size() != 0){
            req.getSession().setAttribute("tickets", tickets);
            resp.sendRedirect("bookinghistory.jsp");
        }else {
            resp.sendRedirect("noresult.jsp");
        }
    }
}
