package cpt200h190.lotteryproject.drawing.repository;

import cpt200h190.lotteryproject.drawing.entity.Drawing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DrawingRepository extends JpaRepository<Drawing, UUID> {

    List<Drawing> findDrawingByIsActive(Boolean isActive);

}
