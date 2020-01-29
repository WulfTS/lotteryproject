package cpt200h190.lotteryproject.drawing.entity;

import cpt200h190.lotteryproject.humanreadableidgenerator.HumanReadableIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Drawing {

    private String defaultDate = "9999-12-31";
    private static HumanReadableIdGenerator humanReadableIdGenerator;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(unique = true)
    private String humanReadableId;

    @NotNull
    String name;

    Date time;

    Integer maxTickets;

    UUID winningTicketId;

    @NotNull
    Boolean isActive;

    // Constructors
   public Drawing(String name, Date time) {
        this.name = name;
        this.time = time;
        this.isActive = Boolean.TRUE;
        this.humanReadableId = HumanReadableIdGenerator.GenerateDrawingValue(name);

   }

    public Drawing (String name) throws ParseException {
        this.name = name;
        this.time = new SimpleDateFormat("yyyy-MM-dd").parse(defaultDate);
        this.isActive = Boolean.TRUE;
        this.humanReadableId = HumanReadableIdGenerator.GenerateDrawingValue(name);

    }

    public Drawing(String name, Date time, Integer maxTickets){
        this.name = name;
        this.time =  time;
        this.maxTickets = maxTickets;
        this.isActive = Boolean.TRUE;
        this.humanReadableId = HumanReadableIdGenerator.GenerateDrawingValue(name);


    }

    public Drawing(String name, Integer maxTickets) throws ParseException {
       this.name = name;
       this.maxTickets = maxTickets;
       this.time = new SimpleDateFormat("yyyy-MM-dd").parse(defaultDate);
       this.isActive = Boolean.TRUE;
       this.humanReadableId = HumanReadableIdGenerator.GenerateDrawingValue(name);


    }


}
