package vesseltracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vesseltracker.model.VesselTracker;

public interface VesselTrackerRepository extends JpaRepository<VesselTracker, Integer> {
}
