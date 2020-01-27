package cpt200h190.lotteryproject.drawing.delegate;

import cpt200h190.lotteryproject.drawing.dto.DrawingDTO;
import cpt200h190.lotteryproject.drawing.entity.Drawing;
import cpt200h190.lotteryproject.drawing.mapper.DrawingMapper;
import cpt200h190.lotteryproject.drawing.service.DrawingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class DefaultDrawingDelegate implements DrawingDelegate {

    private final DrawingService drawingService;
    private final DrawingMapper drawingMapper;

    @Override
    public List<DrawingDTO> getAllDrawings() {
        return drawingService.getAllDrawings().stream()
                .map(drawingMapper::mapDrawingToDrawingDTO)
                .collect(Collectors.toList());
    }



    @Override
    public DrawingDTO addDrawing(DrawingDTO drawingToAdd) throws ParseException {
        if(drawingToAdd.getTimeString() == null || drawingToAdd.getTimeString().equals("")){
            drawingToAdd.setTimeString(DrawingDTO.defaultTimeString);
        }

        if(drawingToAdd.getDateString() == null || drawingToAdd.getDateString().equals("")){
            drawingToAdd.setDateString(DrawingDTO.defaultDateString);
        }
        Drawing drawing = drawingMapper.mapDrawingDTOtoDrawing(drawingToAdd);

        return drawingMapper.mapDrawingToDrawingDTO(
                drawingService.addDrawing(drawing));
    }

    @Override
    public DrawingDTO editDrawing(DrawingDTO drawingUpdates) throws ParseException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat timeFormat = new SimpleDateFormat("HH:mm");
        DrawingDTO oldDrawing = findDrawingById(drawingUpdates.getId());

        if(drawingUpdates.getTimeString()== null || drawingUpdates.getTimeString().equals("")){

            drawingUpdates.setTimeString(timeFormat.format(oldDrawing.getTime()));
        }

        if(drawingUpdates.getDateString() == null || drawingUpdates.getDateString().equals("")){

            drawingUpdates.setDateString(dateFormat.format(oldDrawing.getTime()));
        }

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

    @Override
    public List<DrawingDTO> findActiveDrawings() {
        return drawingService.findActiveDrawings().stream()
                .map(drawingMapper::mapDrawingToDrawingDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DrawingDTO> findInactiveDrawings() {
        return drawingService.findInactiveDrawings().stream()
                .map(drawingMapper::mapDrawingToDrawingDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void cancelDrawing(Long id) {
        drawingService.cancelDrawing(id);
    }


}
