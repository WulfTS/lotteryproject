package cpt200h190.lotteryproject.person.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Random;
import java.util.UUID;

@Data
@Entity
@Builder
@AllArgsConstructor
@SequenceGenerator(name = "seq",initialValue = 1)
public class Person {
    private Random random = new Random();


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

    public Person(){
        isActive = Boolean.TRUE;
        this.humanReadableId = "z" + "z" + random.nextInt(9999);

    }

    public Person(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        isActive = Boolean.TRUE;
        this.humanReadableId = firstName.substring(0,1)+lastName.substring(0,1)+ Integer.toString(random.nextInt(999999));
    }

    public Person(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        isActive = Boolean.TRUE;
        this.humanReadableId = firstName.substring(0,1)+ lastName.substring(0,1)+ Integer.toString(random.nextInt(999999));
    }



}
