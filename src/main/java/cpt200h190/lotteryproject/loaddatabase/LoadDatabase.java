package cpt200h190.lotteryproject.loaddatabase;

import cpt200h190.lotteryproject.drawing.entity.Drawing;
import cpt200h190.lotteryproject.drawing.repository.DrawingRepository;
import cpt200h190.lotteryproject.person.entity.Person;
import cpt200h190.lotteryproject.person.repository.PersonRepository;
import cpt200h190.lotteryproject.ticket.entity.Ticket;
import cpt200h190.lotteryproject.ticket.repository.TicketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(PersonRepository personRepository, DrawingRepository drawingRepository, TicketRepository ticketRepository){
        return args -> {
            log.info("Preloading: " + personRepository.save(new Person("Test 1", "Person 1", "fleakrlprojects@gmail.com","555-555-5555")));
            log.info("Preloading: " + personRepository.save(new Person("Test 2", "Person 2", "fleakrlprojects@gmail.com","888-888-8888")));
            log.info("Preloading: " + personRepository.save(new Person("Test 3", "Person 3", "fleakrlprojects@gmail.com","999-999-9999")));
            log.info("Preloading: " + personRepository.save(new Person("Test 4", "Person 4", "fleakrlprojects@gmail.com","111-111-1111")));
            log.info("Preloading: " + drawingRepository.save(new Drawing("Drawing 1")));
            log.info("Preloading: " + drawingRepository.save(new Drawing("Drawing 2",new SimpleDateFormat("yyyy-MM-dd").parse("2025-10-31"))));
            log.info("Preloading: " + drawingRepository.save(new Drawing("Drawing 3",new SimpleDateFormat("MM/dd/yyyy").parse("12/25/2025"),25)));
            log.info("Preloading: " + drawingRepository.save(new Drawing("Drawing 4",100)));
            log.info("Preloading: " + ticketRepository.save(new Ticket(drawingRepository.findAll().get(0).getId())));
            log.info("Preloading: " + ticketRepository.save(new Ticket(drawingRepository.findAll().get(1).getId(),personRepository.findAll().get(0).getId())));
            log.info("Preloading: " + ticketRepository.save(new Ticket(drawingRepository.findAll().get(2).getId(),personRepository.findAll().get(1).getId())));
            log.info("Preloading: " + ticketRepository.save(new Ticket(drawingRepository.findAll().get(3).getId(),personRepository.findAll().get(1).getId())));
            log.info("Preloading: " + ticketRepository.save(new Ticket(drawingRepository.findAll().get(0).getId())));
            log.info("Preloading: " + ticketRepository.save(new Ticket(drawingRepository.findAll().get(1).getId(),personRepository.findAll().get(1).getId())));
            log.info("Preloading: " + ticketRepository.save(new Ticket(drawingRepository.findAll().get(2).getId(),personRepository.findAll().get(0).getId())));
            log.info("Preloading: " + ticketRepository.save(new Ticket(drawingRepository.findAll().get(3).getId(),personRepository.findAll().get(0).getId())));
            log.info("Preloading: " + ticketRepository.save(new Ticket(drawingRepository.findAll().get(1).getId(),personRepository.findAll().get(2).getId())));
            log.info("Preloading: " + ticketRepository.save(new Ticket(drawingRepository.findAll().get(2).getId(),personRepository.findAll().get(2).getId())));
            log.info("Preloading: " + ticketRepository.save(new Ticket(drawingRepository.findAll().get(3).getId(),personRepository.findAll().get(3).getId())));

        };
    }
}
