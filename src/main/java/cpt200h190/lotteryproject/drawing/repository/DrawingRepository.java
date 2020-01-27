package cpt200h190.lotteryproject.drawing.repository;

import cpt200h190.lotteryproject.drawing.entity.Drawing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrawingRepository extends JpaRepository<Drawing, Long> {

    List<Drawing> findDrawingByIsActive(Boolean isActive);

}
