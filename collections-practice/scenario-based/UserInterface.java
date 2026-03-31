import java.util.*;

class Vessel {
    private String vesselId;
    private String vesselName;
    private double averageSpeed;
    private String vesselType;

    public Vessel() {}

    public Vessel(String vesselId, String vesselName, double averageSpeed, String vesselType) {
        this.vesselId = vesselId;
        this.vesselName = vesselName;
        this.averageSpeed = averageSpeed;
        this.vesselType = vesselType;
    }

    public String getVesselId() {
        return vesselId;
    }

    public String getVesselName() {
        return vesselName;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public String getVesselType() {
        return vesselType;
    }
}

// Utility Class
class VesselUtil {
    private List<Vessel> vesselList = new ArrayList<>();

    public void addVesselPerformance(Vessel vessel) {
        vesselList.add(vessel);
    }

    public Vessel getVesselById(String vesselId) {
        for (Vessel v : vesselList) {
            if (v.getVesselId().equals(vesselId)) {
                return v;
            }
        }
        return null;
    }

    public List<Vessel> getHighPerformanceVessels() {
        List<Vessel> result = new ArrayList<>();
        if (vesselList.isEmpty()) return result;

        double maxSpeed = vesselList.get(0).getAverageSpeed();
        for (Vessel v : vesselList) {
            if (v.getAverageSpeed() > maxSpeed) {
                maxSpeed = v.getAverageSpeed();
            }
        }

        for (Vessel v : vesselList) {
            if (v.getAverageSpeed() == maxSpeed) {
                result.add(v);
            }
        }
        return result;
    }
}

public class UserInterface {

    private static void printVessel(Vessel v) {
        System.out.println(v.getVesselId() + " | " + v.getVesselName() + " | "
                + v.getVesselType() + " | " + v.getAverageSpeed() + " knots");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VesselUtil util = new VesselUtil();

        System.out.println("Enter the number of vessels to be added");
        int n = Integer.parseInt(sc.nextLine());

        System.out.println("Enter vessel details");
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] data = input.split(":");

            Vessel v = new Vessel(
                    data[0],
                    data[1],
                    Double.parseDouble(data[2]),
                    data[3]
            );
            util.addVesselPerformance(v);
        }

        System.out.println("Enter the Vessel Id to check speed");
        String searchId = sc.nextLine();

        Vessel found = util.getVesselById(searchId);
        if (found != null) {
            printVessel(found);
        } else {
            System.out.println("Vessel Id " + searchId + " not found.");
        }

        System.out.println("High performance vessels are");
        for (Vessel v : util.getHighPerformanceVessels()) {
            printVessel(v);
        }

        sc.close();
    }
}
