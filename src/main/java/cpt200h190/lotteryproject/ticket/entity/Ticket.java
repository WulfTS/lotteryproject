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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    private static HumanReadableIdGenerator humanReadableIdGenerator;
    public static List<String> types = new ArrayList<>(Arrays.asList("GEN","PREM"));


    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    private String humanReadableId;

    private String type;

    private UUID drawingId;

    private UUID personId;

    public Ticket(UUID drawingId){
        this.drawingId = drawingId;
        this.type = types.get(0);
        this.humanReadableId = HumanReadableIdGenerator.GenerateTicketValue(type);
    }

    public Ticket(UUID drawingId, UUID personId){
        this.drawingId = drawingId;
        this.personId = personId;
        this.type = types.get(0);
        this.humanReadableId = HumanReadableIdGenerator.GenerateTicketValue(type);
    }

    public Ticket(DrawingDTO drawingDTO){
        this.drawingId = drawingDTO.getId();
        this.type = types.get(0);
        this.humanReadableId = HumanReadableIdGenerator.GenerateTicketValue(type);

    }

    public Ticket(DrawingDTO drawingDTO, PersonDTO personDTO){
        this.drawingId = drawingDTO.getId();
        this.personId = personDTO.getId();
        this.type = types.get(0);
        this.humanReadableId = HumanReadableIdGenerator.GenerateTicketValue(type);

    }

    public Ticket(UUID drawingId, String type){
        this.drawingId = drawingId;
        this.type = types.get(0);
        this.humanReadableId = HumanReadableIdGenerator.GenerateTicketValue(type);
    }

    public Ticket(UUID drawingId, UUID personId, String type){
        this.drawingId = drawingId;
        this.personId = personId;
        this.type = type;
        this.humanReadableId = HumanReadableIdGenerator.GenerateTicketValue(type);

    }

    public Ticket(DrawingDTO drawingDTO, String type){
        this.drawingId = drawingDTO.getId();
        this.type = type;
        this.humanReadableId = HumanReadableIdGenerator.GenerateTicketValue(type);

    }

    public Ticket(DrawingDTO drawingDTO, PersonDTO personDTO, String type){
        this.drawingId = drawingDTO.getId();
        this.personId = personDTO.getId();
        this.humanReadableId = HumanReadableIdGenerator.GenerateTicketValue(type);

    }

}
