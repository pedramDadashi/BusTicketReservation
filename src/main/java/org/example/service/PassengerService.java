package org.example.service;

import org.example.base.service.BaseEntityService;
import org.example.command.PassengerSignUpCommand;
import org.example.entity.Passenger;

import java.util.Optional;

public interface PassengerService extends BaseEntityService<Passenger, Long> {

    @Override
    Optional<Passenger> findById(Long aLong);

    Optional<Passenger> findByUsername(String username);

    Optional<Passenger> findByUsernameAndPassword(String username, String password);

    void passengerSignUp(PassengerSignUpCommand passengerSignUpCommand);
}
