package cpt200h190.lotteryproject.person.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class PersonDTO {

    @NotNull
    @JsonProperty
    private Long id;

    @NotNull
    @JsonProperty
    private String firstName;

    @NotNull
    @JsonProperty
    private String lastName;

    @NotNull
    @JsonProperty
    private String email;

    @JsonProperty
    private String phoneNumber;
}
