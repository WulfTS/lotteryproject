package cpt200h190.lotteryproject.prize.controller;

import cpt200h190.lotteryproject.drawing.delegate.DrawingDelegate;
import cpt200h190.lotteryproject.person.delegate.PersonDelegate;
import cpt200h190.lotteryproject.prize.delegate.PrizeDelegate;
import cpt200h190.lotteryproject.prize.dto.PrizeDTO;
import cpt200h190.lotteryproject.ticket.delegate.TicketDelegate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class PrizeController {
    private final DrawingDelegate drawingDelegate;
    private final TicketDelegate ticketDelegate;
    private final PersonDelegate personDelegate;
    private final PrizeDelegate prizeDelegate;

    @GetMapping("/prizes")
    public String drawingHomepage(){
        return "/prize/prizeHome";
    }

    @GetMapping("prizes/all")
    public String displayAllPrizes(Model model){
        List<PrizeDTO> prizeList = prizeDelegate.getAllPrizes();
        model.addAttribute("prizeList", prizeList);
        model.addAttribute("drawingDelegate",drawingDelegate);
        return "prize/displayPrizeList";}

}
