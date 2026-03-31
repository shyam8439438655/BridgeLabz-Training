class MovieTicket {
    
    String movieName;
    String seatNumber;
    double price;
    boolean isBooked; // To track if the ticket is booked

    // Constructor (initially ticket not booked)
    MovieTicket() {
        this.isBooked = false;
    }

    // Method to book a ticket
    void bookTicket(String movieName, String seatNumber, double price) {
        if (!isBooked) {
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.price = price;
            this.isBooked = true;
            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: $" + price);
        } else {
            System.out.println("House full!!! sorry..... Ticket already booked");
        }
    }

    // Method to display ticket details
    void displayDetails() {
        if (!isBooked) {
            System.out.println("Ticket have not booked yet....");
        } else {
            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: $" + price);
        }
    }
}

// Main class
public class MovieTicketSystem {
    public static void main(String[] args) {
        // Create a MovieTicket object
        MovieTicket ticket = new MovieTicket();

        // Display initial state
        ticket.displayDetails();

        // Book the ticket
        ticket.bookTicket("Dragon", "A10", 120.0);

        // Try booking again (should show already booked message)
        ticket.bookTicket("Dragon", "A10", 120.0);
        ticket.bookTicket("Dragon", "A10", 120.0);

        // Display final ticket details
        System.out.println();
        ticket.displayDetails();
    }
}