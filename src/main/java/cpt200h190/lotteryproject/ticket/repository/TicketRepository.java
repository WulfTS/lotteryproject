package cpt200h190.lotteryproject.ticket.repository;

import cpt200h190.lotteryproject.ticket.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {
    List<Ticket> findTicketByDrawingId(UUID drawingId);
    List<Ticket> findTicketByPersonId(UUID personId);

}
