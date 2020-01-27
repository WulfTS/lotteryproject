package cpt200h190.lotteryproject.drawing.exceptions;

import java.util.UUID;

public class DrawingNotFoundException extends RuntimeException {
    public DrawingNotFoundException(UUID id){
        super("Could not find drawing id: " + id);
    }
}
