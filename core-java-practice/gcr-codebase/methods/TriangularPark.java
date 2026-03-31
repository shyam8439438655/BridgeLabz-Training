import java.util.Scanner;
public class TriangularPark {
    // Method to calculate number of rounds
    public static double calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;   // Perimeter of triangle
        double totalDistance = 5000;                // 5 km = 5000 meters
        return totalDistance / perimeter;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Taking inputs
        System.out.print("Enter side 1 of the park (in meters): ");
        double s1 = input.nextDouble();

        System.out.print("Enter side 2 of the park (in meters): ");
        double s2 = input.nextDouble();

        System.out.print("Enter side 3 of the park (in meters): ");
        double s3 = input.nextDouble();

        // Calling the method
        double rounds = calculateRounds(s1, s2, s3);

        // Output
        System.out.println("The athlete must complete " + rounds + " rounds to finish a 5 km run.");
        input.close();
    }
}
