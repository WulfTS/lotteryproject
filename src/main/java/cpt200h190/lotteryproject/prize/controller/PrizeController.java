package cpt200h190.lotteryproject.prize.controller;

import cpt200h190.lotteryproject.drawing.delegate.DrawingDelegate;
import cpt200h190.lotteryproject.person.delegate.PersonDelegate;
import cpt200h190.lotteryproject.ticket.delegate.TicketDelegate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class PrizeController {
    private final DrawingDelegate drawingDelegate;
    private final TicketDelegate ticketDelegate;
    private final PersonDelegate personDelegate;

    @GetMapping("/prizes")
    public String drawingHomepage(){
        return "/prize/prizeHome";
    }

}
