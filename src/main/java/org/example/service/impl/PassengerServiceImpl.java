package org.example.service.impl;

import org.example.base.service.impl.BaseEntityServiceImpl;
import org.example.command.PassengerSignUpCommand;
import org.example.converter.PassengerSignupCommandToPersonConverter;
import org.example.entity.Passenger;
import org.example.repository.PassengerRepository;
import org.example.repository.impl.PassengerRepositoryImpl;
import org.example.service.PassengerService;
import org.example.util.HibernateUtil;

import java.util.Optional;

public class PassengerServiceImpl extends BaseEntityServiceImpl<Passenger, Long, PassengerRepository> implements PassengerService {

    private final PassengerRepository passengerRepository = new PassengerRepositoryImpl(HibernateUtil.getEntityMangerFactory().createEntityManager());

    public PassengerServiceImpl(PassengerRepository repository) {
        super(repository);
    }

    @Override
    public Optional<Passenger> findByUsername(String username) {
        try{
            return passengerRepository.findByUsername(username);
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public Optional<Passenger> findByUsernameAndPassword(String username, String password) {
        try{
            return passengerRepository.findByUsernameAndPassword(username, password);
        }catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public void passengerSignUp(PassengerSignUpCommand passengerSignUpCommand) {
        PassengerSignupCommandToPersonConverter passengerSignupCommandToPersonConverter = new PassengerSignupCommandToPersonConverter();
        Passenger passenger = passengerSignupCommandToPersonConverter.convert(passengerSignUpCommand);
        passengerRepository.save(passenger);
    }
}
