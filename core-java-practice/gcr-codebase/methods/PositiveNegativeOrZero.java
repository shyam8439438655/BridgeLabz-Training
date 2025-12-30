import java.util.Scanner;   
public class PositiveNegativeOrZero {
    // Method to check if number is positive, negative or zero
    public static int checkNumber(int number) {
        if (number > 0) {
            return 1;   // Positive
        } else if (number < 0) {
            return -1;  // Negative
        } else {
            return 0;   // Zero
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        // Calling the method
        int result = checkNumber(number);

        // Output based on result
        if (result == 1) {
            System.out.println(number + " is a positive number.");
        } else if (result == -1) {
            System.out.println(number + " is a negative number.");
        } else {
            System.out.println("The number is zero.");
        }
        scanner.close();
    }
}