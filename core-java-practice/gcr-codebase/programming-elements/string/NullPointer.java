public class NullPointer {

    // Method 1: This will generate NullPointerException (no try-catch)
    static void generateException() {
        System.out.println("Generating NullPointerException...");
        String text = null;   // text is null
        System.out.println(text.length()); // Calling method on null → Exception
    }

    // Method 2: Handle the NullPointerException using try-catch
    static void handleException() {
        System.out.println("Handling NullPointerException...");
        String text = null;

        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        // First call → will throw exception
        try {
            generateException();
        } catch (Exception e) {
            System.out.println("Runtime Error occurred in generateException()");
        }

        // Second call → safely handled
        handleException();
    }
}
