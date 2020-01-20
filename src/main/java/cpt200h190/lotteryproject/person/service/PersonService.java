package cpt200h190.lotteryproject.person.service;

import cpt200h190.lotteryproject.person.entity.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAllPeople();

    Person addPerson(Person personToAdd);

    void deletePersonById(Long id);

    Person findPersonById(Long id);
}
