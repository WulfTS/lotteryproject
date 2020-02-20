package cpt200h190.lotteryproject.ticket.mapper;

import cpt200h190.lotteryproject.ticket.dto.TicketDTO;
import cpt200h190.lotteryproject.ticket.entity.Ticket;
import org.springframework.stereotype.Service;

@Service
public class DefaultTicketMapper implements TicketMapper {
    @Override
    public Ticket mapTicketDTOtoTicket(TicketDTO ticketDTO) {
        return Ticket.builder()
                .id(ticketDTO.getId())
                .drawingId(ticketDTO.getDrawingId())
                .personId(ticketDTO.getPersonId())
                .humanReadableId(ticketDTO.getHumanReadableId())
                .isActive(ticketDTO.getIsActive())
                .isWinner(ticketDTO.getIsWinner())
                .build();
    }

    @Override
    public TicketDTO mapTicketToTicketDTO(Ticket ticket) {
        return TicketDTO.builder()
                .id(ticket.getId())
                .drawingId(ticket.getDrawingId())
                .personId(ticket.getPersonId())
                .humanReadableId(ticket.getHumanReadableId())
                .isActive(ticket.getIsActive())
                .isWinner(ticket.getIsWinner())
                .build();
    }
}
