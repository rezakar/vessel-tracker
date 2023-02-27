package vesseltracker.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vesseltracker.service.VesselTrackerService;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class VesselTrackerController {

    private VesselTrackerService vesselTrackerService;

    public VesselTrackerController(VesselTrackerService vesselTrackerService) {
        this.vesselTrackerService = vesselTrackerService;
    }

    @GetMapping(path = "/allVesselTracker")
    public List<vesseltracker.model.VesselTracker> getAllVesselTracker() {
        return vesselTrackerService.createVesselTracker();
    }
}
