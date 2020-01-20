package cpt200h190.lotteryproject.person.controller;

import cpt200h190.lotteryproject.person.delegate.PersonDelegate;
import cpt200h190.lotteryproject.person.dto.PersonDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class PersonController {

    private final PersonDelegate personDelegate;

    // display main homepage
    @GetMapping(value = "/")
    public String homepage(Model model){

        return "homepage";
    }

    // display people homepage
    @GetMapping(value = "/people")
    public String homepage(){

        return "person/peopleHome";
    }

    // display person form
    @GetMapping("people/add")
    public String displayPersonForm(){
        return "person/personForm";
    }

    // Add a person to the database  Display person form with newly added data
    @PostMapping("/people/add")
    public String addPersonByDto(@ModelAttribute("person") PersonDTO personDTO, Model model) {
        PersonDTO result = personDelegate.addPerson(personDTO);
        model.addAttribute("person", result);
        return "person/displayPerson";
    }

    // list all people in database
    @GetMapping(value="/person")
    public String displayPeople(Model model){
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

    //Display update form
    @GetMapping(value="/person/{id}/update")
    public String displayUpdateForm(@PathVariable Long id,  Model model){
        model.addAttribute("existingPerson", personDelegate.findPersonById(id));
        return "person/personUpdateForm";
    }

    // actually update person
    @PostMapping(value ="/person/" )
    public String updatePersonData( @ModelAttribute("personUpdate") PersonDTO personDTO, Model model){
        PersonDTO result = personDelegate.editPerson(personDTO);
        model.addAttribute("person",result);
        return "person/displayPerson";
    }



}
