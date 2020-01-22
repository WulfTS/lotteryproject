package cpt200h190.lotteryproject.ticket.repository;

import cpt200h190.lotteryproject.ticket.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
