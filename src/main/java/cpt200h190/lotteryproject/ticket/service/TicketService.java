package cpt200h190.lotteryproject.ticket.service;

import cpt200h190.lotteryproject.ticket.entity.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> getAllTickets();

    Ticket addTicket(Ticket ticketToAdd);

    Ticket editTicket(Ticket ticketUpdates);

    Ticket findTicketById(Long id);


}
