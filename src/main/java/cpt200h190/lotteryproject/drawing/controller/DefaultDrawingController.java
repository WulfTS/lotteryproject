package cpt200h190.lotteryproject.drawing.controller;

import cpt200h190.lotteryproject.drawing.delegate.DrawingDelegate;
import cpt200h190.lotteryproject.drawing.dto.DrawingDTO;
import cpt200h190.lotteryproject.person.delegate.PersonDelegate;
import cpt200h190.lotteryproject.ticket.delegate.TicketDelegate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class DefaultDrawingController  {
    private final DrawingDelegate drawingDelegate;
    private final TicketDelegate ticketDelegate;
    private final PersonDelegate personDelegate;

    // display drawing homepage
    @GetMapping(value = "/drawings")
    public String drawingHomepage(){
        return "/drawing/drawingHome";
    }

    // display all drawings
    @GetMapping(value = "drawings/all")
    public String displayDrawings(Model model){
        List<DrawingDTO> drawingList = drawingDelegate.getAllDrawings();
        model.addAttribute("drawingList",drawingList);
        model.addAttribute("ticketDelegate",ticketDelegate);
        model.addAttribute("personDelegate",personDelegate);
        return "/drawing/displayDrawingList";
    }

    @GetMapping(value = "drawings/active")
    public String displayActiveDrawings(Model model){
        List<DrawingDTO> drawingList = drawingDelegate.findActiveDrawings();
        model.addAttribute("drawingList",drawingList);
        model.addAttribute("ticketDelegate",ticketDelegate);
        model.addAttribute("personDelegate",personDelegate);
        return "/drawing/displayDrawingList";
    }

    @GetMapping(value = "drawings/inactive")
    public String displayInactiveDrawings(Model model){
        List<DrawingDTO> drawingList = drawingDelegate.findInactiveDrawings();
        model.addAttribute("drawingList",drawingList);
        model.addAttribute("ticketDelegate",ticketDelegate);
        model.addAttribute("personDelegate",personDelegate);
        return "/drawing/displayDrawingList";
    }

    // display new drawing form
    @GetMapping(value = "drawings/add")
    public String addDrawing(Model model){
        model.addAttribute("existingDrawing",new DrawingDTO());
        return "/drawing/drawingForm";
    }

    //display individual drawing
    @GetMapping(value = "drawings/{id}")
    public String displayDrawing(@PathVariable UUID id, Model model){
        DrawingDTO drawing = drawingDelegate.findDrawingById(id);
        model.addAttribute("drawing", drawing);
        model.addAttribute("personDelegate",personDelegate);
        model.addAttribute("drawingDelegate",drawingDelegate);
        model.addAttribute("ticketDelegate",ticketDelegate);
        model.addAttribute("ticketList", ticketDelegate.findTicketsByDrawingId(id));
        return "/drawing/displayDrawing";
    }

    // display edit drawing form
    @GetMapping(value = "drawings/{id}/update")
    public String editDrawing(@PathVariable UUID id, Model model){
        model.addAttribute("existingDrawing", drawingDelegate.findDrawingById(id));
        return "/drawing/drawingForm";
    }

    // Actually update drawing
    @PostMapping(value = "/drawings")
    public String updateDrawingData(@ModelAttribute("drawing") @Valid DrawingDTO drawingDTO, Errors errors, Model model) throws ParseException {
        DrawingDTO result = null;


        if (drawingDTO.getId() == null) {
            if (errors.hasErrors()) {
                model.addAttribute("existingDrawing", new DrawingDTO());
                return "/drawing/drawingForm";
            }
            result = drawingDelegate.addDrawing(drawingDTO);
        } else {
            if (errors.hasErrors()) {
                model.addAttribute("existingDrawing", drawingDelegate.findDrawingById(drawingDTO.getId()));
                return "/drawing/drawingForm";
            }

            result = drawingDelegate.editDrawing(drawingDTO);
        }

        model.addAttribute("drawing", result);
        model.addAttribute("ticketList", ticketDelegate.findTicketsByDrawingId(result.getId()));
        model.addAttribute("drawingDelegate", drawingDelegate);
        model.addAttribute("personDelegate", personDelegate);
        model.addAttribute("ticketDelegate", ticketDelegate);
        return "/drawing/displayDrawing";
    }


    @GetMapping(value = "/drawing/{id}/drawWinner")
    public String drawWinner(@PathVariable UUID id, Model model){
       DrawingDTO drawingDTO = drawingDelegate.drawWinner(id);
       model.addAttribute("drawing", drawingDTO);
       model.addAttribute("ticketList", ticketDelegate.findTicketsByDrawingId(id));
        model.addAttribute("drawingDelegate",drawingDelegate);
        model.addAttribute("personDelegate",personDelegate);
        model.addAttribute("ticketDelegate",ticketDelegate);
       return "redirect:/drawings/all";
    }

    @GetMapping(value = "/drawings/drawWinner")
    public String displayDrawWinnerForm(Model model){
        model.addAttribute("drawingList",drawingDelegate.findActiveDrawings());
        return  "/drawing/drawWinner";
    }

    @PostMapping(value = "/drawings/drawIndividualWinner")
    public String displayWinner(@ModelAttribute DrawingDTO drawingDTO, Model model){
        DrawingDTO result = drawingDelegate.drawWinner(drawingDTO.getId());
        model.addAttribute("drawing",result);
        model.addAttribute("ticketList", ticketDelegate.findTicketsByDrawingId(drawingDTO.getId()));
        model.addAttribute("drawingDelegate",drawingDelegate);
        model.addAttribute("ticketDelegate",ticketDelegate);
        model.addAttribute("personDelegate",personDelegate);
        return  "/drawing/displayDrawing";
    }

    @GetMapping(value = "/drawing/{id}/cancel")
    public String cancelDrawing(@PathVariable UUID id, Model model){
        drawingDelegate.cancelDrawing(id);
        DrawingDTO results = drawingDelegate.findDrawingById(id);
        model.addAttribute("drawing", results);
        model.addAttribute("ticketList", ticketDelegate.findTicketsByDrawingId(id));
        return "redirect:/drawings/all";
    }

}
