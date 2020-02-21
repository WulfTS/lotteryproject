package cpt200h190.lotteryproject.prize.service;

import cpt200h190.lotteryproject.prize.entity.Prize;
import cpt200h190.lotteryproject.prize.repository.PrizeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class DefaultPrizeService implements PrizeService {
    private final PrizeRepository prizeRepository;

    @Override
    public List<Prize> getAllPrizes() {
        return prizeRepository.findAll();
    }

    @Override
    public Prize addPrize(Prize prize) {

        return prizeRepository.save(prize);
    }



    @Override
    public Prize editPrize(Prize prize) {
        return prizeRepository.save(prize);
    }

    @Override
    public Prize findPrizeById(UUID id) {

        return prizeRepository.findById(id).orElse(new Prize());
    }

    @Override
    public List<Prize> findPrizesByIsActive(Boolean isActive) {
        return prizeRepository.findPrizeByIsActive(isActive);
    }

    @Override
    public void changeActiveStatus(UUID id) {
        Prize prize = findPrizeById(id);
        prize.setIsActive(!prize.getIsActive());
        prizeRepository.save(prize);
    }
}
