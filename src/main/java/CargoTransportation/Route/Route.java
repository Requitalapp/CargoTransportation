package CargoTransportation.Route;

import javax.persistence.*;

@Entity
@Table(name = "route")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int routeid;
    private String startpoint;
    private String endpoint;
    private Integer distance;
    private int activesign;

    protected Route() {
    }

    public Route(String startpoint, String endpoint, Integer distance) {
        this.startpoint = startpoint;
        this.endpoint = endpoint;
        this.distance = distance;
        this.activesign = 1;
    }

    public int getRouteid() {
        return routeid;
    }

    public String getStartpoint() {
        return startpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public Integer getDistance() {
        return distance;
    }

    public int getActivesign() {
        return activesign;
    }

    public void setActivesign(int activesign) {
        this.activesign = activesign;
    }

    public void setRouteid(int routeid) {
        this.routeid = routeid;
    }

    public void setStartpoint(String startpoint) {
        this.startpoint = startpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return String.format(startpoint + "; " + endpoint + "; " + distance);
    }
}
