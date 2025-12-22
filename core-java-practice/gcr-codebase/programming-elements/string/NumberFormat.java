import java.util.Scanner;

public class NumberFormat {

    // Method 1: Generate NumberFormatException (no try-catch)
    static void generateException(String text) {
        System.out.println("Generating NumberFormatException...");
        int num = Integer.parseInt(text);  // If text is not a number → Exception
        System.out.println("Number: " + num);
    }

    // Method 2: Handle NumberFormatException using try-catch
    static void handleException(String text) {
        System.out.println("Handling NumberFormatException...");

        try {
            int num = Integer.parseInt(text);
            System.out.println("Number: " + num);
        } 
        catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter any text (letters to create error): ");
        String text = input.next();  // e.g. "abc"

        // First method → exception occurs
        try {
            generateException(text);
        } catch (Exception e) {
            System.out.println("Error occurred in generateException()");
        }

        // Second method → exception handled
        handleException(text);

        input.close();
    }
}
