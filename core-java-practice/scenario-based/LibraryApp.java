import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Welcome to Rohan's Library Reminder App ");
        System.out.println("Fine Policy: ₹10 per day if book is returned late.\n");

        // Loop for 5 books
        for (int book = 1; book <= 5; book++) {
            System.out.println("--- Book " + book + " ---");

            // Input due date
            System.out.print("Enter Due Date (in days, e.g. 10): ");
            int dueDate = scanner.nextInt();

            // Input return date
            System.out.print("Enter Return Date (in days, e.g. 12): ");
            int returnDate = scanner.nextInt();

            // Calculate fine
            int fine = 0;
            if (returnDate > dueDate) {
                int lateDays = returnDate - dueDate;
                fine = lateDays * 10; // ₹10 per day
            }

            // Show result
            System.out.println("Result for Book " + book + ":");
            if (fine > 0) {
                System.out.println("Returned Late! Fine = ₹" + fine);
            } else {
                System.out.println("Returned On Time. No Fine!");
            }
            System.out.println();
        }

        System.out.println(" All books processed. Thank you!");
        scanner.close();
    }
}