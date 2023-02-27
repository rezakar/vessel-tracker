package vesseltracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import vesseltracker.model.Position;

@CrossOrigin("http://localhost:4200")
public interface PositionRepository extends JpaRepository<Position, Integer> {
}
