package org.example.service.impl;

import org.example.base.service.impl.BaseEntityServiceImpl;
import org.example.entity.Ticket;
import org.example.repository.TicketRepository;
import org.example.repository.impl.TicketRepositoryImpl;
import org.example.service.TicketService;
import org.example.util.HibernateUtil;

import java.util.List;

public class TicketServiceImpl extends BaseEntityServiceImpl<Ticket, Long, TicketRepository> implements TicketService {

    TicketRepository ticketRepository = new TicketRepositoryImpl(HibernateUtil.getEntityMangerFactory().createEntityManager());

    public TicketServiceImpl(TicketRepository repository) {
        super(repository);
    }

    @Override
    public List<Ticket> findAllTicketsByUsername(String username) {
        return ticketRepository.findAllTicketsByUsername(username);
    }
}
