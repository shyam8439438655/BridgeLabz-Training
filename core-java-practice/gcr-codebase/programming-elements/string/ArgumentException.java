import java.util.Scanner;

public class ArgumentException {

    // Method 1: Generate IllegalArgumentException (no try-catch)
    static void generateException(String text) {
        System.out.println("Generating IllegalArgumentException...");
        // start > end → substring throws IllegalArgumentException
        String sub = text.substring(5, 2);
        System.out.println("Substring: " + sub);
    }

    // Method 2: Handle the exception using try-catch
    static void handleException(String text) {
        System.out.println("Handling IllegalArgumentException...");

        try {
            String sub = text.substring(5, 2); // same incorrect order
            System.out.println("Substring: " + sub);
        } 
        catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.next();

        // First call → will throw exception
        try {
            generateException(text);
        } catch (Exception e) {
            System.out.println("Error occurred in generateException()");
        }

        // Second call → exception handled
        handleException(text);

        input.close();
    }
}
