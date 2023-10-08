package org.example.repository.impl;

import org.example.base.repository.impl.BaseEntityRepositoryImpl;
import org.example.entity.Ticket;
import org.example.repository.TicketRepository;
import org.example.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class TicketRepositoryImpl extends BaseEntityRepositoryImpl<Ticket, Long> implements TicketRepository {

    private final EntityManager em;

    public TicketRepositoryImpl(EntityManager em) {
        super(em);
        this.em = em;
    }

    @Override
    public Class<Ticket> getEntityClass() {
        return Ticket.class;
    }

    @Override
    public List<Ticket> findAllTicketsByUsername(String username) {
        String jql = "select t from Ticket t where t.passenger.username = :username";
        return HibernateUtil.getEntityMangerFactory().createEntityManager().createQuery(jql, Ticket.class)
                .setParameter("username", username).getResultList();
    }
}
