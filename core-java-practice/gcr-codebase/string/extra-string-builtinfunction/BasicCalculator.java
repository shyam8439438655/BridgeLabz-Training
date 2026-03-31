import java.util.Scanner;
public class BasicCalculator {
    // Function to take input from user
    public static double[] takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter the second number: ");
        double num2 = sc.nextDouble();
        return new double[]{num1, num2};
    }

    // Function for addition
    public static double add(double a, double b) {
        return a + b;
    }

    // Function for subtraction
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Function for multiplication
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Function for division
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return Double.NaN; // Return Not-a-Number
        }
        return a / b;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose an operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Enter your choice (1-4): ");
        int choice = sc.nextInt();

        double[] numbers = takeInput();
        double num1 = numbers[0];
        double num2 = numbers[1];
        double result;

        switch (choice) {
            case 1:
                result = add(num1, num2);
                System.out.println("Result: " + num1 + " + " + num2 + " = " + result);
                break;
            case 2:
                result = subtract(num1, num2);
                System.out.println("Result: " + num1 + " - " + num2 + " = " + result);
                break;
            case 3:
                result = multiply(num1, num2);
                System.out.println("Result: " + num1 + " * " + num2 + " = " + result);
                break;
            case 4:
                result = divide(num1, num2);
                if (!Double.isNaN(result)) {
                    System.out.println("Result: " + num1 + " / " + num2 + " = " + result);
                }
                break;
            default:
                System.out.println("Invalid choice. Please select a valid operation (1-4).");
        }
    }
}