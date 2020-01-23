package cpt200h190.lotteryproject.ticket.repository;

import cpt200h190.lotteryproject.ticket.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findTicketByDrawingId(Long drawingId);
    List<Ticket> findTicketByPersonId(Long personId);
}
