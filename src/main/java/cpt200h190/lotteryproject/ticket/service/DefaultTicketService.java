package cpt200h190.lotteryproject.ticket.service;

import cpt200h190.lotteryproject.drawing.entity.Drawing;
import cpt200h190.lotteryproject.drawing.service.DrawingService;
import cpt200h190.lotteryproject.humanreadableidgenerator.HumanReadableIdGenerator;
import cpt200h190.lotteryproject.ticket.entity.Ticket;
import cpt200h190.lotteryproject.ticket.exceptions.MaximumTicketsException;
import cpt200h190.lotteryproject.ticket.exceptions.TicketNotFoundException;
import cpt200h190.lotteryproject.ticket.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class DefaultTicketService implements TicketService {
    private final TicketRepository ticketRepository;
    private final DrawingService drawingService;

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket addTicket(Ticket ticketToAdd) {
        Drawing drawing = drawingService.findDrawingById(ticketToAdd.getDrawingId());
        if(ticketRepository.findTicketByDrawingId(ticketToAdd.getDrawingId()).size() >= drawing.getMaxTickets()){
            throw new MaximumTicketsException(drawing.getHumanReadableId() + " " + drawing.getName());
        }
        ticketToAdd.setHumanReadableId(HumanReadableIdGenerator.GenerateTicketValue(ticketToAdd.getColor()));
        return ticketRepository.save(ticketToAdd);
    }

    @Override
    public Ticket editTicket(Ticket ticketUpdates) {
        if(idIsPresent(ticketUpdates.getId()).equals(Boolean.FALSE)){
            throw new TicketNotFoundException(ticketUpdates.getId());
        }

        Ticket existingTicket = findTicketById(ticketUpdates.getId());
        if(ticketUpdates.getDrawingId() == null){
            ticketUpdates.setDrawingId(existingTicket.getDrawingId());
        }

        if(ticketUpdates.getPersonId() == null){
            ticketUpdates.setPersonId(existingTicket.getPersonId());
        }
        ticketUpdates.setHumanReadableId(existingTicket.getHumanReadableId());

        return ticketRepository.save(ticketUpdates);
    }

    @Override
    public Ticket findTicketById(UUID id) {
       return ticketRepository.findById(id).orElse(new Ticket());
    }

    @Override
    public List<Ticket> findTicketsByDrawingId(UUID drawingId) {
        return ticketRepository.findTicketByDrawingId(drawingId);
    }

    @Override
    public List<Ticket> findTicketByPersonId(UUID personId) {
        return ticketRepository.findTicketByPersonId(personId);
    }


    private Boolean idIsPresent(UUID id){
        Optional<Ticket> one = ticketRepository.findById(id);

        if(one.isPresent()){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
