package cpt200h190.lotteryproject.person.mapper;

import cpt200h190.lotteryproject.person.dto.PersonDTO;
import cpt200h190.lotteryproject.person.entity.Person;

public interface PersonMapper {
    Person mapPersonDTOtoPerson(PersonDTO personDTO);

    PersonDTO mapPersonToPersonDTO(Person person);
}
