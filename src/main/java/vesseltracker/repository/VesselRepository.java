package vesseltracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vesseltracker.model.Vessel;

import java.util.List;
import java.util.Optional;


public interface VesselRepository extends JpaRepository<Vessel, Integer> {

    List<Vessel> findByName(String name);
}
