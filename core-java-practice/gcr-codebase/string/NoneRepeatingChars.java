import java.util.Scanner;

public class NoneRepeatingChars {

    // Method to find the first non-repeating character
    public static char findFirstNonRepeating(String str) {
        int[] freq = new int[256]; // frequency array for ASCII characters

        // Step 1: Count frequency of each character
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch]++;
        }

        // Step 2: Find the first character with frequency = 1
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (freq[ch] == 1) {
                return ch;
            }
        }

        return '\0'; // return null character if none found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Call method
        char result = findFirstNonRepeating(input);

        // Display result
        if (result == '\0') {
            System.out.println("No non-repeating character found.");
        } else {
            System.out.println("First non-repeating character: " + result);
        }

        sc.close();
    }
}