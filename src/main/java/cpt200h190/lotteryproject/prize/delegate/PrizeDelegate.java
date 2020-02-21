package cpt200h190.lotteryproject.prize.delegate;

import cpt200h190.lotteryproject.prize.dto.PrizeDTO;

import java.util.List;
import java.util.UUID;

public interface PrizeDelegate {
    List<PrizeDTO> getAllPrizes();

    PrizeDTO addPrize(PrizeDTO prizeToAdd);

    PrizeDTO editPrize(PrizeDTO prizeToEdit);

    PrizeDTO findPrizeById(UUID id);

    List<PrizeDTO> findPrizesByIsActive(Boolean isActive);

    void changeActiveStatus(UUID id);
}

