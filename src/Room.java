public class Room {

    private int roomNum;

    private Occupancy occupancy;

    private Customer customer;

    private int floorNum;

    boolean roomEmpty;

    private Facility facility;

    private double price ;

    public Room(int roomNum, Occupancy occupancy, int floorNum, boolean roomStatus, Facility facility,double price) {
        this.roomNum = roomNum;
        this.occupancy = occupancy;
        this.floorNum = floorNum;
        this.roomEmpty = roomStatus;
        this.facility = facility;
        this.price = price;
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

    public boolean isRoomEmpty() {
        return roomEmpty;
    }

    public void setRoomEmpty(boolean roomStatus) {
        this.roomEmpty = roomStatus;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
