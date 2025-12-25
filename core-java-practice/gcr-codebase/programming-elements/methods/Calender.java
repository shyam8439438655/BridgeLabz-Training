import java.util.Scanner;

class CalendarUtility {

    //  Month names array
    public static String getMonthName(int month) {
        String[] months = { "January", "February", "March", "April", "May", "June",
                            "July", "August", "September", "October", "November", "December" };
        return months[month - 1];  // month input 1-12
    }

    //  Leap Year Check
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    //  Number of days in month
    public static int getDaysInMonth(int month, int year) {
        int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return days[month - 1];
    }

    // First day of month using Gregorian Calendar formula
    // 0 = Sunday, 1 = Monday, ..., 6 = Saturday
    public static int getFirstDayOfMonth(int month, int year) {
        int y = year;
        int m = month;
        if (m < 3) {
            m += 12;
            y--;
        }
        int k = y % 100;
        int j = y / 100;

        int day = (1 + 13*(m + 1)/5 + k + k/4 + j/4 + 5*j) % 7;

        // Zeller's formula returns 0=Saturday, 1=Sunday..., convert to 0=Sunday
        int firstDay = (day + 6) % 7;
        return firstDay;
    }

    // Display the calendar
    public static void displayCalendar(int month, int year) {
        String monthName = getMonthName(month);
        int daysInMonth = getDaysInMonth(month, year);
        int firstDay = getFirstDayOfMonth(month, year);

        System.out.println("\n   " + monthName + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // First for loop → indentation for first day
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");  // 4 spaces for each day
        }

        // Second for loop → print all days
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%3d ", day);  // right-justified 3-width

            // New line after Saturday
            if ((firstDay + day) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}

public class Calender {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();

        System.out.print("Enter year: ");
        int year = sc.nextInt();

        CalendarUtility.displayCalendar(month, year);
        sc.close();
    }
}
