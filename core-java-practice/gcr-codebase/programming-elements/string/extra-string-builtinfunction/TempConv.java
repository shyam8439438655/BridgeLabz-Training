import java.util.Scanner;
public class TempConv {

    // Function to take input from user
    public static double takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature value: ");
        double temp = sc.nextDouble();
        return temp;
    }

    // Function to convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    // Function to convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose conversion type:");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = sc.nextInt();

        double inputTemp = takeInput();
        double convertedTemp;

        if (choice == 1) {
            convertedTemp = fahrenheitToCelsius(inputTemp);
            System.out.printf("%.2f Fahrenheit is equal to %.2f Celsius.%n", inputTemp, convertedTemp);
        } else if (choice == 2) {
            convertedTemp = celsiusToFahrenheit(inputTemp);
            System.out.printf("%.2f Celsius is equal to %.2f Fahrenheit.%n", inputTemp, convertedTemp);
        } else {
            System.out.println("Invalid choice. Please select 1 or 2.");
        }
    }
}