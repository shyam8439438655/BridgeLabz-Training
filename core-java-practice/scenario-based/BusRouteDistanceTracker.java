import java.util.Scanner;
public class BusRouteDistanceTracker{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalDistance = 0;   // total km
        int eachStop = 5;        // each stop adds 5 km
        String answer = "no";

        while (answer.equalsIgnoreCase("no")) {
            totalDistance = totalDistance + eachStop;
            System.out.println("Bus reached a stop. Distance = " + totalDistance + " km");

            System.out.print("Do you want to get off? (yes/no): ");
            answer = scanner.next();
        }

        System.out.println("You got off the bus.");
        System.out.println("Final Distance Travelled = " + totalDistance + " km");

        scanner.close();

    }
}