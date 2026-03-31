import java.util.Scanner;
public class Armstrong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        int originalNumber = number;
        int sum = 0;
        while (originalNumber != 0) {
            int digit = originalNumber % 10; // Get the last digit
            sum += Math.pow(digit, 3); // Add the cube of the digit to sum
            originalNumber /= 10; // Remove the last digit
        }
        if (sum == number) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }
        scanner.close();
    }
}
