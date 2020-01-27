package cpt200h190.lotteryproject.person.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;


@Data
@Builder
@AllArgsConstructor
public class PersonDTO {

    @JsonProperty
    private UUID id;

    @JsonProperty
    private Long humanReadableId;

    @JsonProperty
    private String firstName;

    @JsonProperty
    private String lastName;

    @JsonProperty
    private String email;

    @JsonProperty
    private String phoneNumber;

    @JsonProperty
    private Boolean isActive;
}
