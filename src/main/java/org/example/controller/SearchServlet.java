package org.example.controller;

import org.example.entity.Travel;
import org.example.repository.impl.TravelRepositoryImpl;
import org.example.service.TravelService;
import org.example.service.impl.TravelServiceImpl;
import org.example.util.HibernateUtil;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class SearchServlet extends HttpServlet {

    TravelService travelService = new TravelServiceImpl(new TravelRepositoryImpl(HibernateUtil.getEntityMangerFactory().createEntityManager()));

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String source = req.getParameter("source");
        String destination = req.getParameter("destination");
        LocalDate localDate = LocalDate.parse(req.getParameter("date"));
        try {
            List<Travel> travels = travelService.findTravel(source, destination, localDate);
            if (travels.size() != 0){
                req.getSession().setAttribute("travels", travels);
                resp.sendRedirect("chooseticket.jsp");
            }else {
                resp.sendRedirect("noresult.jsp");
            }
        } catch (NoResultException NRE) {
            NRE.printStackTrace();
        }


    }
}
