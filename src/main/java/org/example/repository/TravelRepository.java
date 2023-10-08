package org.example.repository;

import org.example.base.repository.BaseEntityRepository;
import org.example.entity.Travel;

import java.time.LocalDate;
import java.util.List;

public interface TravelRepository extends BaseEntityRepository<Travel, Long> {

    List<Travel> findTravel(String source, String destination);

    List<Travel> findTravel(String source, String destination, LocalDate date);



}
