package cpt200h190.lotteryproject.person.service;

import cpt200h190.lotteryproject.person.entity.Person;

import java.util.List;
import java.util.UUID;

public interface PersonService {
    List<Person> getAllPeople();

    Person addPerson(Person personToAdd);

    Person editPerson(Person personToEdit);

    void deletePersonById(UUID id);

    Person findPersonById(UUID id);

}
