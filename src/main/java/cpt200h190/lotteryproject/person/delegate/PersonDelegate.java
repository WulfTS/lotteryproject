package cpt200h190.lotteryproject.person.delegate;

import cpt200h190.lotteryproject.person.dto.PersonDTO;

import java.util.List;
import java.util.UUID;

public interface PersonDelegate {

    List<PersonDTO> getAllPeople();

    PersonDTO addPerson(PersonDTO personToAdd);

    PersonDTO editPerson(PersonDTO personUpdates);

    void deletePersonById(UUID id);

    PersonDTO findPersonById(UUID id);

}
