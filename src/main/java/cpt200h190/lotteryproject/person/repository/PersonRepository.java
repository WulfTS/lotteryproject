package cpt200h190.lotteryproject.person.repository;

import cpt200h190.lotteryproject.person.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {
    List<Person> findPersonByIsActive(Boolean isActive);

}
