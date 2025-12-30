class Circle {
    
    double radius;

    // Constructor to initialize radius
    Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate area
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Method to calculate circumference
    double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    // Method to display results
    void displayDetails() {
        System.out.printf("Area of circle: %.4f\n", calculateArea());
        System.out.printf("Circumference of circle: %.4f\n", calculateCircumference());
    }
}

// Main class
public class AreaOfCircle {
    public static void main(String[] args) {
        // Create Circle object with radius = 2.5
        Circle circle = new Circle(2.5);

        // Display area and circumference
        circle.displayDetails();
    }
}