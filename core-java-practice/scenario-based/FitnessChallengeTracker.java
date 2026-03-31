import java.util.Scanner;
public class FitnessChallengeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] pushUps = new int[7];
        int totalPushUps = 0;
        int activeDays = 0;

        // Input push-up counts for each day of the week
        for (int i = 0; i < pushUps.length; i++) {
            System.out.print("Enter push-ups for day " + (i + 1) + " (0 if rest day): ");
            pushUps[i] = scanner.nextInt();
        }

        // Calculate total and average using for-each loop
        for (int count : pushUps) {
            if (count == 0) {
                // Skip rest days
                continue;
            }
            totalPushUps += count;
            activeDays++;
        }

        // Calculate average push-ups on active days
        double averagePushUps = activeDays > 0 ? (double) totalPushUps / activeDays : 0;

        // Output results
        System.out.println("Total push-ups in the week: " + totalPushUps);
        System.out.printf("Average push-ups on active days: %.2f%n", averagePushUps);

        scanner.close();
    }
}