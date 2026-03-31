public class DigitalWatchSimulation {

    public static void main(String[] args) {
        System.out.println(" Digital Watch Simulation Started");
        // Outer loop for hours (0 to 23)
        for (int hour = 0; hour < 24; hour++) {

            // Inner loop for minutes (0 to 59)
            for (int minute = 0; minute < 60; minute++) {
                System.out.printf("Time: %02d:%02d\n", hour, minute);

                // Simulate power cut at 13:00
                if (hour == 13 && minute == 0) {
                    System.out.println(" Power cut! Watch stopped at 13:00 ");
                    break; // break inner loop
                }
            }

            // Extra check to break outer loop as well
            if (hour == 13) {
                break; // stop the watch completely
            }
        }

        System.out.println("Simulation Ended.");
    }
}