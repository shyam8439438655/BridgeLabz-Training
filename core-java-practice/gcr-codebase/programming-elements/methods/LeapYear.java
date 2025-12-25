import java.util.Scanner;

public class LeapYear {

    // Method to check leap year
    public static boolean checkLeap(int year) {

        // Check Gregorian calendar
        if (year < 1582) {
            return false;
        }

        // Leap year conditions
        if (year % 400 == 0) {
            return true;
        } 
        else if (year % 4 == 0 && year % 100 != 0) {
            return true;
        } 
        else {
            return false;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        boolean isLeap = checkLeap(year);

        if (isLeap) {
            System.out.println(year + " is a Leap Year.");
        } else {
            System.out.println(year + " is NOT a Leap Year.");
        }
        scanner.close();
    }
}
