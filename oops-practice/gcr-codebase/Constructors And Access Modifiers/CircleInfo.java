import java.util.Scanner;
class Circle{
    double radius;
    // default constructor
    Circle(){
        radius = 1.0;
    }
    // parameterized constructor
    Circle(double radius){
        this.radius = radius;
    }
    double area(){
        return 3.14 * radius * radius;
    }
    void displayInfo(){
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + area());
    }
}
public class CircleInfo {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        // Create object using default constructor
        Circle circle1 = new Circle();
        System.out.println("Circle with default radius:");
        circle1.displayInfo();
        System.out.println(); // Just for better readability
        // Create object using parameterized constructor
        System.out.print("Enter radius for the circle: ");
        double r = scanner.nextDouble();
        Circle circle2 = new Circle(r);
        System.out.println("Circle with radius " + r + ":");
        circle2.displayInfo();
        scanner.close(); 
    }
}
