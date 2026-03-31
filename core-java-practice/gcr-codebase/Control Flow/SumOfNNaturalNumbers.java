import java.util.Scanner;
public class SumOfNNaturalNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("Please enter a natural number.");
            scanner.close();
            return;
        }
        int sumFormula = n * (n + 1) / 2;
        int sumLoop = 0;
        for (int i = 1; i <= n; i++) {
            sumLoop += i;
        }
        System.out.println("Sum using formula: " + sumFormula);
        System.out.println("Sum using loop: " + sumLoop);
        if (sumFormula == sumLoop) {
            System.out.println("Both computations are correct.");
        } else {
            System.out.println("There is an error in the computations.");
        }
        scanner.close();
    }
}
