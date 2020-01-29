package cpt200h190.lotteryproject.ticket.entity;

import cpt200h190.lotteryproject.drawing.dto.DrawingDTO;
import cpt200h190.lotteryproject.humanreadableidgenerator.HumanReadableIdGenerator;
import cpt200h190.lotteryproject.person.dto.PersonDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    private static HumanReadableIdGenerator humanReadableIdGenerator;


    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    private String humanReadableId;

    private String color;

    private UUID drawingId;

    private UUID personId;

    public Ticket(UUID drawingId){
        this.drawingId = drawingId;
        this.humanReadableId = HumanReadableIdGenerator.GenerateTicketValue(color);
    }

    public Ticket(UUID drawingId, UUID personId){
        this.drawingId = drawingId;
        this.personId = personId;
        this.humanReadableId = HumanReadableIdGenerator.GenerateTicketValue(color);

    }

    public Ticket(DrawingDTO drawingDTO){
        this.drawingId = drawingDTO.getId();
        this.humanReadableId = HumanReadableIdGenerator.GenerateTicketValue(color);

    }

    public Ticket(DrawingDTO drawingDTO, PersonDTO personDTO){
        this.drawingId = drawingDTO.getId();
        this.personId = personDTO.getId();
        this.humanReadableId = HumanReadableIdGenerator.GenerateTicketValue(color);

    }

    public Ticket(UUID drawingId, String color){
        this.drawingId = drawingId;
        this.color = color;
        this.humanReadableId = HumanReadableIdGenerator.GenerateTicketValue(color);
    }

    public Ticket(UUID drawingId, UUID personId, String color){
        this.drawingId = drawingId;
        this.personId = personId;
        this.color = color;
        this.humanReadableId = HumanReadableIdGenerator.GenerateTicketValue(color);

    }

    public Ticket(DrawingDTO drawingDTO, String color){
        this.drawingId = drawingDTO.getId();
        this.color = color;
        this.humanReadableId = HumanReadableIdGenerator.GenerateTicketValue(color);

    }

    public Ticket(DrawingDTO drawingDTO, PersonDTO personDTO, String color){
        this.drawingId = drawingDTO.getId();
        this.personId = personDTO.getId();
        this.humanReadableId = HumanReadableIdGenerator.GenerateTicketValue(color);

    }

}
