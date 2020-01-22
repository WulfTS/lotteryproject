package cpt200h190.lotteryproject.ticket.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TicketDTO {

    @JsonProperty
    private Long id;

    @JsonProperty
    private Long drawingId;

    @JsonProperty
    private Long personId;
}
