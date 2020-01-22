package cpt200h190.lotteryproject.ticket.service;

import cpt200h190.lotteryproject.ticket.entity.Ticket;
import cpt200h190.lotteryproject.ticket.exceptions.TicketNotFoundException;
import cpt200h190.lotteryproject.ticket.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class DefaultTicketService implements TicketService {
    private final TicketRepository ticketRepository;

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket addTicket(Ticket ticketToAdd) {
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

        return ticketRepository.save(ticketUpdates);
    }

    @Override
    public Ticket findTicketById(Long id) {
        return ticketRepository.findById(id).orElse(new Ticket());
    }

    private Boolean idIsPresent(Long id){
        Optional<Ticket> one = ticketRepository.findById(id);

        if(one.isPresent()){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
