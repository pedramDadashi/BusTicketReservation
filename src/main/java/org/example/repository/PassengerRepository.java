package org.example.repository;

import org.example.base.repository.BaseEntityRepository;
import org.example.entity.Passenger;

import java.util.Optional;

public interface PassengerRepository extends BaseEntityRepository<Passenger, Long> {
    @Override
    Optional<Passenger> findById(Long aLong);

    Optional<Passenger> findByUsername(String username);

    Optional<Passenger> findByUsernameAndPassword(String username, String password);
}
