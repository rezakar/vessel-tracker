package vesseltracker.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Position implements Serializable {

    @Id
    @GeneratedValue
    private Integer positionId;

    private Integer x;

    private Integer y;

    private String timestamp;

    public Position(Integer x, Integer y, String timestamp) {
        this.x = x;
        this.y = y;
        this.timestamp = timestamp;
    }

    public Position() {
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Position{" +
                "positionId=" + positionId +
                ", x=" + x +
                ", y=" + y +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
