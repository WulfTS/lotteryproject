package cpt200h190.lotteryproject.prize.entity;

import cpt200h190.lotteryproject.humanreadableidgenerator.HumanReadableIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Prize {

    private static HumanReadableIdGenerator humanReadableIdGenerator;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    UUID id;

    @NotNull
    UUID drawingId;

    @Column(unique = true)
    String humanReadableId;

    @NotNull
    String description;

    @NotNull
    Boolean isActive;

    public Prize(String description, UUID drawingId){
        this.description = description;
        this.humanReadableId = HumanReadableIdGenerator.GeneratePrizeValue(description);
        this.drawingId = drawingId;
        isActive = true;
    }



}
