import java.util.Scanner;
public class LineCompariosnProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Start with Displaying Welcome to Line Comparison Computation Program on Master Branch

        System.out.println("Welcome to Line Comparison Computation Program on Master Branch");

        //Use Case 1 : Calculate its Length

        System.out.println("Enter the coordinates of the first point (x1 y1): ");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        System.out.println("Enter the coordinates of the second point (x2 y2): ");
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        double length = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        System.out.println("Length of the line segment: " + length);

        //Use Case 2 : Equality Of Two Lines 

        System.out.println("Enter the coordinates of the third point (U1 V1): ");
        int U1 = scanner.nextInt();
        int V1 = scanner.nextInt();
        System.out.println("Enter the coordinates of the fourth point (U2 V2): ");
        int U2 = scanner.nextInt();
        int V2 = scanner.nextInt();
        double length2 = Math.sqrt(Math.pow((U2 - U1), 2) + Math.pow((V2 - V1), 2));
        System.out.println("Length of the second line segment: " + length2);
        if (length == length2) {
            System.out.println("The two lines are equal in length.");
        } else {
            System.out.println("The two lines are not equal in length.");
        }

        //Use Case 3 : Compare of Lines 

        if (length > length2) {
            System.out.println("The first line is longer than the second line.");
        } else if (length < length2) {
            System.out.println("The first line is shorter than the second line.");
        } else {
            System.out.println("Both lines are of equal length.");
        }
        scanner.close();

    }
}
