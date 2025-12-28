import java.util.Scanner;
public class FactUsingRecursion {

    // Function to take input from user
    public static int takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to calculate its factorial: ");
        int number = sc.nextInt();
        return number;
    }

    // Recursive function to calculate factorial
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1; // Base case
        } else {
            return n * factorial(n - 1); // Recursive case
        }
    }

    // Main method
    public static void main(String[] args) {
        int number = takeInput();
        int result = factorial(number);

        // Display result
        System.out.println("The factorial of " + number + " is: " + result);
    }
}