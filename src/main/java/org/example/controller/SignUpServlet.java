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
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class SignUpServlet extends HttpServlet {

    PassengerService passengerService = new PassengerServiceImpl(new PassengerRepositoryImpl(HibernateUtil.getEntityMangerFactory().createEntityManager()));

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Passenger passenger = new Passenger();
        PasswordHash passwordHash = new PasswordHash();
        try {
            String hashedPassword = passwordHash.createHashedPassword(password);
            passenger.setFirstName(firstName);
            passenger.setLastName(lastName);
            passenger.setUsername(username);
            passenger.setPassword(hashedPassword);
            passengerService.save(passenger);
            resp.sendRedirect("search.jsp");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

//        try{
//            PassengerSignUpCommand passengerSignUpCommand = new PassengerSignUpCommand();
//            passengerSignUpCommand.setFirstName(firstName);
//            passengerSignUpCommand.setLastName(lastName);
//            passengerSignUpCommand.setUsername(username);
//            passengerSignUpCommand.setPassword(password);
//            passengerService.passengerSignUp(passengerSignUpCommand);
//        }catch (Exception e){
//            throw new RuntimeException(e);
//        }

    }
}
