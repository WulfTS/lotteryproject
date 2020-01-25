package cpt200h190.lotteryproject.drawing.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Drawing {

    private String defaultDate = "9999-12-31";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    String name;

    Date time;

    Integer maxTickets;

    Long winningTicketId;

    // Constructors
   public Drawing(String name, Date time) {
        this.name = name;
        this.time = time;
    }

    public Drawing (String name) throws ParseException {
        this.name = name;
        this.time = new SimpleDateFormat("yyyy-MM-dd").parse(defaultDate);
    }

    public Drawing(String name, Date time, Integer maxTickets){
        this.name = name;
        this.time =  time;
        this.maxTickets = maxTickets;
    }

    public Drawing(String name, Integer maxTickets) throws ParseException {
       this.name = name;
       this.maxTickets = maxTickets;
       this.time = new SimpleDateFormat("yyyy-MM-dd").parse(defaultDate);
    }


}
