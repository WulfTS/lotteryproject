package cpt200h190.lotteryproject.prize.delegate;

import cpt200h190.lotteryproject.prize.dto.PrizeDTO;
import cpt200h190.lotteryproject.prize.mapper.PrizeMapper;
import cpt200h190.lotteryproject.prize.service.PrizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class DefaultPrizeDelegate implements PrizeDelegate {
    private final PrizeService prizeService;
    private final PrizeMapper prizeMapper;

    @Override
    public List<PrizeDTO> getAllPrizes() {
        return prizeService.getAllPrizes().stream()
                .map(prizeMapper::mapPrizeToPrizeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PrizeDTO addPrize(PrizeDTO prizeToAdd) {
        return prizeMapper.mapPrizeToPrizeDTO(prizeService.addPrize(prizeMapper.mapPrizeDTOtoPrize(prizeToAdd)));
    }

    @Override
    public PrizeDTO editPrize(PrizeDTO prizeToEdit) {
        return prizeMapper.mapPrizeToPrizeDTO(
                prizeService.editPrize(prizeMapper.mapPrizeDTOtoPrize(prizeToEdit))
        );
    }

    @Override
    public PrizeDTO findPrizeById(UUID id) {
        return prizeMapper.mapPrizeToPrizeDTO(prizeService.findPrizeById(id));
    }

    @Override
    public List<PrizeDTO> findPrizesByIsActive(Boolean isActive) {
        return prizeService.findPrizesByIsActive(isActive).stream()
                .map(prizeMapper::mapPrizeToPrizeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void changeActiveStatus(UUID id) {
        prizeService.changeActiveStatus(id);
    }
}
