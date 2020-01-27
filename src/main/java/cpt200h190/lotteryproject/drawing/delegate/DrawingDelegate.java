package cpt200h190.lotteryproject.drawing.delegate;

import cpt200h190.lotteryproject.drawing.dto.DrawingDTO;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

public interface DrawingDelegate {
    List<DrawingDTO> getAllDrawings();

    DrawingDTO addDrawing(DrawingDTO drawingToAdd) throws ParseException;

    DrawingDTO editDrawing(DrawingDTO drawingUpdates) throws ParseException;

    DrawingDTO findDrawingById(UUID id);

    DrawingDTO drawWinner(UUID id);

    List<DrawingDTO> findActiveDrawings();
    List<DrawingDTO> findInactiveDrawings();

    void cancelDrawing(UUID id);
}
