 
import java.util.Scanner;
public class NumberOfChocolates {
    // Method to find chocolates per child and remaining chocolates
    public static int[] findChocolatesDistribution(int number, int divisor) {
        int chocolatesPerChild = number / divisor; // Calculating chocolates per child
        int remainingChocolates = number % divisor; // Calculating remaining chocolates
        return new int[]{chocolatesPerChild, remainingChocolates}; // Returning both as an array
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking inputs
        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = scanner.nextInt();

        System.out.print("Enter the number of children: ");
        int numberOfChildren = scanner.nextInt();

        // Calling the method
        int[] result = findChocolatesDistribution(numberOfChocolates, numberOfChildren);
        int chocolatesPerChild = result[0];
        int remainingChocolates = result[1];

        // Output
        System.out.println("Each child will get " + chocolatesPerChild + " chocolates.");
        System.out.println("Remaining chocolates: " + remainingChocolates);
        scanner.close();
    }
}