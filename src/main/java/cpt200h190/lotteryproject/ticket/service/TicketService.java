package cpt200h190.lotteryproject.ticket.service;

import cpt200h190.lotteryproject.ticket.entity.Ticket;

import java.util.List;
import java.util.UUID;

public interface TicketService {
    List<Ticket> getAllTickets();

    Ticket addTicket(Ticket ticketToAdd);

    Ticket editTicket(Ticket ticketUpdates);

    Ticket findTicketById(UUID id);

    List<Ticket> findTicketsByDrawingId(UUID drawingId);

    List<Ticket> findTicketByPersonId(UUID personId);

}
