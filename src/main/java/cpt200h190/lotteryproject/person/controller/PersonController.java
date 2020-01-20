package cpt200h190.lotteryproject.person.controller;

import cpt200h190.lotteryproject.person.delegate.PersonDelegate;
import cpt200h190.lotteryproject.person.dto.PersonDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class PersonController {

    private final PersonDelegate personDelegate;

    // display main homepage
    @GetMapping(value = "/")
    public String homepage(HttpServletRequest request, Model model){

        return "homepage";
    }

    // display people homepage
    @GetMapping(value = "/people")
    public String homepage(){

        return "person/peopleHome";
    }

    // Add a person to the database
    @PostMapping("/people")
    public PersonDTO newPerson(@RequestBody PersonDTO personToAdd){
        return personDelegate.addPerson(personToAdd);
    }

    // list all people in database
    @GetMapping(value="/person")
    public String displayPeople(HttpServletRequest request, Model model){
        List<PersonDTO> peopleList = personDelegate.getAllPeople();
        model.addAttribute("peopleList",peopleList);
        return "person/displayAllPeople";
    }

    // Display person by id
    @GetMapping(value="/person/{id}")
    public String displayPerson(@PathVariable Long id,  Model model){
        PersonDTO person = personDelegate.findPersonById(id);
        model.addAttribute("person", person);
        return "person/displayPerson";
    }

}
