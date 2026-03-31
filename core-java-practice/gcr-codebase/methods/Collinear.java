import java.util.Scanner;

public class Collinear {

    // Method to check collinearity using slope formula (AB = BC = AC)
    public static boolean isCollinearBySlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        // Use cross multiplication to avoid division
        int slopeAB = (y2 - y1) * (x3 - x2);
        int slopeBC = (y3 - y2) * (x2 - x1);
        int slopeAC = (y3 - y1) * (x2 - x1);

        return slopeAB == slopeBC && slopeBC == slopeAC;
    }

    // Method to check collinearity using area of triangle formula
    public static boolean isCollinearByArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        int area = x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2);
        return area == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input 3 points
        System.out.println("Enter coordinates of Point A (x1 y1):");
        int x1 = sc.nextInt(), y1 = sc.nextInt();

        System.out.println("Enter coordinates of Point B (x2 y2):");
        int x2 = sc.nextInt(), y2 = sc.nextInt();

        System.out.println("Enter coordinates of Point C (x3 y3):");
        int x3 = sc.nextInt(), y3 = sc.nextInt();

        // Check using slope method
        boolean slopeResult = isCollinearBySlope(x1, y1, x2, y2, x3, y3);
        System.out.println("\nUsing Slope Method:");
        System.out.println(slopeResult ? "✅ Points are Collinear" : "❌ Points are NOT Collinear");

        // Check using area method
        boolean areaResult = isCollinearByArea(x1, y1, x2, y2, x3, y3);
        System.out.println("\nUsing Area Method:");
        System.out.println(areaResult ? "✅ Points are Collinear" : "❌ Points are NOT Collinear");

        sc.close();
    }
}