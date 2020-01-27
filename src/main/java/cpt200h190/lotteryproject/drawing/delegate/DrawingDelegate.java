package cpt200h190.lotteryproject.drawing.delegate;

import cpt200h190.lotteryproject.drawing.dto.DrawingDTO;
import cpt200h190.lotteryproject.drawing.entity.Drawing;
import cpt200h190.lotteryproject.ticket.dto.TicketDTO;
import cpt200h190.lotteryproject.ticket.entity.Ticket;

import java.text.ParseException;
import java.util.List;

public interface DrawingDelegate {
    List<DrawingDTO> getAllDrawings();

    DrawingDTO addDrawing(DrawingDTO drawingToAdd) throws ParseException;

    DrawingDTO editDrawing(DrawingDTO drawingUpdates) throws ParseException;

    DrawingDTO findDrawingById(Long id);

    DrawingDTO drawWinner(Long id);

    List<DrawingDTO> findActiveDrawings();
    List<DrawingDTO> findInactiveDrawings();

    void cancelDrawing(Long id);
}
