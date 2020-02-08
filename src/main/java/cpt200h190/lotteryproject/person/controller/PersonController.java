package cpt200h190.lotteryproject.person.controller;

import cpt200h190.lotteryproject.drawing.delegate.DrawingDelegate;
import cpt200h190.lotteryproject.person.delegate.PersonDelegate;
import cpt200h190.lotteryproject.person.dto.PersonDTO;
import cpt200h190.lotteryproject.ticket.delegate.TicketDelegate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class PersonController {

    private final PersonDelegate personDelegate;
    private final TicketDelegate ticketDelegate;
    private final DrawingDelegate drawingDelegate;

    public PersonDTO getPersonById(UUID id){
        return personDelegate.findPersonById(id);
    }

    public List<PersonDTO> getAllPeople(){
        return personDelegate.getAllPeople();
    }

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
    public String displayPersonForm(Model model){
        model.addAttribute("personDTO",new PersonDTO());
        return "person/personForm";
    }

    // list all people in database
    @GetMapping(value="/people/all")
    public String displayPeople(Model model){
        List<PersonDTO> peopleList = personDelegate.getAllPeople();
        model.addAttribute("peopleList",peopleList);
        return "person/displayPersonList";
    }
    @GetMapping(value="/people/active")
    public String displayActivePeople(Model model){
        List<PersonDTO> peopleList = personDelegate.getActivePeopleList();
        model.addAttribute("peopleList",peopleList);
        return "person/displayPersonList";
    }

    @GetMapping(value="/people/inactive")
    public String displayInactivePeople(Model model){
        List<PersonDTO> peopleList = personDelegate.getInactivePeopleList();
        model.addAttribute("peopleList",peopleList);
        return "person/displayPersonList";
    }


    // Display person by id
    @GetMapping(value="/person/{id}")
    public String displayPerson(@PathVariable UUID id, Model model){
        PersonDTO person = personDelegate.findPersonById(id);
        model.addAttribute("person", person);
        model.addAttribute("personDelegate",personDelegate);
        model.addAttribute("drawingDelegate", drawingDelegate);
        model.addAttribute("ticketList",ticketDelegate.findTicketByPersonId(id));
        return "person/displayPerson";
    }

    //Display update form
    @GetMapping(value="/person/{id}/update")
    public String displayUpdateForm(@PathVariable UUID id,  Model model){
        model.addAttribute("personDTO", personDelegate.findPersonById(id));
        return "/person/personForm";
    }

    // actually update person
    @PostMapping(value ="/person/" )
    public String updatePersonData(@Valid PersonDTO personDTO, Errors errors, Model model){
        PersonDTO result = null;

        if(personDTO.getId()== null){
            if(errors.hasErrors()){
                model.addAttribute("personDTO",personDTO);
                return "/person/personForm";
            }
            result = personDelegate.addPerson(personDTO);
        } else {
            if(errors.hasErrors()){
                model.addAttribute("personDTO",personDTO);
                return "/person/personForm";
            }
            result = personDelegate.editPerson(personDTO);
        }

        model.addAttribute("person",result);
        model.addAttribute("ticketList",ticketDelegate.findTicketByPersonId(result.getId()));
        model.addAttribute("personDelegate",personDelegate);
        model.addAttribute("drawingDelegate", drawingDelegate);
        return "person/displayPerson";
    }

    @GetMapping(value = "person/{id}/changeStatus")
    public String changePersonActiveStatus(@PathVariable UUID id, Model model){
        personDelegate.changeActiveStatusById(id);
        PersonDTO result = personDelegate.findPersonById(id);
        model.addAttribute("person",result);
        return "redirect:/people/all";

    }



}
