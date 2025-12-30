import java.util.Scanner;
public class HarshadNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        int originalNumber = number;
        int sum = 0;
        // Loop to calculate the sum of digits
        while (originalNumber != 0) {
            int digit = originalNumber % 10; // Get the last digit
            sum += digit; // Add the digit to sum
            originalNumber /= 10; // Remove the last digit
        }
        // Check if the number is divisible by the sum of its digits
        if (number % sum == 0) {
            System.out.println(number + " is a Harshad Number.");
        } else {
            System.out.println(number + " is not a Harshad Number.");
        }
        scanner.close();
    }
}
