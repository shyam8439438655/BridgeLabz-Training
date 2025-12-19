import java.util.Scanner;
public class SquareParimeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Take user input for perimeter
        double perimeter = scanner.nextDouble();

        // Calculate side of the square
        double side = perimeter / 4;

        // Output
        System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);

        scanner.close();
    }
}
