package cpt200h190.lotteryproject.drawing.service;

import cpt200h190.lotteryproject.drawing.entity.Drawing;
import cpt200h190.lotteryproject.ticket.entity.Ticket;

import java.util.List;

public interface DrawingService {
    List<Drawing> getAllDrawings();

    Drawing addDrawing(Drawing drawingToAdd);

    Drawing editDrawing(Drawing drawingUpdates);

    Drawing findDrawingById(Long id);

    Drawing drawWinner(Long id);
}
