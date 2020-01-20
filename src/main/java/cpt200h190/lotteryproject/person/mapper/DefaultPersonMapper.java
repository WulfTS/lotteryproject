package cpt200h190.lotteryproject.person.mapper;

import cpt200h190.lotteryproject.person.dto.PersonDTO;
import cpt200h190.lotteryproject.person.entity.Person;
import org.springframework.stereotype.Service;

@Service
public class DefaultPersonMapper implements PersonMapper {
    @Override
    public Person mapPersonDTOtoPerson(PersonDTO personDTO) {
        return Person.builder()
                .id(personDTO.getId())
                .firstName(personDTO.getFirstName())
                .lastName(personDTO.getLastName())
                .email(personDTO.getEmail())
                .phoneNumber(personDTO.getPhoneNumber())
                .isActive(personDTO.getIsActive())
                .build();
    }

    @Override
    public PersonDTO mapPersonToPersonDTO(Person person) {
        return PersonDTO.builder()
                .id(person.getId())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .email(person.getEmail())
                .phoneNumber(person.getPhoneNumber())
                .isActive(person.getIsActive())
                .build();
    }


}
