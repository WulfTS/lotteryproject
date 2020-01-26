package cpt200h190.lotteryproject.drawing.delegate;

import cpt200h190.lotteryproject.drawing.dto.DrawingDTO;
import cpt200h190.lotteryproject.drawing.entity.Drawing;
import cpt200h190.lotteryproject.drawing.mapper.DrawingMapper;
import cpt200h190.lotteryproject.drawing.service.DrawingService;
import cpt200h190.lotteryproject.ticket.delegate.TicketDelegate;
import cpt200h190.lotteryproject.ticket.dto.TicketDTO;
import cpt200h190.lotteryproject.ticket.entity.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class DefaultDrawingDelegate implements DrawingDelegate {

    private final DrawingService drawingService;
    private final DrawingMapper drawingMapper;
    private final TicketDelegate ticketDelegate;

    @Override
    public List<DrawingDTO> getAllDrawings() {
        return drawingService.getAllDrawings().stream()
                .map(drawingMapper::mapDrawingToDrawingDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DrawingDTO addDrawing(DrawingDTO drawingToAdd) throws ParseException {
        Drawing drawing = drawingMapper.mapDrawingDTOtoDrawing(drawingToAdd);

        return drawingMapper.mapDrawingToDrawingDTO(
                drawingService.addDrawing(drawing));
    }

    @Override
    public DrawingDTO editDrawing(DrawingDTO drawingUpdates) throws ParseException {
        Drawing drawing = drawingMapper.mapDrawingDTOtoDrawing(drawingUpdates);

        return drawingMapper.mapDrawingToDrawingDTO(
                drawingService.editDrawing(drawing));
    }

    @Override
    public DrawingDTO findDrawingById(Long id) {
        Drawing drawing = drawingService.findDrawingById(id);
        return drawingMapper.mapDrawingToDrawingDTO(drawing);
    }

    @Override
    public DrawingDTO drawWinner(Long id) {
        Drawing drawing = drawingService.drawWinner(id);
        return drawingMapper.mapDrawingToDrawingDTO(drawing);
    }


}
