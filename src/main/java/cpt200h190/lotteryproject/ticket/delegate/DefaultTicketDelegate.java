package cpt200h190.lotteryproject.ticket.delegate;

import cpt200h190.lotteryproject.ticket.dto.TicketDTO;
import cpt200h190.lotteryproject.ticket.entity.Ticket;
import cpt200h190.lotteryproject.ticket.mapper.TicketMapper;
import cpt200h190.lotteryproject.ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class DefaultTicketDelegate implements TicketDelegate {
    private final TicketService ticketService;
    private final TicketMapper ticketMapper;

    @Override
    public List<TicketDTO> getAllTickets() {
        return ticketService.getAllTickets().stream()
                .map(ticketMapper::mapTicketToTicketDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TicketDTO addTicket(TicketDTO ticketToAdd) {
        Ticket ticket = ticketMapper.mapTicketDTOtoTicket(ticketToAdd);
        return ticketMapper.mapTicketToTicketDTO(
                ticketService.addTicket(ticket));
    }

    @Override
    public TicketDTO editTicket(TicketDTO ticketUpdates) {
        Ticket ticket = ticketMapper.mapTicketDTOtoTicket(ticketUpdates);
        return ticketMapper.mapTicketToTicketDTO(
                ticketService.editTicket(ticket));
    }

    @Override
    public TicketDTO findTicketById(UUID id) {
        Ticket ticket = ticketService.findTicketById(id);
        return ticketMapper.mapTicketToTicketDTO(ticket);
    }

    @Override
    public List<TicketDTO> findTicketsByDrawingId(UUID drawingId) {
        return ticketService.findTicketsByDrawingId(drawingId).stream()
                .map(ticketMapper::mapTicketToTicketDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TicketDTO> findTicketByPersonId(UUID personId) {
        return ticketService.findTicketByPersonId(personId).stream()
                .map(ticketMapper::mapTicketToTicketDTO)
                .collect(Collectors.toList());
    }


}
