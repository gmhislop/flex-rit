package Model;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String fromLocation;
    private String toLocation;
    private LocalDateTime date;
    private float distance;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Vehicle vehicle;

    public long getTripid() {
        return id;
    }

    public void setTripid(long tripid) {
        this.id = tripid;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}
