package cpt200h190.lotteryproject.drawing.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DrawingDTO {
    public static String defaultDateString = "9999-12-31";
    public static String defaultTimeString = "00:00";
    public static Boolean defaultIsActive = Boolean.TRUE;

    @JsonProperty
    private UUID id;

    @JsonProperty
    private String humanReadableId;

    @NotNull
    @JsonProperty
    @Size(min=2, max=100)
    private String name;

    @JsonProperty
    private Date time;

    @Min(2)
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
