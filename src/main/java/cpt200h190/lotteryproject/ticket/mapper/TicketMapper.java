package cpt200h190.lotteryproject.ticket.mapper;

import cpt200h190.lotteryproject.ticket.dto.TicketDTO;
import cpt200h190.lotteryproject.ticket.entity.Ticket;

public interface TicketMapper {

    Ticket mapTicketDTOtoTicket(TicketDTO ticketDTO);

    TicketDTO mapTicketToTicketDTO(Ticket ticket);

}
