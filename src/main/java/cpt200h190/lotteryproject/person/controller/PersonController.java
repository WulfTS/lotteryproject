package cpt200h190.lotteryproject.person.controller;

import cpt200h190.lotteryproject.person.entity.Person;
import cpt200h190.lotteryproject.person.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    private final PersonRepository repository;

    PersonController(PersonRepository repository){
        this.repository = repository;
    }

    // list all people in database
    @GetMapping("/people")
    public List<Person> listMovies(){
        return repository.findAll();
    }


}
