package cpt200h190.lotteryproject.drawing.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class DrawingDTO {
    public static String defaultDateString = "9999-12-31";
    public static String defaultTimeString = "00:00";
    public static Boolean defaultIsActive = Boolean.TRUE;

    @JsonProperty
    private UUID id;

    @JsonProperty
    private String humanReadableId;

    @JsonProperty
    private String name;

    @JsonProperty
    private Date time;

    @JsonProperty
    private Integer maxTickets;

    @JsonProperty
    private String dateString;

    @JsonProperty
    private String timeString;

    @JsonProperty
    private UUID winningTicketId;

    @JsonProperty
    private Boolean isActive;

}
