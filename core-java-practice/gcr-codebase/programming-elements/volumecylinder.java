import java.util.Scanner;

public class volumecylinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the radius of the cylinder:");
        double radius = scanner.nextDouble();
        System.out.println("Enter the height of the cylinder:");    
        double height = scanner.nextDouble();
        double volume = 3.14 * radius * radius * height;
        System.out.println("The volume of the cylinder is: " + volume);
        scanner.close();
    }
}
