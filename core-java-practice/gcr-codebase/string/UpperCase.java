import java.util.Scanner;

public class UpperCase {

    // Method 1: Convert lowercase letters to uppercase manually using charAt()
    static String manualUppercase(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // If character is lowercase (a-z)
            if (ch >= 'a' && ch <= 'z') {
                ch = (char)(ch - 32);   // Convert to uppercase using ASCII difference
            }

            result = result + ch;
        }

        return result;
    }

    // Method 2: Compare two strings character-by-character
    static boolean compareStrings(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter any text: ");
        String text = input.nextLine();   // Full sentence input

        // Manual uppercase conversion
        String manual = manualUppercase(text);

        // Built-in uppercase
        String builtin = text.toUpperCase();

        // Compare both strings
        boolean result = compareStrings(manual, builtin);

        // Display results
        System.out.println("\nManual Uppercase: " + manual);
        System.out.println("Built-in Uppercase: " + builtin);
        System.out.println("Are both equal? " + result);

        input.close();
    }
}
