package cpt200h190.lotteryproject.ticket.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import cpt200h190.lotteryproject.ticket.delegate.TicketDelegate;
import cpt200h190.lotteryproject.ticket.dto.TicketDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class TicketController {
    private final TicketDelegate ticketDelegate;

    // display ticket homepage
    @GetMapping(value = "/tickets")
    public String ticketHomepage(){
        return "/ticket/ticketHome";
    }

    // display all tickets
    @GetMapping(value = "/tickets/all")
    public String displayTickets(Model model){
        List<TicketDTO> ticketList = ticketDelegate.getAllTickets();
        model.addAttribute("ticketList", ticketList);
        return "/ticket/displayTicketList";
    }

    // display individual ticket
    @GetMapping(value = "tickets/{id}")
    public String displayTicket(@PathVariable Long id, Model model){
        TicketDTO ticket = ticketDelegate.findTicketById(id);
        model.addAttribute("ticket",ticket);
        return "/ticket/displayTicket";
    }

    // display new ticket form
    @GetMapping(value = "tickets/add")
    public String addTicket(){
        return "/ticket/ticketForm";
    }

}
