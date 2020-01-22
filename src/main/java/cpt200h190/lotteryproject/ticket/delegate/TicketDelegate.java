package cpt200h190.lotteryproject.ticket.delegate;

import cpt200h190.lotteryproject.ticket.dto.TicketDTO;

import java.util.List;

public interface TicketDelegate {

    List<TicketDTO> getAllTickets();

    TicketDTO addTicket(TicketDTO ticketToAdd);

    TicketDTO editTicket(TicketDTO ticketUpdates);

    TicketDTO findTicketById(Long id);
}
