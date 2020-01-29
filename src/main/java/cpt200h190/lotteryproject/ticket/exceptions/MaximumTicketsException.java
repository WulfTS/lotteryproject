package cpt200h190.lotteryproject.ticket.exceptions;

import java.util.UUID;

public class MaximumTicketsException extends RuntimeException {
    public MaximumTicketsException(String id) {super("No more tickets can be allocated for drawing: " + id);}
}
