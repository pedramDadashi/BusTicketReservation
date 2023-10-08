package org.example.controller;

import org.example.entity.Passenger;
import org.example.entity.Ticket;
import org.example.entity.Travel;
import org.example.entity.enums.Gender;
import org.example.repository.impl.PassengerRepositoryImpl;
import org.example.repository.impl.TicketRepositoryImpl;
import org.example.service.PassengerService;
import org.example.service.TicketService;
import org.example.service.impl.PassengerServiceImpl;
import org.example.service.impl.TicketServiceImpl;
import org.example.util.HibernateUtil;
import org.hibernate.Hibernate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PassengerInfoServlet extends HttpServlet {

    PassengerService passengerService = new PassengerServiceImpl(new PassengerRepositoryImpl(HibernateUtil.getEntityMangerFactory().createEntityManager()));
    TicketService ticketService = new TicketServiceImpl(new TicketRepositoryImpl(HibernateUtil.getEntityMangerFactory().createEntityManager()));

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        Gender gender = Gender.valueOf(req.getParameter("gender"));
        Ticket ticket = new Ticket();
        ticket.setFirstName(firstName);
        ticket.setLastName(lastName);
        ticket.setPassengerGender(gender);
        List<Travel> travels = new ArrayList<>((Collection<Travel>) req.getSession().getAttribute("travels"));
        String buy = (String) req.getSession().getAttribute("buy");
        int index = Integer.parseInt(buy);
        ticket.setPassenger(passengerService.findByUsername((String) req.getSession().getAttribute("username")).get());
        ticket.setTravel(travels.get(index));
        ticketService.save(ticket);
        resp.sendRedirect("successmessage.jsp");
    }
}
