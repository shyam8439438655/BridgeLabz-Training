import java.util.Arrays;
import java.util.Scanner;

class NumberChecker {

    // Method 1: Count digits
    public static int countDigits(int num) {
        return String.valueOf(num).length();
    }

    // Method 2: Store digits in an array
    public static int[] getDigitsArray(int num) {
        String s = String.valueOf(num);
        int[] digits = new int[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';  // Convert char to int
        }
        return digits;
    }

    // Method 3: Reverse digits array
    public static int[] reverseArray(int[] arr) {
        int[] rev = new int[arr.length];
        int j = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            rev[j++] = arr[i];
        }
        return rev;
    }

    // Method 4: Compare two arrays
    public static boolean areArraysEqual(int[] arr1, int[] arr2) {
        return Arrays.equals(arr1, arr2);
    }

    // Method 5: Check Palindrome Number
    public static boolean isPalindrome(int num) {
        int[] original = getDigitsArray(num);
        int[] reversed = reverseArray(original);
        return areArraysEqual(original, reversed);
    }

    // Method 6: Check Duck Number
    // A Duck number contains at least one 0 (but NOT at first position)
    public static boolean isDuckNumber(int num) {
        int[] digits = getDigitsArray(num);

        // Duck number: contains 0, but not as the first digit
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == 0) {
                return true;
            }
        }
        return false;
    }
}


public class NumberCheckerWithPalindrome {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Call all methods
        int count = NumberChecker.countDigits(number);
        int[] digits = NumberChecker.getDigitsArray(number);
        int[] reverse = NumberChecker.reverseArray(digits);
        boolean isPalin = NumberChecker.isPalindrome(number);
        boolean isDuck = NumberChecker.isDuckNumber(number);

        // Display Results
        System.out.println("\n--- Results ---");
        System.out.println("Count of digits: " + count);
        System.out.println("Digits array: " + Arrays.toString(digits));
        System.out.println("Reversed digits: " + Arrays.toString(reverse));
        System.out.println("Palindrome? " + isPalin);
        System.out.println("Duck Number? " + isDuck);
        sc.close();
    }
}
