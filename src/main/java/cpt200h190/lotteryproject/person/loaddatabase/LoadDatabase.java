package cpt200h190.lotteryproject.person.loaddatabase;

import cpt200h190.lotteryproject.person.entity.Person;
import cpt200h190.lotteryproject.person.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(PersonRepository repository){
        return args -> {
            log.info("Preloading: " + repository.save(new Person("Test 1", "Person 1", "fleakrlprojects@gmail.com","555-555-5555")));
            log.info("Preloading: " + repository.save(new Person("Test 2", "Person 2", "fleakrlprojects@gmail.com","888-888-8888")));
        };
    }

}
