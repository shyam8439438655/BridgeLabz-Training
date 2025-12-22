import java.util.Scanner;

public class CharFrequency {

    // Method to find frequency of characters
    public static String[][] findFrequency(String str) {
        int[] freq = new int[256]; // frequency array for ASCII characters

        // Step 1: Count frequency of each character
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch]++;
        }

        // Step 2: Count how many unique characters
        int uniqueCount = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                uniqueCount++;
            }
        }

        // Step 3: Create 2D array to store character and frequency
        String[][] result = new String[uniqueCount][2];
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (freq[ch] > 0) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(freq[ch]);
                freq[ch] = 0; // reset so we don’t repeat
                index++;
            }
        }

        return result;
    }

    // Method to display result in tabular format
    public static void displayTable(String[][] table) {
        System.out.println("\nCharacter\tFrequency");
        System.out.println("-------------------------");
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t\t" + table[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Find frequency
        String[][] table = findFrequency(input);

        // Display result
        displayTable(table);

        scanner.close();
    }
}