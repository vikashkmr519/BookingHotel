public class Room {

    private int roomNum;

    private Occupancy occupancy;

    private Customer customer;

    private int floorNum;

    boolean roomStatus;

    private Facility facility;

    public Room(int roomNum, Occupancy occupancy, int floorNum, boolean roomStatus, Facility facility) {
        this.roomNum = roomNum;
        this.occupancy = occupancy;
        this.floorNum = floorNum;
        this.roomStatus = roomStatus;
        this.facility = facility;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Occupancy getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(Occupancy occupancy) {
        this.occupancy = occupancy;
    }

    public int getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(int floorNum) {
        this.floorNum = floorNum;
    }

    public boolean isRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(boolean roomStatus) {
        this.roomStatus = roomStatus;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }
}
