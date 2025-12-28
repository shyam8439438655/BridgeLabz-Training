import java.util.Scanner;
public class PalindromeChecker {

    // Function to take input from user
    public static String takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to check if it's a palindrome: ");
        String input = sc.nextLine();
        return input;
    }

    // Function to check if the string is a palindrome
    public static boolean isPalindrome(String str) {
        String cleanedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = cleanedStr.length() - 1;

        while (left < right) {
            if (cleanedStr.charAt(left) != cleanedStr.charAt(right)) {
                return false; // Not a palindrome
            }
            left++;
            right--;
        }
        return true; // Is a palindrome
    }

    // Main method
    public static void main(String[] args) {
        String input = takeInput();
        boolean result = isPalindrome(input);

        // Display result
        if (result) {
            System.out.println("\"" + input + "\" is a palindrome.");
        } else {
            System.out.println("\"" + input + "\" is not a palindrome.");
        }
    }
}