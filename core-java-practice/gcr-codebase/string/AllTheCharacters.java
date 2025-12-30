import java.util.Scanner;

public class AllTheCharacters {

    // Method to return characters of a string without using toCharArray()
    public static char[] getChars(String text) {
        char[] arr = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            arr[i] = text.charAt(i); // copy each character
        }
        return arr;
    }

    // Method to compare two char arrays
    public static boolean compareArrays(char[] a1, char[] a2) {
        if (a1.length != a2.length) {
            return false;
        }
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take input
        System.out.print("Enter a string: ");
        String text = input.next();

        // User-defined method
        char[] arr1 = getChars(text);

        // Built-in method
        char[] arr2 = text.toCharArray();

        // Compare both arrays
        boolean same = compareArrays(arr1, arr2);

        // Display results
        System.out.print("Characters using user-defined method: ");
        for (char c : arr1) {
            System.out.print(c + " ");
        }

        System.out.print("\nCharacters using toCharArray(): ");
        for (char c : arr2) {
            System.out.print(c + " ");
        }

        System.out.println("\nAre both arrays same? " + same);

        input.close();
    }
}