package cpt200h190.lotteryproject.drawing.mapper;

import cpt200h190.lotteryproject.drawing.dto.DrawingDTO;
import cpt200h190.lotteryproject.drawing.entity.Drawing;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class DefaultDrawingMapper implements DrawingMapper {




    @Override
    public Drawing mapDrawingDTOtoDrawing(DrawingDTO drawingDTO) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");


        return Drawing.builder()
                .id(drawingDTO.getId())
                .name(drawingDTO.getName())
                .time(format.parse(drawingDTO.getDateString() + " " + drawingDTO.getTimeString()) )
                .maxTickets(drawingDTO.getMaxTickets())
                .build();
    }

    @Override
    public DrawingDTO mapDrawingToDrawingDTO(Drawing drawing) {
        return DrawingDTO.builder()
                .id(drawing.getId())
                .name(drawing.getName())
                .time(drawing.getTime())
                .maxTickets(drawing.getMaxTickets())
                .build();
    }
}
