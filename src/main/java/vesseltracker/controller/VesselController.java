package vesseltracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vesseltracker.model.Vessel;
import vesseltracker.service.VesselService;

import java.util.List;

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
