package org.example.service;

import org.example.base.service.BaseEntityService;
import org.example.entity.Travel;

import java.time.LocalDate;
import java.util.List;

public interface TravelService extends BaseEntityService<Travel, Long> {

    List<Travel> findTravel(String source, String destination);

    List<Travel> findTravel(String source, String destination, LocalDate date);

}
