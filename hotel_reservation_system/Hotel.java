import hotel_reservation_system.Booking;
import hotel_reservation_system.Room;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Hotel {
    private final List<Room> rooms = new ArrayList<>();
    private final List<Booking> bookings = new ArrayList<>();

    public Hotel() {
        loadRooms();
        loadBookings();
    }

    // Load rooms from file
    private void loadRooms() {
        try (BufferedReader br = new BufferedReader(new FileReader("rooms.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                rooms.add(new Room(Integer.parseInt(data[0]), data[1], Boolean.parseBoolean(data[2])));
            }
        } catch (IOException e) {
            System.out.println("Rooms file missing.");
        }
    }

    // Load bookings from file
    private void loadBookings() {
        try (BufferedReader br = new BufferedReader(new FileReader("bookings.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                bookings.add(new Booking(
                    data[0], data[1], Integer.parseInt(data[2]),
                    LocalDate.parse(data[3]), LocalDate.parse(data[4]), Boolean.parseBoolean(data[5])
                ));
            }
        } catch (IOException e) {
            System.out.println("Bookings file missing.");
        }
    }

    // Save updated rooms
    private void saveRooms() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("rooms.txt"))) {
            for (Room r : rooms) {
                bw.write(r.toString());
                bw.newLine();
            }
        }
    }

    // Save updated bookings
    private void saveBookings() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("bookings.txt"))) {
            for (Booking b : bookings) {
                bw.write(b.toString());
                bw.newLine();
            }
        }
    }

    public void searchRooms(String category) {
        for (Room r : rooms) {
            if (r.getCategory().equalsIgnoreCase(category) && r.isAvailable()) {
                System.out.println("Available Room: " + r.getRoomNumber());
            }
        }
    }

    public void bookRoom(String customer, String category, LocalDate checkIn, LocalDate checkOut) throws IOException {
        for (Room r : rooms) {
            if (r.getCategory().equalsIgnoreCase(category) && r.isAvailable()) {
                r.setAvailable(false);
                String bookingId = "BKG" + (bookings.size() + 1);
                Booking b = new Booking(bookingId, customer, r.getRoomNumber(), checkIn, checkOut, true);
                bookings.add(b);
                saveRooms();
                saveBookings();
                System.out.println("Booking Successful! ID: " + bookingId);
                return;
            }
        }
        System.out.println("No available rooms in this category.");
    }

    public void cancelBooking(String bookingId) throws IOException {
        Iterator<Booking> it = bookings.iterator();
        while (it.hasNext()) {
            Booking b = it.next();
            if (b.getBookingId().equals(bookingId)) {
                for (Room r : rooms) {
                    if (r.getRoomNumber() == b.getRoomNumber()) {
                        r.setAvailable(true);
                        break;
                    }
                }
                it.remove();
                saveRooms();
                saveBookings();
                System.out.println("Booking cancelled.");
                return;
            }
        }
        System.out.println("Booking not found.");
    }

    public void viewBookings() {
        for (Booking b : bookings) {
            System.out.println("Booking ID: " + b.getBookingId() + ", Name: " + b.getCustomerName() + ", Room: " + b.getRoomNumber());
        }
    }
}