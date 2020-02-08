package cpt200h190.lotteryproject.drawing.service;

import cpt200h190.lotteryproject.drawing.entity.Drawing;
import cpt200h190.lotteryproject.drawing.exceptions.DrawingNotFoundException;
import cpt200h190.lotteryproject.drawing.repository.DrawingRepository;
import cpt200h190.lotteryproject.humanreadableidgenerator.HumanReadableIdGenerator;
import cpt200h190.lotteryproject.ticket.entity.Ticket;
import cpt200h190.lotteryproject.ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Component
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class DefaultDrawingService implements DrawingService {

    private final DrawingRepository drawingRepository;
    private TicketService ticketService;
    private final HumanReadableIdGenerator humanReadableIdGenerator;

    @Autowired
    public void setCircB(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @Override
    public List<Drawing> getAllDrawings() {
        return drawingRepository.findAll();
    }

    @Override
    public Drawing addDrawing(Drawing drawingToAdd) {
        drawingToAdd.setIsActive(Boolean.TRUE);
        drawingToAdd.setHumanReadableId(HumanReadableIdGenerator.GenerateDrawingValue(drawingToAdd.getName()));
        return drawingRepository.save(drawingToAdd);
    }

    @Override
    public Drawing editDrawing(Drawing drawingUpdates) {
        if (idIsPresent(drawingUpdates.getId()).equals(Boolean.FALSE)) {


            throw new DrawingNotFoundException(drawingUpdates.getId());
        }

        Drawing existingDrawing = findDrawingById(drawingUpdates.getId());

        // if update fields are blank keep existing data
        if(drawingUpdates.getName() == null || drawingUpdates.getName().equals("")){
            drawingUpdates.setName(existingDrawing.getName());
        }

        if(drawingUpdates.getTime() == null){
            drawingUpdates.setTime(existingDrawing.getTime());
        }

        if(drawingUpdates.getMaxTickets() == null){
            drawingUpdates.setMaxTickets(existingDrawing.getMaxTickets());
        }
        if(drawingUpdates.getIsActive() == null || drawingUpdates.getIsActive().equals("")){
            drawingUpdates.setIsActive(existingDrawing.getIsActive());
        }

        drawingUpdates.setHumanReadableId(existingDrawing.getHumanReadableId());


            return drawingRepository.save(drawingUpdates);
    }

    @Override
    public Drawing findDrawingById(UUID id) {

        return drawingRepository.findById(id).orElse(new Drawing());
    }

    @Override
    public Drawing drawWinner(UUID id) {

        Drawing drawing = findDrawingById(id);
        List<Ticket> ticketList = ticketService.findTicketByDrawingIdAndIsActive(id,true);
        Random random = new Random();

        if(ticketList.size() == 0){
            return new Drawing();
        }

        Ticket winningTicket = ticketList.get(random.nextInt(ticketList.size()));

      if(drawing.getWinningTicketId() == null ){
          drawing.setWinningTicketId(winningTicket.getId());
          drawing.setIsActive(Boolean.FALSE);

          ticketList.forEach(ticket -> {
              ticket.setIsActive(false);
              ticketService.editTicket(ticket);
          });


      } else {
          // do nothing since a winner for this drawing has already been selected.
      }
      return drawingRepository.save(drawing);
    }

    @Override
    public List<Drawing> findActiveDrawings() {
        return drawingRepository.findDrawingByIsActive(Boolean.TRUE);
    }

    @Override
    public List<Drawing> findInactiveDrawings() {
        return drawingRepository.findDrawingByIsActive(Boolean.FALSE);
    }

    @Override
    public void cancelDrawing(UUID id) {
        Drawing drawing = findDrawingById(id);
        drawing.setIsActive(Boolean.FALSE);
        drawingRepository.save(drawing);
    }


    private Boolean idIsPresent(UUID id) {

        Optional<Drawing> one = drawingRepository.findById(id);

        if(one.isPresent()){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }




}

