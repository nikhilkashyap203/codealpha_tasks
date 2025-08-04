package hotel_reservation_system;

import java.time.LocalDate;

public class Booking {
    private final String bookingId;
    private final String customerName;
    private final int roomNumber;
    private final LocalDate checkIn;
    private final LocalDate checkOut;
    private final boolean isPaid;

    public Booking(String bookingId, String customerName, int roomNumber, LocalDate checkIn, LocalDate checkOut, boolean isPaid) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.isPaid = isPaid;
    }

    public String getBookingId() { return bookingId; }
    public String getCustomerName() { return customerName; }
    public int getRoomNumber() { return roomNumber; }
    public LocalDate getCheckIn() { return checkIn; }
    public LocalDate getCheckOut() { return checkOut; }
    public boolean isPaid() { return isPaid; }

    @Override
    public String toString() {
        return bookingId + "," + customerName + "," + roomNumber + "," + checkIn + "," + checkOut + "," + isPaid;
    }
}