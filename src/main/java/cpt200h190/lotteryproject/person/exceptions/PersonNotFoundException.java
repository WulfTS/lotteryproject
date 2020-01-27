package cpt200h190.lotteryproject.person.exceptions;

import java.util.UUID;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(UUID id){
        super("Could not find person id :" + id);
    }
}
