package cpt200h190.lotteryproject.person.delegate;

import cpt200h190.lotteryproject.person.dto.PersonDTO;
import cpt200h190.lotteryproject.person.entity.Person;
import cpt200h190.lotteryproject.person.mapper.PersonMapper;
import cpt200h190.lotteryproject.person.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class DefaultPersonDelegate implements PersonDelegate {

    private final PersonService personService;
    private final PersonMapper personMapper;



    @Override
    public List<PersonDTO> getAllPeople() {
        return personService.getAllPeople().stream()
                .map(personMapper::mapPersonToPersonDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PersonDTO addPerson(PersonDTO personToAdd) {
        Person person = personMapper.mapPersonDTOtoPerson(personToAdd);
        return personMapper.mapPersonToPersonDTO(personService.addPerson(person));
    }

    @Override
    public void deletePersonById(Long id) {
        personService.deletePersonById(id);
    }

    @Override
    public PersonDTO findPersonById(Long id) {
        Person person = personService.findPersonById(id);
        return personMapper.mapPersonToPersonDTO(person);
    }
}
