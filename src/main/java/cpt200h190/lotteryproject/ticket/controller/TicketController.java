package cpt200h190.lotteryproject.ticket.controller;

import cpt200h190.lotteryproject.drawing.delegate.DrawingDelegate;
import cpt200h190.lotteryproject.drawing.dto.DrawingDTO;
import cpt200h190.lotteryproject.person.delegate.PersonDelegate;
import cpt200h190.lotteryproject.ticket.delegate.TicketDelegate;
import cpt200h190.lotteryproject.ticket.dto.TicketDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class TicketController {
    private final TicketDelegate ticketDelegate;
    private final DrawingDelegate drawingDelegate;
    private final PersonDelegate personDelegate;

    // display ticket homepage
    @GetMapping(value = "/tickets")
    public String ticketHomepage() {
        return "/ticket/ticketHome";
    }

    // display all tickets
    @GetMapping(value = "/tickets/all")
    public String displayTickets(Model model) {
        List<TicketDTO> ticketList = ticketDelegate.getAllTickets();
        model.addAttribute("ticketList", ticketList);
        model.addAttribute("drawingDelegate", drawingDelegate);
        model.addAttribute("personDelegate", personDelegate);
        return "/ticket/displayTicketList";
    }

    // display individual ticket
    @GetMapping(value = "tickets/{id}")
    public String displayTicket(@PathVariable UUID id, Model model) {
        String personName;
        TicketDTO ticket = ticketDelegate.findTicketById(id);
        String drawingName = drawingDelegate.findDrawingById(ticket.getDrawingId()).getName();

        if (ticket.getPersonId() == null) {
            personName = "";
        } else {
            personName = personDelegate.findPersonById(ticket.getPersonId()).getFirstName() + " " +
                    personDelegate.findPersonById(ticket.getPersonId()).getLastName();
        }
        model.addAttribute("ticket", ticket);
        model.addAttribute("drawingName", drawingName);
        model.addAttribute("personName", personName);
        model.addAttribute("personDelegate", personDelegate);
        model.addAttribute("drawingDelegate", drawingDelegate);

        model.addAttribute("ticketList", ticketDelegate.getAllTickets());

        return "/ticket/displayTicket";
    }

    // display new ticket form
    @GetMapping(value = "tickets/add")
    public String displayTicketForm(Model model) {
        List<DrawingDTO> drawingList = drawingDelegate.findActiveDrawings();
        model.addAttribute("drawingList", drawingList);
        model.addAttribute("peopleList", personDelegate.getActivePeopleList());
        return "/ticket/ticketForm";
    }

    @GetMapping(value = "tickets/{id}/update")
    public String displayUpdateTicketForm(Model model, @PathVariable UUID id) {
        List<DrawingDTO> drawingList = drawingDelegate.findActiveDrawings();
        model.addAttribute("ticketDTO", ticketDelegate.findTicketById(id));
        model.addAttribute("drawingDelegate", drawingDelegate);
        model.addAttribute("peopleList", personDelegate.getActivePeopleList());
        return "/ticket/ticketUpdateForm";
    }


    @PostMapping(value = "/tickets/")
    public String addTicket(@Valid TicketDTO ticketDTO, Errors errors, Model model) {

        if (errors.hasErrors()) {
                return "/ticket/ticketForm";
        }

        TicketDTO result = ticketDelegate.addTicket(ticketDTO);
        model.addAttribute("ticket", result);

        String drawingName = drawingDelegate.findDrawingById(ticketDTO.getDrawingId()).getName();

        String personName;
        if (ticketDTO.getPersonId() == null) {
            personName = "";
        } else {
            personName = personDelegate.findPersonById(ticketDTO.getPersonId()).getFirstName() + " " +
                    personDelegate.findPersonById(ticketDTO.getPersonId()).getLastName();
        }

        model.addAttribute("drawingName", drawingName);
        model.addAttribute("personName", personName);
        model.addAttribute("personDelegate", personDelegate);
        model.addAttribute("drawingDelegate", drawingDelegate);

        return "/ticket/displayTicket";
    }

    @PostMapping(value = "/tickets/update")
    public String updateTicket(@Valid TicketDTO ticketDTO, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("ticketDTO", ticketDelegate.findTicketById(ticketDTO.getId()));
            return "/ticket/ticketUpdateForm";
        }

            TicketDTO result = ticketDelegate.addTicket(ticketDTO);
            model.addAttribute("ticket", result);

            String drawingName = drawingDelegate.findDrawingById(ticketDTO.getDrawingId()).getName();

            String personName;
            if (ticketDTO.getPersonId() == null) {
                personName = "";
            } else {
                personName = personDelegate.findPersonById(ticketDTO.getPersonId()).getFirstName() + " " +
                        personDelegate.findPersonById(ticketDTO.getPersonId()).getLastName();
            }

            model.addAttribute("drawingName", drawingName);
            model.addAttribute("personName", personName);
            model.addAttribute("personDelegate", personDelegate);
            model.addAttribute("drawingDelegate", drawingDelegate);

            return "/ticket/displayTicket";
    }

    @GetMapping(value = "/tickets/{id}/deactivate")
    public String cancelTicket(@PathVariable UUID id, Model model){
        ticketDelegate.deactivateTicket(id);
        TicketDTO results = ticketDelegate.findTicketById(id);
        model.addAttribute("ticket", results);
        model.addAttribute("ticketList", ticketDelegate.findTicketsByDrawingId(id));
        return "redirect:/tickets/all";
    }

    @GetMapping(value = "/tickets/active")
    public String getActiveTickets(Model model){
        model.addAttribute("ticketList", ticketDelegate.findTicketsByIsActive(true));
        model.addAttribute("drawingDelegate", drawingDelegate);
        model.addAttribute("personDelegate", personDelegate);
        return "/ticket/displayTicketList";
    }

    @GetMapping(value = "/tickets/inactive")
    public String getInactiveTickets(Model model){
        model.addAttribute("ticketList", ticketDelegate.findTicketsByIsActive(false));
        model.addAttribute("drawingDelegate", drawingDelegate);
        model.addAttribute("personDelegate", personDelegate);
        return "/ticket/displayTicketList";
    }

}

