package cpt200h190.lotteryproject.prize.service;
import cpt200h190.lotteryproject.prize.entity.Prize;

import java.util.List;
import java.util.UUID;

public interface PrizeService {

    List<Prize> getAllPrizes();

    Prize addPrize(Prize prize);

    Prize editPrize(Prize prize);

    Prize findPrizeById(UUID id);

    List<Prize> findPrizesByIsActive(Boolean isActive);

    void changeActiveStatus(UUID id);


}
