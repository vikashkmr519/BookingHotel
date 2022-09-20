public class Customer {
    private String name;
    private int customerId;
    private  Occupancy occupancyRequired;

    private int roomNum;

    public Customer(String name, int customerId, Occupancy occupancyRequired) {
        this.name = name;
        this.customerId = customerId;
        this.occupancyRequired = occupancyRequired;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Occupancy getOccupancyRequired() {
        return occupancyRequired;
    }

    public void setOccupancyRequired(Occupancy occupancyRequired) {
        this.occupancyRequired = occupancyRequired;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }
}
