import java.util.Scanner;
public class DistanceAndMiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Take distance in feet
        double distanceInFeet = scanner.nextDouble();

        // Convert feet to yards
        double yards = distanceInFeet / 3;

        // Convert yards to miles
        double miles = yards / 1760;

        // Output the results
        System.out.println("The distance in feet is " + distanceInFeet +
                           " while in yards is " + yards +
                           " and miles is " + miles);
        scanner.close();
    }
}
