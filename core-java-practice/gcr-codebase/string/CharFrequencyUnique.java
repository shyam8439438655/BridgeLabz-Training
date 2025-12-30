import java.util.Scanner;

public class CharFrequencyUnique {

    // Method to find unique characters using charAt()
    public static char[] uniqueCharacters(String str) {
        int len = str.length();
        char[] temp = new char[len];// temporary array to hold unique chars
        int count = 0;

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            boolean already = false;

            // check if character already stored
            for (int j = 0; j < count; j++) {
                if (temp[j] == ch) {
                    already = true;
                    break;
                }
            }

            if (!already) {
                temp[count] = ch;
                count++;
            }
        }

        // final array with only unique characters
        char[] result = new char[count];
        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    // Method to find frequency of characters using unique characters
    public static String[][] findFrequency(String str) {
        int[] freq = new int[256]; // ASCII frequency array

        // count frequency of each character
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch]++;
        }

        // get unique characters
        char[] unique = uniqueCharacters(str);

        // prepare 2D array for character + frequency
        String[][] result = new String[unique.length][2];
        for (int i = 0; i < unique.length; i++) {
            result[i][0] = String.valueOf(unique[i]);
            result[i][1] = String.valueOf(freq[unique[i]]);
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