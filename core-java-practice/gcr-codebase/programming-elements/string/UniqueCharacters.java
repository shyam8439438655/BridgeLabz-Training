import java.util.Scanner;

public class UniqueCharacters {

    // Method to find length without using length()
    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count); // will throw exception when index exceeds
                count++;
            }
        } catch (Exception e) {
            // end of string
        }
        return count;
    }

    // Method to find unique characters
    public static String findUnique(String str) {
        int len = getLength(str);
        String result = "";

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);

            // check if already in result
            boolean already = false;
            for (int j = 0; j < result.length(); j++) {
                if (result.charAt(j) == ch) {
                    already = true;
                    break;
                }
            }

            if (!already) {
                result += ch; // add unique char
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String unique = findUnique(input);

        System.out.println("\nUnique characters: " + unique);

        sc.close();
    }
}