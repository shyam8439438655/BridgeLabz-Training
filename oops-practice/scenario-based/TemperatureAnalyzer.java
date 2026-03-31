import java.util.Scanner;
public class TemperatureAnalyzer {

    // Method to find hottest and coldest day
    public static void findHottestAndColdestDay(float[][] temperatures) {
        int hottestDay = -1;
        int coldestDay = -1;
        float maxTemp = Float.NEGATIVE_INFINITY;
        float minTemp = Float.POSITIVE_INFINITY;

        for (int day = 0; day < temperatures.length; day++) {
            for (int hour = 0; hour < temperatures[day].length; hour++) {
                if (temperatures[day][hour] > maxTemp) {
                    maxTemp = temperatures[day][hour];
                    hottestDay = day;
                }
                if (temperatures[day][hour] < minTemp) {
                    minTemp = temperatures[day][hour];
                    coldestDay = day;
                }
            }
        }

        System.out.println("Hottest Day: Day " + (hottestDay + 1) + " with temperature " + maxTemp);
        System.out.println("Coldest Day: Day " + (coldestDay + 1) + " with temperature " + minTemp);
    }

    // Method to calculate average temperature per day
    public static void calculateAverageTemperaturePerDay(float[][] temperatures) {
        for (int day = 0; day < temperatures.length; day++) {
            float sum = 0;
            for (int hour = 0; hour < temperatures[day].length; hour++) {
                sum += temperatures[day][hour];
            }
            float average = sum / temperatures[day].length;
            System.out.println("Average temperature for Day " + (day + 1) + ": " + average);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float[][] temperatures = new float[7][24];

        // Input temperature data
        System.out.println("Enter hourly temperatures for 7 days (24 hours each):");
        for (int day = 0; day < 7; day++) {
            System.out.println("Day " + (day + 1) + ":");
            for (int hour = 0; hour < 24; hour++) {
                System.out.print("Hour " + hour + ": ");
                temperatures[day][hour] = scanner.nextFloat();
            }
        }

        // Analyze temperatures
        findHottestAndColdestDay(temperatures);
        calculateAverageTemperaturePerDay(temperatures);    
        scanner.close();
    }
}