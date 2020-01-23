package cpt200h190.lotteryproject.ticket.controller;

import cpt200h190.lotteryproject.drawing.controller.DefaultDrawingController;
import cpt200h190.lotteryproject.drawing.dto.DrawingDTO;
import cpt200h190.lotteryproject.person.controller.DefaultPersonController;
import cpt200h190.lotteryproject.ticket.delegate.TicketDelegate;
import cpt200h190.lotteryproject.ticket.dto.TicketDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class DefaultTicketController {
    private final TicketDelegate ticketDelegate;
    private final DefaultDrawingController defaultDrawingController;
    private final DefaultPersonController defaultPersonController;

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
        model.addAttribute("drawingController", defaultDrawingController);
        model.addAttribute("personController", defaultPersonController);
        return "/ticket/displayTicketList";
    }

    // display individual ticket
    @GetMapping(value = "tickets/{id}")
    public String displayTicket(@PathVariable Long id, Model model){
        String personName;
        TicketDTO ticket = ticketDelegate.findTicketById(id);
        String drawingName = defaultDrawingController.getDrawingById(ticket.getDrawingId()).getName();
        if(ticket.getPersonId() == null){
            personName = "";
        } else {
            personName = defaultPersonController.getPersonById(ticket.getPersonId()).getFirstName() + " " +
                    defaultPersonController.getPersonById(ticket.getPersonId()).getLastName();
        }
        model.addAttribute("ticket",ticket);
        model.addAttribute("drawingName",drawingName);
        model.addAttribute("personName", personName);
        return "/ticket/displayTicket";
    }

    // display new ticket form
    @GetMapping(value = "tickets/add")
    public String displayTicketForm(Model model){
        List<DrawingDTO> drawingList = defaultDrawingController.getAllDrawings();
        model.addAttribute("drawingList",drawingList);
        model.addAttribute("peopleList", defaultPersonController.getAllPeople());
        return "/ticket/ticketForm";
    }

   @PostMapping(value = "/tickets/add")
   public String addTicket(@ModelAttribute("ticket") TicketDTO ticketDTO, Model model){
        TicketDTO result = ticketDelegate.addTicket(ticketDTO);
        model.addAttribute("ticket",result);

       String drawingName = defaultDrawingController.getDrawingById(ticketDTO.getDrawingId()).getName();

       String personName;
       if(ticketDTO.getPersonId() == null){
           personName = "";
       } else {
           personName = defaultPersonController.getPersonById(ticketDTO.getPersonId()).getFirstName() + " " +
                   defaultPersonController.getPersonById(ticketDTO.getPersonId()).getLastName();
       }

       model.addAttribute("drawingName",drawingName);
       model.addAttribute("personName", personName);

       return "/ticket/displayTicket";
    }

}
