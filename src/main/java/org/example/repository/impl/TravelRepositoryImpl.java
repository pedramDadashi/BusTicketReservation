package org.example.repository.impl;

import org.example.base.repository.impl.BaseEntityRepositoryImpl;
import org.example.entity.Travel;
import org.example.repository.TravelRepository;
import org.example.util.HibernateUtil;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class TravelRepositoryImpl extends BaseEntityRepositoryImpl<Travel, Long> implements TravelRepository {

    private final EntityManager em;

    public TravelRepositoryImpl(EntityManager em) {
        super(em);
        this.em = em;
    }

    @Override
    public Class<Travel> getEntityClass() {
        return Travel.class;
    }

    @Override
    public List<Travel> findTravel(String source, String destination) {
        String jql = "select t from Travel t where t.source = :source and t.destination = :destination";
        return HibernateUtil.getEntityMangerFactory().createEntityManager().createQuery(jql, Travel.class)
                .setParameter("source", source).setParameter("destination",destination)
                .getResultList();
    }

    @Override
    public List<Travel> findTravel(String source, String destination, LocalDate date) {
        String jql = "select t from Travel t where t.source = :source and t.destination = :destination and t.startDate = :date";
        return HibernateUtil.getEntityMangerFactory().createEntityManager().createQuery(jql, Travel.class)
                .setParameter("source", source).setParameter("destination",destination).setParameter("date", date)
                .getResultList();
    }
}
