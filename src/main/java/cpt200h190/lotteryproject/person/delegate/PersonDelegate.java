package cpt200h190.lotteryproject.person.delegate;

import cpt200h190.lotteryproject.person.dto.PersonDTO;

import java.util.List;

public interface PersonDelegate {

    List<PersonDTO> getAllPeople();

    PersonDTO addPerson(PersonDTO personToAdd);

    void deletePersonById(Long id);

    PersonDTO findPersonById(Long id);

}
