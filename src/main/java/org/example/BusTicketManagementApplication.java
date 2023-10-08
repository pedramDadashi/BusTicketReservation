package org.example;

import org.example.entity.Passenger;
import org.example.entity.Ticket;
import org.example.entity.Travel;
import org.example.entity.enums.Gender;
import org.example.repository.impl.PassengerRepositoryImpl;
import org.example.repository.impl.TicketRepositoryImpl;
import org.example.repository.impl.TravelRepositoryImpl;
import org.example.security.PasswordHash;
import org.example.service.PassengerService;
import org.example.service.TicketService;
import org.example.service.TravelService;
import org.example.service.impl.PassengerServiceImpl;
import org.example.service.impl.TicketServiceImpl;
import org.example.service.impl.TravelServiceImpl;
import org.example.util.HibernateUtil;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

public class BusTicketManagementApplication {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        TravelService travelService = new TravelServiceImpl(new TravelRepositoryImpl(HibernateUtil.getEntityMangerFactory().createEntityManager()));
        PassengerService passengerService = new PassengerServiceImpl(new PassengerRepositoryImpl(HibernateUtil.getEntityMangerFactory().createEntityManager()));
        TicketService ticketService = new TicketServiceImpl(new TicketRepositoryImpl(HibernateUtil.getEntityMangerFactory().createEntityManager()));

        Passenger passenger = new Passenger();
        passenger.setFirstName("ali");
        passenger.setLastName("bondar");


        Travel tehranToMashhad = new Travel();
        Travel tehranToMashhad2 = new Travel();
        Travel tehranToGhazvin = new Travel();
        tehranToMashhad.setSource("tehran");
        tehranToMashhad.setDestination("mashhad");
        tehranToMashhad.setStartDate(LocalDate.of(2023, 4, 12));
        tehranToMashhad2.setSource("tehran");
        tehranToMashhad2.setDestination("mashhad");
        tehranToMashhad2.setStartDate(LocalDate.of(2023, 4, 15));
        tehranToGhazvin.setSource("tehran");
        tehranToGhazvin.setDestination("ghazvin");
        tehranToGhazvin.setStartDate(LocalDate.of(2023, 5, 13));


//        travelService.save(tehranToMashhad);
//        travelService.save(tehranToMashhad2);
//        travelService.save(tehranToGhazvin);
//        passengerService.save(passenger);
        PasswordHash passwordHash = new PasswordHash();
        System.out.println("+++++++++++++++++++++++++++++");
//        System.out.println(travelService.findTravel("tehran", "mashhad"));
//        System.out.println(travelService.findTravel("tehran", "mashhad", LocalDate.of(2023, 4, 15)));
//        System.out.println(passengerService.findByUsernameAndPassword("asgh", passwordHash.createHashedPassword("1")));
//        System.out.println(ticketService.findAllTicketsByUsername("alibon"));
    }
}
