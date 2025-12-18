import java.util.Scanner;
public class TriangleAreaaaa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take base and height as input
        double base = sc.nextDouble();
        double height = sc.nextDouble();
        // Calculate area in square inches
        double areaInches = 0.5 * base * height;
        // Convert area to square centimeters (1 inch = 2.54 cm)
        double areaCm = areaInches * (2.54 * 2.54);
        // Output the area in square centimeters
        System.out.println("The area of the triangle in square inches is " + areaInches + " and in square centimeters is " + areaCm);
        sc.close();
    }
}
