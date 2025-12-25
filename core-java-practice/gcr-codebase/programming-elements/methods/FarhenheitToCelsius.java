 import java.util.Scanner;
public class FarhenheitToCelsius {
    // Method to convert Fahrenheit to Celsius
    public static double convertFarhenheitToCelsius(double farhenheit) {
        double farhenheit2celsius = (farhenheit - 32) * 5 / 9;
        return farhenheit2celsius;
    }
    // Method to convert Celsius to Fahrenheit
    public static double convertCelsiusToFarhenheit(double celsius) {
        double celsius2farhenheit = (celsius * 9 / 5) + 32;
        return celsius2farhenheit;
    }
    // Method to convert pounds to kilograms
    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }
    // Method to convert kilograms to pounds
    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }
    // Method to convert gallons to liters
    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }
    // Method to convert liters to gallons
    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Fahrenheit to convert to Celsius: ");
        double farhenheit = scanner.nextDouble();
        System.out.println(farhenheit + " °F is " + convertFarhenheitToCelsius(farhenheit) + " °C.");

        System.out.print("Enter Celsius to convert to Fahrenheit: ");
        double celsius = scanner.nextDouble();
        System.out.println(celsius + " °C is " + convertCelsiusToFarhenheit(celsius) + " °F.");

        System.out.print("Enter pounds to convert to kilograms: ");
        double pounds = scanner.nextDouble();
        System.out.println(pounds + " pounds is " + convertPoundsToKilograms(pounds) + " kilograms.");

        System.out.print("Enter kilograms to convert to pounds: ");
        double kilograms = scanner.nextDouble();
        System.out.println(kilograms + " kilograms is " + convertKilogramsToPounds(kilograms) + " pounds.");

        System.out.print("Enter gallons to convert to liters: ");
        double gallons = scanner.nextDouble();
        System.out.println(gallons + " gallons is " + convertGallonsToLiters(gallons) + " liters.");

        System.out.print("Enter liters to convert to gallons: ");
        double liters = scanner.nextDouble();
        System.out.println(liters + " liters is " + convertLitersToGallons(liters) + " gallons.");

        scanner.close();
    }
}