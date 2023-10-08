package org.example.converter;

import org.example.command.PassengerSignUpCommand;
import org.example.entity.Passenger;

public class PassengerSignupCommandToPersonConverter implements BaseConverter<PassengerSignUpCommand, Passenger> {
    @Override
    public Passenger convert(PassengerSignUpCommand passengerSignUpCommand) {
        Passenger passenger = new Passenger();
        passenger.setFirstName(passengerSignUpCommand.getFirstName());
        passenger.setLastName(passengerSignUpCommand.getLastName());
        passenger.setUsername(passengerSignUpCommand.getUsername());
        passenger.setPassword(passengerSignUpCommand.getPassword());
        return passenger;
    }
}
