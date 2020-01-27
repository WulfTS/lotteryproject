package cpt200h190.lotteryproject.ticket.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class TicketDTO {

    @JsonProperty
    private UUID id;

    @JsonProperty
    private UUID drawingId;

    @JsonProperty
    private UUID personId;
}
