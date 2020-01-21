package cpt200h190.lotteryproject.drawing.service;

import cpt200h190.lotteryproject.drawing.entity.Drawing;
import cpt200h190.lotteryproject.drawing.exceptions.DrawingNotFoundException;
import cpt200h190.lotteryproject.drawing.repository.DrawingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class DefaultDrawingService implements DrawingService {

    private final DrawingRepository drawingRepository;

    @Override
    public List<Drawing> getAllDrawings() {
        return drawingRepository.findAll();
    }

    @Override
    public Drawing addDrawing(Drawing drawingToAdd) {
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
            return drawingRepository.save(drawingUpdates);
    }

    @Override
    public Drawing findDrawingById(Long id) {
        return drawingRepository.findById(id).orElse(new Drawing());
    }

    public Boolean idIsPresent(Long id) {

        Optional<Drawing> one = drawingRepository.findById(id);

        if(one.isPresent()){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}

