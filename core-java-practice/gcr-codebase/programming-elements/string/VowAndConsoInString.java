import java.util.Scanner;

public class VowAndConsoInString {

    // Method to check if a character is vowel, consonant or not a letter
    public static String checkCharType(char ch) {
        // Convert uppercase to lowercase using ASCII values
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32); // convert to lowercase
        }

        // Check if it's a letter
        if (ch >= 'a' && ch <= 'z') {
            // Check vowels
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }

    // Method to count vowels and consonants in a string
    public static int[] countVowelsConsonants(String str) {
        int vowels = 0, consonants = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String type = checkCharType(ch);

            if (type.equals("Vowel")) {
                vowels++;
            } else if (type.equals("Consonant")) {
                consonants++;
            }
        }

        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Count vowels and consonants
        int[] result = countVowelsConsonants(input);

        // Display result
        System.out.println("\nResults:");
        System.out.println("Number of Vowels: " + result[0]);
        System.out.println("Number of Consonants: " + result[1]);

        scanner.close();
    }
}