import java.util.Scanner;

public class MovieTicketBookingApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Welcome to Movie Ticket Booking App ");
        System.out.print("Enter number of customers: ");
        int totalCustomers = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int customer = 1; customer <= totalCustomers; customer++) {
            System.out.println("\n--- Booking for Customer " + customer + " ---");

            //  Movie type
            System.out.println("Choose Movie Type:");
            System.out.println("1. Action");
            System.out.println("2. Comedy");
            System.out.println("3. Drama");
            System.out.print("Enter choice (1-3): ");
            int movieChoice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            String movieType;
            switch (movieChoice) {
                case 1:
                    movieType = "Action";
                    break;
                case 2:
                    movieType = "Comedy";
                    break;
                case 3:
                    movieType = "Drama";
                    break;
                default:
                    movieType = "Unknown";
                    System.out.println("Invalid choice, defaulting to Drama.");
                    break;
            }

            //  Seat type
            System.out.print("Enter Seat Type (Gold/Silver): ");
            String seatType = scanner.nextLine().trim().toLowerCase();

            int seatPrice;
            if (seatType.equals("gold")) {
                seatPrice = 300;
            } else if (seatType.equals("silver")) {
                seatPrice = 200;
            } else {
                seatPrice = 200; // default
                seatType = "Silver";
                System.out.println("Invalid seat type, defaulting to Silver.");
            }

            //  Snacks
            System.out.print("Do you want snacks? (yes/no): ");
            String snackChoice = scanner.nextLine().trim().toLowerCase();

            int snackPrice = 0;
            if (snackChoice.equals("yes")) {
                snackPrice = 100;
            }

            // Final Bill
            int totalBill = seatPrice + snackPrice;
            System.out.println("\nBooking Summary for Customer " + customer + ":");
            System.out.println("Movie: " + movieType);
            System.out.println("Seat Type: " + seatType + " (₹" + seatPrice + ")");
            System.out.println("Snacks: " + (snackPrice > 0 ? "Yes (₹100)" : "No"));
            System.out.println("Total Bill: ₹" + totalBill);
        }

        System.out.println("\n Thank you for booking with us! ");
        scanner.close();
    }
}