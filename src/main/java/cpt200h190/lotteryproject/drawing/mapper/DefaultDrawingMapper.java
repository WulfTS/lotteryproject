package cpt200h190.lotteryproject.drawing.mapper;

import cpt200h190.lotteryproject.drawing.dto.DrawingDTO;
import cpt200h190.lotteryproject.drawing.entity.Drawing;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
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
                .winningTicketId(drawingDTO.getWinningTicketId())
                .isActive(drawingDTO.getIsActive())
                .humanReadableId(drawingDTO.getHumanReadableId())
                .build();
    }

    @Override
    public DrawingDTO mapDrawingToDrawingDTO(Drawing drawing) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat timeFormat = new SimpleDateFormat("HH:mm");

        String dateString;
        String timeString;

        if(drawing.getTime() == null){
            dateString = "";
            timeString = "";
        } else{
            dateString = dateFormat.format(drawing.getTime());
            timeString = timeFormat.format(drawing.getTime());
        }



        return DrawingDTO.builder()
                .id(drawing.getId())
                .name(drawing.getName())
                .time(drawing.getTime())
                .dateString(dateString)
                .timeString(timeString)
                .maxTickets(drawing.getMaxTickets())
                .winningTicketId(drawing.getWinningTicketId())
                .isActive(drawing.getIsActive())
                .humanReadableId(drawing.getHumanReadableId())
                .build();
    }
}
