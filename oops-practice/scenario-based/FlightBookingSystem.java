import java.util.ArrayList;
import java.util.Scanner;

//  FLIGHT CLASS 
class Flight {
    int flightId;
    String flightName;
    String source;
    String destination;
    int seats;

    Flight(int flightId, String flightName, String source, String destination, int seats) {
        this.flightId = flightId;
        this.flightName = flightName;
        this.source = source;
        this.destination = destination;
        this.seats = seats;
    }

    void displayFlight() {
        System.out.println("Flight ID   : " + flightId);
        System.out.println("Flight Name : " + flightName);
        System.out.println("From        : " + source);
        System.out.println("To          : " + destination);
        System.out.println("Seats Left  : " + seats);
    }
}

//  BOOKING CLASS 
class Booking {
    String passengerName;
    Flight flight;

    Booking(String passengerName, Flight flight) {
        this.passengerName = passengerName;
        this.flight = flight;
    }

    void displayBooking() {
        System.out.println("Passenger Name : " + passengerName);
        System.out.println("Booked Flight  : " + flight.flightName);
        System.out.println("Route          : " + flight.source + " -> " + flight.destination);
    }
}

// MAIN CLASS
public class FlightBookingSystem {

    static Scanner sc = new Scanner(System.in);

    // Array to store flights
    static Flight[] flights = {
        new Flight(101, "Air India", "Delhi", "Mumbai", 5),
        new Flight(102, "Indigo", "Delhi", "Bangalore", 3),
        new Flight(103, "Vistara", "Mumbai", "Chennai", 4),
        new Flight(104, "SpiceJet", "Pune", "Delhi", 2)
    };

    // List to store bookings
    static ArrayList<Booking> bookings = new ArrayList<>();

    public static void main(String[] args) {

        int choice = 0;

        while (choice != 4) {

            System.out.println("\n--- Flight Booking System ---");
            System.out.println("1. Search Flight");
            System.out.println("2. Book Flight");
            System.out.println("3. View Bookings");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                searchFlight();
            } 
            else if (choice == 2) {
                bookFlight();
            } 
            else if (choice == 3) {
                viewBookings();
            } 
            else if (choice == 4) {
                System.out.println("Thank you for using Flight Booking System!");
            } 
            else {
                System.out.println("Invalid choice!");
            }
        }
    }

    //  SEARCH 
    static void searchFlight() {

        System.out.print("Enter Source: ");
        String src = sc.nextLine();

        System.out.print("Enter Destination: ");
        String dest = sc.nextLine();

        boolean found = false;

        for (Flight f : flights) {
            if (f.source.equalsIgnoreCase(src) &&
                f.destination.equalsIgnoreCase(dest)) {

                System.out.println("--------------------");
                f.displayFlight();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No flights found for this route.");
        }
    }

    // BOOK 
    static void bookFlight() {

        System.out.print("Enter Flight ID to book: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Passenger Name: ");
        String name = sc.nextLine();

        for (Flight f : flights) {
            if (f.flightId == id) {

                if (f.seats > 0) {
                    f.seats--;
                    bookings.add(new Booking(name, f));
                    System.out.println("Flight Booked Successfully!");
                } 
                else {
                    System.out.println("Sorry! No seats available.");
                }
                return;
            }
        }

        System.out.println("Invalid Flight ID!");
    }

    // VIEW BOOKINGS
    static void viewBookings() {

        if (bookings.size() == 0) {
            System.out.println("No bookings found.");
            return;
        }

        for (Booking b : bookings) {
            System.out.println("--------------------");
            b.displayBooking();
        }
    }
}
