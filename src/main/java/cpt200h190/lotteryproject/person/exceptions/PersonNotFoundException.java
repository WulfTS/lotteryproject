package cpt200h190.lotteryproject.person.exceptions;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(Long id){
        super("Could not find person id :" + id);
    }
}
