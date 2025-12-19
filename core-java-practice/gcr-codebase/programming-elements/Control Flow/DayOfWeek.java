import java.util.Scanner;
public class DayOfWeek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input
        System.out.print("Enter month (1-12): ");
        int m = sc.nextInt();

        System.out.print("Enter day: ");
        int d = sc.nextInt();

        System.out.print("Enter year: ");
        int y = sc.nextInt();

        // Applying formulas
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;

        // Output (0 = Sunday)
        System.out.println("Day number is: " + d0);

        // Optional: Print actual day name
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        System.out.println("Day is: " + days[d0]);
        sc.close();
    }
}    


