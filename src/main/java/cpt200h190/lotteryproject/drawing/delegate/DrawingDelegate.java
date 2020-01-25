package cpt200h190.lotteryproject.drawing.delegate;

import cpt200h190.lotteryproject.drawing.dto.DrawingDTO;

import java.text.ParseException;
import java.util.List;

public interface DrawingDelegate {
    List<DrawingDTO> getAllDrawings();

    DrawingDTO addDrawing(DrawingDTO drawingToAdd) throws ParseException;

    DrawingDTO editDrawing(DrawingDTO drawingUpdates) throws ParseException;

    DrawingDTO findDrawingById(Long id);

    DrawingDTO drawWinner(DrawingDTO drawingDTO, Long ticketId) throws ParseException;
}
