package cpt200h190.lotteryproject.person.service;

import cpt200h190.lotteryproject.person.entity.Person;

import java.util.List;
import java.util.UUID;

public interface PersonService {
    List<Person> getAllPeople();

    List<Person> getActivePeopleList();

    List<Person> getInactivePeopleList();

    Person addPerson(Person personToAdd);

    Person editPerson(Person personToEdit);

    void changeActiveStatusById(UUID id);

    Person findPersonById(UUID id);



}
