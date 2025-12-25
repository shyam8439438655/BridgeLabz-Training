import java.util.Scanner;
public class QuotientAndReminder {
    // Method to find quotient and remainder
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;      // Calculating quotient
        int remainder = number % divisor;     // Calculating remainder
        return new int[]{quotient, remainder}; // Returning both as an array
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking inputs
        System.out.print("Enter the dividend (number): ");
        int number = scanner.nextInt();

        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();

        // Calling the method
        int[] result = findRemainderAndQuotient(number, divisor);
        int quotient = result[0];
        int remainder = result[1];

        // Output
        System.out.println("Quotient: " + quotient);
        System.out.println("Remainder: " + remainder);
        scanner.close();
    }
}