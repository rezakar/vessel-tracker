package vesseltracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
public class Vessel implements Serializable {

    @Id
    @GeneratedValue
    private Integer vesselId;

    private String name;

    @OneToMany
    private List<Position> positions;

    public Vessel(String name, List<Position> positions) {
        this.name = name;
        this.positions = positions;
    }

    public Vessel() {
    }

    public Integer getVesselId() {
        return vesselId;
    }

    public void setVesselId(Integer vesselId) {
        this.vesselId = vesselId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Position> getPosition() {
        return positions;
    }

    public void setPosition(List<Position> position) {
        this.positions = position;
    }

    @Override
    public String toString() {
        return "Vessel{" +
                "vesselId=" + vesselId +
                ", name='" + name + '\'' +
                ", position=" + positions +
                '}';
    }
}
