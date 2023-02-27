package vesseltracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class VesselTracker {

    @Id
    @GeneratedValue
    private Integer vesselTrackerId;

    private Double speedAverage;

    private Integer distanceTravelled;

    private String vesselName;

    public VesselTracker(Double speedAverage, Integer distanceTravelled, String vesselName) {
        this.speedAverage = speedAverage;
        this.distanceTravelled = distanceTravelled;
        this.vesselName = vesselName;
    }

    public VesselTracker() {
    }

    public Integer getVesselTrackerId() {
        return vesselTrackerId;
    }

    public void setVesselTrackerId(Integer vesselTrackerId) {
        this.vesselTrackerId = vesselTrackerId;
    }

    public Double getSpeedAverage() {
        return speedAverage;
    }

    public void setSpeedAverage(Double speedAverage) {
        this.speedAverage = speedAverage;
    }

    public Integer getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(Integer distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }
}
