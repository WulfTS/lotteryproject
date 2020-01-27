package cpt200h190.lotteryproject.ticket.entity;

import cpt200h190.lotteryproject.drawing.dto.DrawingDTO;
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

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    UUID drawingId;

    UUID personId;

    public Ticket(UUID drawingId){
        this.drawingId = drawingId;
    }

    public Ticket(UUID drawingId, UUID personId){
        this.drawingId = drawingId;
        this.personId = personId;
    }

    public Ticket(DrawingDTO drawingDTO){
        this.drawingId = drawingDTO.getId();
    }

    public Ticket(DrawingDTO drawingDTO, PersonDTO personDTO){
        this.drawingId = drawingDTO.getId();
        this.personId = personDTO.getId();
    }

}
