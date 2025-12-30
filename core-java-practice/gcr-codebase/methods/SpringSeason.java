 import java.util.Scanner;
public class SpringSeason {
    // Method to check if the date is in Spring season
    public static boolean isSpringSeason(int month, int day) {
        if ((month == 3 && day >= 20) || (month > 3 && month < 6) || (month == 6 && day <= 20)) {
            return true; // It's Spring Season
        }
        return false; // Not Spring Season
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking inputs
        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();

        System.out.print("Enter day (1-31): ");
        int day = scanner.nextInt();

        // Calling the method
        boolean spring = isSpringSeason(month, day);

        // Output
        if (spring) {
            System.out.println("It's a Spring Season.");
        } else {
            System.out.println("Not a Spring Season.");
        }
        scanner.close();
    }
}