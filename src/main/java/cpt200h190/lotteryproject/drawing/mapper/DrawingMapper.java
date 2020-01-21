package cpt200h190.lotteryproject.drawing.mapper;

import cpt200h190.lotteryproject.drawing.dto.DrawingDTO;
import cpt200h190.lotteryproject.drawing.entity.Drawing;

import java.text.ParseException;

public interface DrawingMapper {

    Drawing mapDrawingDTOtoDrawing(DrawingDTO drawingDTO) throws ParseException;

    DrawingDTO mapDrawingToDrawingDTO(Drawing drawing);

}
