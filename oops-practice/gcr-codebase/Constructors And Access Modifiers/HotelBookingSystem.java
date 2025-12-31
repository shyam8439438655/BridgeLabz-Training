class Hotel{
    String guestName;
    String roomType;
    int nights;
    // default constructor
    Hotel(){
        guestName = "";
        roomType = "";
        nights = 1;
    }
    // parameterized constructor
    Hotel(String guestName, String roomType, int nights){
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }
    // copy constructor
    Hotel(Hotel h){
        this.guestName = h.guestName;
        this.roomType = h.roomType;
        this.nights = h.nights;
    }

    void displayBookingDetails(){
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Nights: " + nights);
    }

}
public class HotelBookingSystem {
    public static void main(String[] args) {
        // Create object using default constructor
        Hotel booking1 = new Hotel();
        System.out.println("Default Booking Details:");
        booking1.displayBookingDetails();

        System.out.println(); // Just for better readability

        // Create object using parameterized constructor
        Hotel booking2 = new Hotel("Prince", "Deluxe", 3);
        System.out.println("Parameterized Booking Details:");
        booking2.displayBookingDetails();
        System.out.println(); // Just for better readability

        // Create object using copy constructor
        Hotel booking3 = new Hotel(booking2);
        System.out.println("Copy of Parameterized Booking Details:");
        booking3.displayBookingDetails();
    }
}
