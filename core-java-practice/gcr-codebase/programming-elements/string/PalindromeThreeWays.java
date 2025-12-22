import java.util.Scanner;

public class PalindromeThreeWays {

    // Logic 1: Iterative check using start and end indexes
    public static boolean isPalindromeIterative(String str) {
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: Recursive check
    public static boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) return true; // base case
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindromeRecursive(str, start + 1, end - 1);
    }

    // Logic 3: Using character arrays and reverse
    public static boolean isPalindromeArray(String str) {
        char[] original = str.toCharArray();
        char[] reverse = new char[str.length()];
        int idx = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse[idx++] = str.charAt(i);
        }
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reverse[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String input = scanner.nextLine();

        // Logic 1
        System.out.println("Logic 1 (Iterative): " +
            (isPalindromeIterative(input) ? "Palindrome" : "Not Palindrome"));

        // Logic 2
        System.out.println("Logic 2 (Recursive): " +
            (isPalindromeRecursive(input, 0, input.length() - 1) ? "Palindrome" : "Not Palindrome"));

        // Logic 3
        System.out.println("Logic 3 (Array Compare): " +
            (isPalindromeArray(input) ? "Palindrome" : "Not Palindrome"));

        scanner.close();
    }
}