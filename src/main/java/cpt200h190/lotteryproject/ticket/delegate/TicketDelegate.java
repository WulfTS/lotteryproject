package cpt200h190.lotteryproject.ticket.delegate;

import cpt200h190.lotteryproject.ticket.dto.TicketDTO;

import java.util.List;
import java.util.UUID;

public interface TicketDelegate {

    List<TicketDTO> getAllTickets();

    TicketDTO addTicket(TicketDTO ticketToAdd);

    TicketDTO editTicket(TicketDTO ticketUpdates);

    TicketDTO findTicketById(UUID id);

    List<TicketDTO> findTicketsByDrawingId(UUID drawingId);

    List<TicketDTO> findTicketByPersonId(UUID personId);

    void deactivateTicket(UUID ticketId);

    List<TicketDTO> findTicketByDrawingIdAndIsActive(UUID drawingId, Boolean isActive);

    List<TicketDTO> findTicketsByIsActive(Boolean isActive);

}
