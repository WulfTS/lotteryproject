package cpt200h190.lotteryproject.person.service;

import cpt200h190.lotteryproject.person.entity.Person;
import cpt200h190.lotteryproject.person.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
    public void deletePersonById(Long id) {
        personRepository.deleteById(id);

    }

    @Override
    public Person findPersonById(Long id) {
        return personRepository.findById(id).orElse(new Person());
    }
}
