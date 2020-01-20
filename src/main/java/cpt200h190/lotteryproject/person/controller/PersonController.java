package cpt200h190.lotteryproject.person.controller;

import cpt200h190.lotteryproject.person.delegate.PersonDelegate;
import cpt200h190.lotteryproject.person.dto.PersonDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class PersonController {

    private final PersonDelegate personDelegate;

    // list all people in database
    @GetMapping("/people")
    public List<PersonDTO> listMovies(){
        return personDelegate.getAllPeople();
    }


}
