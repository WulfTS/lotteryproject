package cpt200h190.lotteryproject.drawing.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class DrawingDTO {
    public static String defaultDateString = "9999-12-31";
    public static String defaultTimeString = "00:00";

    @JsonProperty
    private Long id;

    @JsonProperty
    private String name;

    @JsonProperty
    private Date time;

    @JsonProperty
    private Integer maxTickets;

    @JsonProperty
    String dateString;

    @JsonProperty
    String timeString;


}
