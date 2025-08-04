import java.time.LocalDate;
import java.util.Scanner;

public class ReservationSystem {
    public static void main(String[] args) throws Exception {
        Hotel hotel = new Hotel();
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n--- Hotel Reservation System ---");
                System.out.println("1. Search Rooms");
                System.out.println("2. Book Room");
                System.out.println("3. Cancel Booking");
                System.out.println("4. View Bookings");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();
                sc.nextLine(); // consume leftover newline

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter category (Standard/Deluxe/Suite): ");
                        hotel.searchRooms(sc.nextLine());
                    }
                    case 2 -> {
                        System.out.print("Customer Name: ");
                        String name = sc.nextLine();
                        System.out.print("Room Category: ");
                        String cat = sc.nextLine();
                        System.out.print("Check-in date (YYYY-MM-DD): ");
                        LocalDate in = LocalDate.parse(sc.nextLine());
                        System.out.print("Check-out date (YYYY-MM-DD): ");
                        LocalDate out = LocalDate.parse(sc.nextLine());
                        hotel.bookRoom(name, cat, in, out);
                    }
                    case 3 -> {
                        System.out.print("Enter Booking ID to cancel: ");
                        hotel.cancelBooking(sc.nextLine());
                    }
                    case 4 -> hotel.viewBookings();
                    case 5 -> {
                        System.out.println("Thank you!");
                        return;
                    }
                    default -> System.out.println("Invalid choice.");
                }
            }
        }
    }
}