package hotel_reservation_system;

public class Room {
    private final int roomNumber;
    private final String category;
    private boolean isAvailable;

    public Room(int roomNumber, String category, boolean isAvailable) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isAvailable = isAvailable;
    }

    public int getRoomNumber() { return roomNumber; }
    public String getCategory() { return category; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    @Override
    public String toString() {
        return roomNumber + "," + category + "," + isAvailable;
    }
}