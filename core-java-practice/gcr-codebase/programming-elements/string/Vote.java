import java.util.Scanner;
import java.util.Random;

public class Vote {

    // Method to generate random 2-digit ages for n students
    public static int[] generateAges(int n) {
        Random rand = new Random();
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = 10 + rand.nextInt(90); // random 2-digit age (10–99)
        }
        return ages;
    }

    // Method to check voting eligibility and return 2D array
    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]); // store age

            if (ages[i] < 0) {
                result[i][1] = "false"; // negative age → cannot vote
            } else if (ages[i] >= 18) {
                result[i][1] = "true";  // age >= 18 → can vote
            } else {
                result[i][1] = "false"; // age < 18 → cannot vote
            }
        }
        return result;
    }

    // Method to display 2D array in tabular format
    public static void displayTable(String[][] table) {
        System.out.println("\nAge\tCan Vote?");
        System.out.println("-------------------");
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t" + table[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input for number of students
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

        // Generate random ages
        int[] ages = generateAges(n);

        // Check voting eligibility
        String[][] table = checkVotingEligibility(ages);

        // Display results
        displayTable(table);

        scanner.close();
    }
}