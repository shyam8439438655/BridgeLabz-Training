import java.util.Scanner;

class GeometryUtility {

    //  Method to calculate Euclidean distance
    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        // Distance formula: sqrt((x2-x1)^2 + (y2-y1)^2)
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return distance;
    }

    //  Method to calculate line equation y = m*x + b
    // Returns array → [0] = slope (m), [1] = y-intercept (b)
    public static double[] lineEquation(double x1, double y1, double x2, double y2) {
        double m, b;

        if (x2 - x1 == 0) {
            // Vertical line → slope undefined
            m = Double.POSITIVE_INFINITY;
            b = Double.NaN; // Not applicable
        } else {
            m = (y2 - y1) / (x2 - x1);  // slope
            b = y1 - m * x1;             // y-intercept
        }

        return new double[]{m, b};
    }
}
public class DistanceAndLine {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take input for two points
        System.out.print("Enter x1: ");
        double x1 = sc.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = sc.nextDouble();
        System.out.print("Enter x2: ");
        double x2 = sc.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = sc.nextDouble();

        // Step 2: Calculate Euclidean distance
        double distance = GeometryUtility.calculateDistance(x1, y1, x2, y2);
        System.out.printf("\nEuclidean distance between the two points: %.4f\n", distance);

        // Step 3: Calculate line equation
        double[] line = GeometryUtility.lineEquation(x1, y1, x2, y2);

        // Step 4: Display line equation
        if (Double.isInfinite(line[0])) {
            System.out.println("The line is vertical: x = " + x1);
        } else {
            System.out.printf("Equation of the line: y = %.4fx + %.4f\n", line[0], line[1]);
        }
        sc.close();
    }
}
