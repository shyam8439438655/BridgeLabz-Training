import java.util.Scanner;
public class SumOfNaturalNumber {
    // Method to calculate sum of n natural numbers
    public static int calculateSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;  // Adding each natural number to sum
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input
        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();

        // Calling the method
        int sum = calculateSum(n);

        // Output
        System.out.println("The sum of first " + n + " natural numbers is: " + sum);
        scanner.close();
    }
}