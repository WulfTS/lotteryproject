package cpt200h190.lotteryproject.drawing.service;

import cpt200h190.lotteryproject.drawing.entity.Drawing;

import java.util.List;
import java.util.UUID;

public interface DrawingService {
    List<Drawing> getAllDrawings();

    Drawing addDrawing(Drawing drawingToAdd);

    Drawing editDrawing(Drawing drawingUpdates);

    Drawing findDrawingById(UUID id);

    Drawing drawWinner(UUID id);

    List<Drawing> findActiveDrawings();

    List<Drawing> findInactiveDrawings();

    void cancelDrawing(UUID id);

}
