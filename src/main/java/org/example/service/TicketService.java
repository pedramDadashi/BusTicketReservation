package org.example.service;

import org.example.base.service.BaseEntityService;
import org.example.entity.Ticket;

import java.util.List;

public interface TicketService extends BaseEntityService<Ticket, Long> {
    List<Ticket> findAllTicketsByUsername(String username);
}
