import java.util.Scanner;
public class Trigonometric {
    // Method to calculate various trigonometric functions
    public static double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle); // Converting degrees to radians
        double sine = Math.sin(radians);        // Calculating sine
        double cosine = Math.cos(radians);      // Calculating cosine
        double tangent = Math.tan(radians);     // Calculating tangent
        return new double[]{sine, cosine, tangent}; // Returning all as an array
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input
        System.out.print("Enter the angle in degrees: ");
        double angle = scanner.nextDouble();

        // Calling the method
        double[] result = calculateTrigonometricFunctions(angle);
        double sine = result[0];
        double cosine = result[1];
        double tangent = result[2];

        // Output
        System.out.printf("Sine: %.4f%n", sine);
        System.out.printf("Cosine: %.4f%n", cosine);
        System.out.printf("Tangent: %.4f%n", tangent);
        scanner.close();
    }
}