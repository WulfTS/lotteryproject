package cpt200h190.lotteryproject.person.entity;

import cpt200h190.lotteryproject.humanreadableidgenerator.HumanReadableIdGenerator;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "seq",initialValue = 1)
public class Person {

    private static HumanReadableIdGenerator humanReadableIdGenerator;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(unique = true)
    private String humanReadableId;

    @Column
    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    private String phoneNumber;

    @NotNull
    private Boolean isActive;

    public Person(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        isActive = Boolean.TRUE;
        this.humanReadableId = HumanReadableIdGenerator.GeneratePersonValue(firstName,lastName);
    }

    public Person(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        isActive = Boolean.TRUE;
        this.humanReadableId = HumanReadableIdGenerator.GeneratePersonValue(firstName,lastName);
    }



}
