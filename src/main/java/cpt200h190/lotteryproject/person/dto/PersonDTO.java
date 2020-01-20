package cpt200h190.lotteryproject.person.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class PersonDTO {

    @JsonProperty
    private Long id;

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
