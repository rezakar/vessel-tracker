package vesseltracker.service;

import org.springframework.stereotype.Service;
import vesseltracker.model.Position;
import vesseltracker.model.Vessel;
import vesseltracker.repository.VesselRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VesselService {

    private VesselRepository vesselRepository;

    private PositionService positionService;


    public VesselService(VesselRepository vesselRepository, PositionService positionService) {
        this.vesselRepository = vesselRepository;
        this.positionService = positionService;
    }

    public Vessel createAVessel(String name, List<Position> positions) {
        List<Position> positionCreatedList = positionService.CreateListPosition(positions);
        return vesselRepository.save(new Vessel(name, positionCreatedList));
    }

    public List<Vessel> createListVessel(List<Vessel> vesselList) {
        List<Vessel> vesselCreatedList = vesselList.stream().map(vessel -> {
            return createAVessel(vessel.getName(), vessel.getPosition().stream().toList());
        }).collect(Collectors.toList());
        return vesselCreatedList;
    }

    public List<Vessel> getAllVesssel() {
        return vesselRepository.findAll();
    }

    public List<Vessel> getVesselByName(String name) {
        return vesselRepository.findByName(name);
    }

}
