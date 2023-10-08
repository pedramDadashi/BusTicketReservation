package org.example.service.impl;

import org.example.base.service.impl.BaseEntityServiceImpl;
import org.example.entity.Travel;
import org.example.repository.TravelRepository;
import org.example.repository.impl.TravelRepositoryImpl;
import org.example.service.TravelService;
import org.example.util.HibernateUtil;

import java.time.LocalDate;
import java.util.List;

public class TravelServiceImpl extends BaseEntityServiceImpl<Travel, Long, TravelRepository> implements TravelService {

    TravelRepository travelRepository = new TravelRepositoryImpl(HibernateUtil.getEntityMangerFactory().createEntityManager());

    public TravelServiceImpl(TravelRepository repository) {
        super(repository);
    }


    @Override
    public List<Travel> findTravel(String source, String destination) {
        return travelRepository.findTravel(source, destination);
    }

    @Override
    public List<Travel> findTravel(String source, String destination, LocalDate date) {
        return travelRepository.findTravel(source, destination, date);
    }
}
