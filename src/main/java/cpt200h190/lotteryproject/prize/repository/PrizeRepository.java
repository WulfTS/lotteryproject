package cpt200h190.lotteryproject.prize.repository;

import cpt200h190.lotteryproject.prize.entity.Prize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PrizeRepository extends JpaRepository<Prize, UUID> {

    List<Prize> findPrizeByIsActive(Boolean isActive);

}
