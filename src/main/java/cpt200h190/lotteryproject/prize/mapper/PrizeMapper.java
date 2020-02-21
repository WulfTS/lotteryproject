package cpt200h190.lotteryproject.prize.mapper;

import cpt200h190.lotteryproject.prize.dto.PrizeDTO;
import cpt200h190.lotteryproject.prize.entity.Prize;

public interface PrizeMapper {

    Prize mapPrizeDTOtoPrize(PrizeDTO prizeDTO);

    PrizeDTO mapPrizeToPrizeDTO(Prize prize);
}
