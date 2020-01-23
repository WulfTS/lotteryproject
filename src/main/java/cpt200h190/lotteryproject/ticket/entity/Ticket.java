package cpt200h190.lotteryproject.ticket.entity;

import cpt200h190.lotteryproject.drawing.dto.DrawingDTO;
import cpt200h190.lotteryproject.person.dto.PersonDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    Long drawingId;

    Long personId;

    public Ticket(Long drawingId){
        this.drawingId = drawingId;
    }

    public Ticket(Long drawingId, Long personId){
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
