public class Booking {
    private Customer customer;
    private BookingRequest bookingRequest;

    public Booking(Customer customer, BookingRequest bookingRequest) {
        this.customer = customer;
        this.bookingRequest = bookingRequest;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BookingRequest getBookingRequest() {
        return bookingRequest;
    }

    public void setBookingRequest(BookingRequest bookingRequest) {
        this.bookingRequest = bookingRequest;
    }

    public Room completeBooking(Inventory inventory) {
        Room room = inventory.isRoomAvailable(this.getBookingRequest());
        if (room != null) {
            System.out.println("Room is Available. Assigning you the room :)");
            this.customer.setRoomNum(room.getRoomNum());
            inventory.addRoomToCustomer(room, this.customer);
        }

        return room;
    }


}
