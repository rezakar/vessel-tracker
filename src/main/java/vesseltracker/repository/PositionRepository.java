package vesseltracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vesseltracker.model.Position;

public interface PositionRepository extends JpaRepository<Position, Integer> {
}
