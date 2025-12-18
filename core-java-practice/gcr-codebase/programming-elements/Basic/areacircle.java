import java.util.Scanner;

public class areacircle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);// Create a Scanner object for user input
        System.out.print("Enter the radius of the circle: "); 
        double radius = scanner.nextDouble(); 
        double area =  3.14 * radius * radius;
        System.out.println("The area of the circle with radius " + radius + " is: " + area);
        scanner.close();
    }
}