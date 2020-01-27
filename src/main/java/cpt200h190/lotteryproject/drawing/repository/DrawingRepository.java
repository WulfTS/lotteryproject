package cpt200h190.lotteryproject.drawing.repository;

import cpt200h190.lotteryproject.drawing.entity.Drawing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DrawingRepository extends JpaRepository<Drawing, UUID> {

    List<Drawing> findDrawingByIsActive(Boolean isActive);

}
