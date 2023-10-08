package org.example.repository.impl;

import org.example.base.repository.impl.BaseEntityRepositoryImpl;
import org.example.entity.Passenger;
import org.example.repository.PassengerRepository;
import org.example.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.Optional;

public class PassengerRepositoryImpl extends BaseEntityRepositoryImpl<Passenger, Long> implements PassengerRepository{

    private final EntityManager em;

    public PassengerRepositoryImpl(EntityManager em) {
        super(em);
        this.em = em;
    }

    @Override
    public Class<Passenger> getEntityClass() {
        return Passenger.class;
    }

    @Override
    public Optional<Passenger> findByUsername(String username) {
        String jql = "select p from Passenger p  where p.username = :username";
        return Optional.ofNullable(HibernateUtil.getEntityMangerFactory().createEntityManager()
                .createQuery(jql, Passenger.class).setParameter("username", username).getSingleResult());
    }

    @Override
    public Optional<Passenger> findByUsernameAndPassword(String username, String password) {
        String jql = "select p from Passenger p where p.username = :username and p.password = :password";
        return Optional.ofNullable(HibernateUtil.getEntityMangerFactory().createEntityManager()
                .createQuery(jql, Passenger.class)
                .setParameter("username",username).setParameter("password",password)
                .getSingleResult());
    }
}
