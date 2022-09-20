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

    public boolean completeBooking(){
        return true;
    }
}
