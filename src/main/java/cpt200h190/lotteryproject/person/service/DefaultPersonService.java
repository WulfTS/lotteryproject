package cpt200h190.lotteryproject.person.service;

import cpt200h190.lotteryproject.humanreadableidgenerator.HumanReadableIdGenerator;
import cpt200h190.lotteryproject.person.entity.Person;
import cpt200h190.lotteryproject.person.exceptions.PersonNotFoundException;
import cpt200h190.lotteryproject.person.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Component
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
class DefaultPersonService implements PersonService {
    Random random = new Random();
    private final PersonRepository personRepository;
    private final HumanReadableIdGenerator humanReadableIdGenerator;

    @Override
    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    @Override
    public List<Person> getActivePeopleList() {
        return personRepository.findPersonByIsActive(Boolean.TRUE);
    }

    @Override
    public List<Person> getInactivePeopleList() { return personRepository.findPersonByIsActive(Boolean.FALSE); }

    @Override
    public Person addPerson(Person personToAdd) {
            personToAdd.setIsActive(Boolean.TRUE);
            personToAdd.setHumanReadableId(HumanReadableIdGenerator.GeneratePersonValue(personToAdd.getFirstName(), personToAdd.getLastName()));
            return personRepository.save(personToAdd);
    }

    @Override
    public Person editPerson(Person personUpdates) {
        // check to see if person is in repository
        if (idIsPresent(personUpdates.getId()).equals(Boolean.FALSE)){
            throw new PersonNotFoundException(personUpdates.getId());
        }

        Person existingPerson = findPersonById(personUpdates.getId());

        // If person update fields are null keep existing data
        if (personUpdates.getFirstName() == null || personUpdates.getFirstName().equals("")){
            personUpdates.setFirstName(existingPerson.getFirstName());
        }

        if (personUpdates.getLastName() == null || personUpdates.getLastName().equals("")) {
            personUpdates.setLastName(existingPerson.getLastName());
        }

        if (personUpdates.getEmail() == null || personUpdates.getEmail().equals("")) {
            personUpdates.setEmail(existingPerson.getEmail());
        }

        if (personUpdates.getPhoneNumber() == null || personUpdates.getPhoneNumber().equals("")){
            personUpdates.setPhoneNumber(existingPerson.getPhoneNumber());
        }
        if (personUpdates.getIsActive() == null || personUpdates.getIsActive().equals("")){
            personUpdates.setIsActive(existingPerson.getIsActive());
        }
        personUpdates.setHumanReadableId(existingPerson.getHumanReadableId());

        return personRepository.save(personUpdates);
    }

    @Override
    public void changeActiveStatusById(UUID id) {
        Person person = findPersonById(id);
        person.setIsActive(!person.getIsActive());
        personRepository.save(person);
    }

    @Override
    public Person findPersonById(UUID id) { return personRepository.findById(id).orElse(new Person()); }

    private Boolean idIsPresent(UUID id) {
        Optional<Person> one = personRepository.findById(id);
        if(one.isPresent()){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
