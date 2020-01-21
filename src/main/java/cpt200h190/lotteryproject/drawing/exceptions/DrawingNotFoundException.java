package cpt200h190.lotteryproject.drawing.exceptions;

public class DrawingNotFoundException extends RuntimeException {
    public DrawingNotFoundException(Long id){
        super("Could not find drawing id: " + id);
    }
}
