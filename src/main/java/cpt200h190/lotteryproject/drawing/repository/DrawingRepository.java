package cpt200h190.lotteryproject.drawing.repository;

import cpt200h190.lotteryproject.drawing.entity.Drawing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrawingRepository extends JpaRepository<Drawing, Long> {
}
