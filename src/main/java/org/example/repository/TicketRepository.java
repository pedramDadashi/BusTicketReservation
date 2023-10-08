package org.example.repository;

import org.example.base.repository.BaseEntityRepository;
import org.example.entity.Ticket;

import java.util.List;

public interface TicketRepository extends BaseEntityRepository<Ticket, Long> {

    List<Ticket> findAllTicketsByUsername(String username);
}
