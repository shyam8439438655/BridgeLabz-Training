import java.util.Scanner;

public class ArrayIndex {

    // Method 1: Generate ArrayIndexOutOfBoundsException (no try-catch)
    static void generateException(String[] names) {
        System.out.println("Generating ArrayIndexOutOfBoundsException...");
        System.out.println(names[5]);   // Accessing index beyond length
    }

    // Method 2: Handle the exception using try-catch
    static void handleException(String[] names) {
        System.out.println("Handling ArrayIndexOutOfBoundsException...");

        try {
            System.out.println(names[5]); // Same risky index
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] names = new String[3];
        System.out.println("Enter 3 names:");

        for (int i = 0; i < names.length; i++) {
            names[i] = input.next();
        }

        // First: This will generate exception
        try {
            generateException(names);
        } catch (Exception e) {
            System.out.println("Error occurred in generateException()");
        }

        // Second: Exception handled safely
        handleException(names);

        input.close();
    }
}
