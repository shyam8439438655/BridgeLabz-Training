import java.util.Scanner;

public class StringIndex {

    // Method 1: This will generate the exception (no try-catch)
    static void generateException(String str) {
        System.out.println("Generating Exception...");
        // Accessing index beyond length
        char ch = str.charAt(10);   // If string is smaller than 11 characters → Exception
        System.out.println("Character: " + ch);
    }

    // Method 2: Handle the exception using try-catch
    static void handleException(String str) {
        System.out.println("Handling Exception...");
        try {
            char ch = str.charAt(10); // Same risky line
            System.out.println("Character: " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter any string: ");
        String userInput = sc.nextLine();

        // First method → will crash
        // After crash, next method will not run
        // So wrap it separately to show effect clearly
        try {
            generateException(userInput);
        } catch (Exception e) {
            System.out.println("Runtime Error Occurred in generateException()");
        }

        // Now call method that safely handles exception
        handleException(userInput);

        sc.close();
    }
}

