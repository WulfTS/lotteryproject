package cpt200h190.lotteryproject.drawing.controller;

import cpt200h190.lotteryproject.drawing.delegate.DrawingDelegate;
import cpt200h190.lotteryproject.drawing.dto.DrawingDTO;
import cpt200h190.lotteryproject.ticket.delegate.TicketDelegate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class DefaultDrawingController  {
    private final DrawingDelegate drawingDelegate;
    private final TicketDelegate ticketDelegate;
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
        return "/drawing/displayAllDrawings";
    }

    // display new drawing form
    @GetMapping(value = "drawings/add")
    public String addDrawing(){
        return "/drawing/drawingForm";
    }

    // add new data to
    @PostMapping(value = "drawings/add")
    public String addDrawing(@ModelAttribute("drawing") DrawingDTO drawingDTO, Model model) throws ParseException {
        if(drawingDTO.getTimeString() == null || drawingDTO.getTimeString().equals("")){
            drawingDTO.setTimeString(DrawingDTO.defaultTimeString);
        }

        if(drawingDTO.getDateString() == null || drawingDTO.getDateString().equals("")){
            drawingDTO.setDateString(DrawingDTO.defaultDateString);
        }
        DrawingDTO result = drawingDelegate.addDrawing(drawingDTO);
        model.addAttribute("drawing",result);
        return "/drawing/displayDrawing";
    }

    //display individual drawing
    @GetMapping(value = "drawings/{id}")
    public String displayDrawing(@PathVariable Long id, Model model){
        DrawingDTO drawing = drawingDelegate.findDrawingById(id);
        model.addAttribute("drawing", drawing);
        model.addAttribute("ticketList", ticketDelegate.findTicketsByDrawingId(id));
        return "/drawing/displayDrawing";
    }

    // display edit drawing form
    @GetMapping(value = "drawings/{id}/update")
    public String editDrawing(@PathVariable Long id, Model model){
        model.addAttribute("existingDrawing", drawingDelegate.findDrawingById(id));
        return "/drawing/drawingUpdateForm";
    }

    // Actually update drawing
    @PostMapping(value = "/drawings")
    public String updateDrawingData(@ModelAttribute("drawingUpdate") DrawingDTO drawingDTO, Model model) throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat timeFormat = new SimpleDateFormat("HH:mm");
        DrawingDTO oldDrawing = drawingDelegate.findDrawingById(drawingDTO.getId());

        if(drawingDTO.getTimeString()== null || drawingDTO.getTimeString().equals("")){

            drawingDTO.setTimeString(timeFormat.format(oldDrawing.getTime()));
        }

        if(drawingDTO.getDateString() == null || drawingDTO.getDateString().equals("")){

            drawingDTO.setDateString(dateFormat.format(oldDrawing.getTime()));
        }

        DrawingDTO result = drawingDelegate.editDrawing(drawingDTO);
        model.addAttribute("drawing", result);
        return "/drawing/displayDrawing";
    }
}
