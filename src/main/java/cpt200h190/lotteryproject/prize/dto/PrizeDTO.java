package cpt200h190.lotteryproject.prize.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrizeDTO {

    @NotNull
    @JsonProperty
    UUID id;

    @NotNull
    @JsonProperty
    UUID drawingId;

    @JsonProperty
    String humanReadableId;

    @NotNull
    @JsonProperty
    String description;

    @NotNull
    @JsonProperty
    Boolean isActive;



}
