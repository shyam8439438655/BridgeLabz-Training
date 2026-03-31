import java.util.Scanner;

// Custom Exception Class
class InvalidFlightException extends Exception {
    public InvalidFlightException(String message) {
        super(message);
    }
}

// Utility Class
class FlightUtil {

    public boolean validateFlightNumber(String flightNumber) throws InvalidFlightException {
        if (flightNumber.matches("FL-\\d{4}")) {
            int num = Integer.parseInt(flightNumber.substring(3));
            if (num >= 1000 && num <= 9999) {
                return true;
            }
        }
        throw new InvalidFlightException("The flight number " + flightNumber + " is invalid");
    }

    public boolean validateFlightName(String flightName) throws InvalidFlightException {
        if (flightName.equalsIgnoreCase("SpiceJet") ||
            flightName.equalsIgnoreCase("Vistara") ||
            flightName.equalsIgnoreCase("IndiGo") ||
            flightName.equalsIgnoreCase("Air Arabia")) {
            return true;
        }
        throw new InvalidFlightException("The flight name " + flightName + " is invalid");
    }

    public boolean validatePassengerCount(int passengerCount, String flightName) throws InvalidFlightException {
        int maxCapacity = 0;
        switch (flightName) {
            case "SpiceJet": maxCapacity = 396; break;
            case "Vistara": maxCapacity = 615; break;
            case "IndiGo": maxCapacity = 230; break;
            case "Air Arabia": maxCapacity = 130; break;
        }

        if (passengerCount <= 0 || passengerCount > maxCapacity) {
            throw new InvalidFlightException("The passenger count " + passengerCount + " is invalid for " + flightName);
        }
        return true;
    }

    public double calculateFuelToFillTank(String flightName, double currentFuelLevel) throws InvalidFlightException {
        double maxCapacity = 0;
        switch (flightName) {
            case "SpiceJet": maxCapacity = 200000; break;
            case "Vistara": maxCapacity = 300000; break;
            case "IndiGo": maxCapacity = 250000; break;
            case "Air Arabia": maxCapacity = 150000; break;
        }

        if (currentFuelLevel < 0 || currentFuelLevel > maxCapacity) {
            throw new InvalidFlightException("Invalid fuel level for " + flightName);
        }
        return maxCapacity - currentFuelLevel;
    }
}

// Main Class
public class AeroVigil {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FlightUtil util = new FlightUtil();

        System.out.println("Enter flight details");
        String input = sc.nextLine();

        try {
            String[] parts = input.split(":");
            String flightNumber = parts[0];
            String flightName = parts[1];
            int passengerCount = Integer.parseInt(parts[2]);
            double currentFuelLevel = Double.parseDouble(parts[3]);

            util.validateFlightNumber(flightNumber);
            util.validateFlightName(flightName);
            util.validatePassengerCount(passengerCount, flightName);

            double fuelRequired = util.calculateFuelToFillTank(flightName, currentFuelLevel);
            System.out.println("Fuel required to fill the tank: " + fuelRequired + " liters");

        } catch (InvalidFlightException e) {
            System.out.println(e.getMessage());
        }
    }
}