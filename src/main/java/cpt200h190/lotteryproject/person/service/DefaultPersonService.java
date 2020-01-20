package cpt200h190.lotteryproject.person.service;

import cpt200h190.lotteryproject.person.entity.Person;
import cpt200h190.lotteryproject.person.exceptions.PersonNotFoundException;
import cpt200h190.lotteryproject.person.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class DefaultPersonService implements PersonService {
    private final PersonRepository personRepository;

    @Override
    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    @Override
    public Person addPerson(Person personToAdd) {
        return personRepository.save(personToAdd);
    }

    @Override
    public Person editPerson(Person personUpdates) {
        // check to see if person is in repository
        if (idIsPresent(personUpdates.getId()).equals(Boolean.FALSE)){
            throw new PersonNotFoundException(personUpdates.getId());
        }

        Person existingPerson = findPersonById(personUpdates.getId());

        // If person update fields are blank keep existing data
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

        return personRepository.save(personUpdates);


    }

    @Override
    public void deletePersonById(Long id) {
        personRepository.deleteById(id);

    }

    @Override
    public Person findPersonById(Long id) {
        return personRepository.findById(id).orElse(new Person());
    }

    @Override
    public Boolean idIsPresent(Long id) {
        Optional<Person> one = personRepository.findById(id);

        if(one.isPresent()){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
