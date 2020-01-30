package cpt200h190.lotteryproject.person.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    @JsonProperty
    private UUID id;

    @JsonProperty
    private String humanReadableId;

    @NotNull
    @Size(min=2)
    @JsonProperty
    private String firstName;

    @NotNull
    @Size(min=2)
    @JsonProperty
    private String lastName;

    @Email
    @JsonProperty
    private String email;

    @JsonProperty
    private String phoneNumber;

    @JsonProperty
    private Boolean isActive;
}
