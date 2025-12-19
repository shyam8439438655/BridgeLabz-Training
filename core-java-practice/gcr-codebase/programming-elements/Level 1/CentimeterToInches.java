import java.util.Scanner;
public class CentimeterToInches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Take height in centimeters
        double heightCm = scanner.nextDouble();

        // Convert cm to inches
        double totalInches = heightCm / 2.54;

        // Convert inches to feet and remaining inches
        int feet = (int) (totalInches / 12);
        double inches = totalInches % 12;

        // Output
        System.out.println("Your Height in cm is " + heightCm + " while in feet is " + feet  + inches);
        scanner.close();

    }
}
