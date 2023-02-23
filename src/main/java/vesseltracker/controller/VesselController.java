package vesseltracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vesseltracker.model.Vessel;
import vesseltracker.service.VesselService;

import java.util.List;
import java.util.Optional;

@RestController
public class VesselController {

    private VesselService vesselService;

    public VesselController(VesselService vesselService) {
        this.vesselService = vesselService;
    }

    @GetMapping(path = "/allVessel")
    public List<Vessel> getAllVessel() {
        return vesselService.getAllVesssel();
    }

    @GetMapping(path = "/getVessel/name")
    public List<Vessel> getAVessel(@RequestParam String name) {
        return vesselService.getVesselByName(name);
    }
}
