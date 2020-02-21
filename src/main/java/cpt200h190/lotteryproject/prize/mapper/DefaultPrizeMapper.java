package cpt200h190.lotteryproject.prize.mapper;

import cpt200h190.lotteryproject.prize.dto.PrizeDTO;
import cpt200h190.lotteryproject.prize.entity.Prize;
import org.springframework.stereotype.Service;

@Service
public class DefaultPrizeMapper implements PrizeMapper {
    @Override
    public Prize mapPrizeDTOtoPrize(PrizeDTO prizeDTO) {

        return Prize.builder()
                .id(prizeDTO.getId())
                .drawingId(prizeDTO.getDrawingId())
                .humanReadableId(prizeDTO.getHumanReadableId())
                .description(prizeDTO.getDescription())
                .isActive(prizeDTO.getIsActive())
                .build();
    }

    @Override
    public PrizeDTO mapPrizeToPrizeDTO(Prize prize) {
        return PrizeDTO.builder()
                .id(prize.getId())
                .drawingId(prize.getDrawingId())
                .humanReadableId(prize.getHumanReadableId())
                .description(prize.getDescription())
                .isActive(prize.getIsActive())
                .build();
    }
}
