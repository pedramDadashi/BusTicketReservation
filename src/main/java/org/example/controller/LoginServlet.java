package org.example.controller;

import org.example.entity.Passenger;
import org.example.repository.impl.PassengerRepositoryImpl;
import org.example.security.PasswordHash;
import org.example.service.PassengerService;
import org.example.service.impl.PassengerServiceImpl;
import org.example.util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

public class LoginServlet extends HttpServlet {

    PasswordHash passwordHash = new PasswordHash();
    PassengerService passengerService = new PassengerServiceImpl(new PassengerRepositoryImpl(HibernateUtil.getEntityMangerFactory().createEntityManager()));

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String hashedPassword = null;
        try {
            hashedPassword = passwordHash.createHashedPassword(req.getParameter("password"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        if (passengerService.findByUsernameAndPassword(username,hashedPassword).isPresent()) {
            Optional<Passenger> passenger = passengerService.findByUsernameAndPassword(username,hashedPassword);
            req.getSession().setAttribute("username", username);
            req.getSession().setAttribute("firstname", passenger.get().getFirstName());
            req.getSession().setAttribute("lastname", passenger.get().getLastName());
            System.out.println("find the user successfully");
            resp.sendRedirect("home.jsp");
        }
    }
}
