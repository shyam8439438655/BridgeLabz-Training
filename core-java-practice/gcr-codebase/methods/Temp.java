import java.util.Scanner;
public class Temp {
    // Method to calculate wind chill temperature
    public static double calculateWindChill(double temperature, double windSpeed) {
        double windChill = 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
        return windChill;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking inputs
        System.out.print("Enter the temperature (in Fahrenheit): ");
        double temperature = scanner.nextDouble();

        System.out.print("Enter the wind speed (in miles per hour): ");
        double windSpeed = scanner.nextDouble();

        // Calling the method
        double windChill = calculateWindChill(temperature, windSpeed);

        // Output
        System.out.printf("The wind chill temperature is: %.2f°F%n", windChill);
        scanner.close();
    }
}