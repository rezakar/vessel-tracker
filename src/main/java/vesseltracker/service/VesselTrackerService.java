package vesseltracker.service;

import org.springframework.stereotype.Service;
import vesseltracker.Utils.Utils;
import vesseltracker.model.Vessel;
import vesseltracker.model.VesselTracker;
import vesseltracker.repository.VesselRepository;
import vesseltracker.repository.VesselTrackerRepository;

import java.util.List;

@Service
public class VesselTrackerService {


    private Utils utils = new Utils();
    private VesselTrackerRepository vesselTrackerRepository;
    private VesselRepository vesselRepository;

    public VesselTrackerService(VesselTrackerRepository vesselTrackerRepository, VesselRepository vesselRepository) {
        this.vesselTrackerRepository = vesselTrackerRepository;
        this.vesselRepository = vesselRepository;
    }

    public List<VesselTracker> createVesselTracker(){

        List<Vessel> vesselList = vesselRepository.findAll();
        vesselList.stream().forEach(temp -> {
        this.createAVesselTracker(
                this.utils.getVesselSpeed(temp),
                this.utils.getVesselDistance(temp),
                temp.getName()
        );
        });

        return vesselTrackerRepository.findAll();
    }

    public VesselTracker createAVesselTracker(Double speed, int distance, String name) {
        return vesselTrackerRepository.save(new VesselTracker(speed, distance, name));
    }


}
