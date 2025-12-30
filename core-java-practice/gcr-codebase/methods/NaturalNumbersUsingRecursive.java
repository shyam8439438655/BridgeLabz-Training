import java.util.Scanner;
public class NaturalNumbersUsingRecursive {
    // Method to calculate sum of n natural numbers using recursion
    public static int sumUsingRecursion(int n) {
        if (n == 1) {
            return 1; // Base case
        }
        return n + sumUsingRecursion(n - 1); // Recursive case
    }

    // Method to calculate sum of n natural numbers using formula
    public static int sumUsingFormula(int n) {
        return n * (n + 1) / 2; // Formula for sum of first n natural numbers
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input
        System.out.print("Enter a natural number: ");
        int number = scanner.nextInt();

        if (number <= 0) {
            System.out.println("Please enter a valid natural number greater than 0.");
        } else {
            // Calculating sums
            int sumRecursion = sumUsingRecursion(number);
            int sumFormula = sumUsingFormula(number);

            // Displaying results
            System.out.println("Sum using recursion: " + sumRecursion);
            System.out.println("Sum using formula: " + sumFormula);

            // Comparing results
            if (sumRecursion == sumFormula) {
                System.out.println("Both methods give the same result.");
            } else {
                System.out.println("The results differ.");
            }
        }
        scanner.close();
    }
}