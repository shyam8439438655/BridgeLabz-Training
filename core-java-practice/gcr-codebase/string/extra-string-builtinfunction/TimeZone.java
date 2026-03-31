// 1. Problem 1: Time Zones and ZonedDateTime Write a program that displays the current
// time in different time zones:
// ➢ GMT (Greenwich Mean Time)
// ➢ IST (Indian Standard Time)
// ➢ PST (Pacific Standard Time)
// Hint: Use ZonedDateTime and ZoneId to work with different time zones.
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;
public class TimeZone {
    public static void main(String[] args) {
        // Your code goes here
        Scanner scanner = new Scanner(System.in);
        ZonedDateTime gmtTime = ZonedDateTime.now(ZoneId.of("GMT"));
        ZonedDateTime istTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        ZonedDateTime pstTime = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println("Current time in GMT: " + gmtTime);
        System.out.println("Current time in IST: " + istTime);
        System.out.println("Current time in PST: " + pstTime);
        scanner.close();

    }
}