import java.util.Scanner;

public class BookingRequest {


    private String name;
    private Occupancy occupancy;
    private Facility facility;
    private int floorNumber;
    private int duration;

    public BookingRequest(String name, Occupancy occupancy, Facility facility, int floorNumber) {
        this.name = name;
        this.occupancy = occupancy;
        this.facility = facility;
        this.floorNumber = floorNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Occupancy getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(Occupancy occupancy) {
        this.occupancy = occupancy;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public String toString() {
        return "BookingRequest{" +
                "name='" + name + '\'' +
                ", occupancy=" + occupancy +
                ", facility=" + facility +
                ", floorNumber=" + floorNumber +
                '}';
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
