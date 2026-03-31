import java.util.Scanner;
public class ManageStudentTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        double[] scores = new double[n];

        // Input scores
        for (int i = 0; i < n; i++) {
            System.out.print("Enter score for student " + (i + 1) + ": ");
            double score = scanner.nextDouble();
            // Validate input
            while (score < 0) {
                System.out.print("Invalid score. Please enter a non-negative score for student " + (i + 1) + ": ");
                score = scanner.nextDouble();
            }
            scores[i] = score;
        }

        // Calculate average
        double sum = 0;
        for (double score : scores) {
            sum += score;
        }
        double average = sum / n;
        System.out.println("Average Score: " + average);

        // Find highest and lowest scores
        double highest = scores[0];
        double lowest = scores[0];
        for (double score : scores) {
            if (score > highest) {
                highest = score;
            }
            if (score < lowest) {
                lowest = score;
            }
        }
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);

        // Display scores above average
        System.out.println("Scores above average:");
        for (double score : scores) {
            if (score > average) {
                System.out.println(score);
            }
        }
        
        scanner.close();
    }
}