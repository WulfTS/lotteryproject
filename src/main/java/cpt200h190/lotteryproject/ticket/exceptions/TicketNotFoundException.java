package cpt200h190.lotteryproject.ticket.exceptions;

public class TicketNotFoundException extends RuntimeException {
    public TicketNotFoundException(Long id){
        super("Could not find ticket id: " + id);
    }
}
