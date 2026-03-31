import java.util.Scanner;

abstract class GoodsTransport {
    protected String transportId;
    protected String transportDate;
    protected int transportRating;

    public GoodsTransport(String transportId, String transportDate, int transportRating) {
        this.transportId = transportId;
        this.transportDate = transportDate;
        this.transportRating = transportRating;
    }

    public String getTransportId() {
        return transportId;
    }
    public void setTransportId(String transportId) {
        this.transportId = transportId;
    }

    public String getTransportDate() {
        return transportDate;
    }
    public void setTransportDate(String transportDate) {
        this.transportDate = transportDate;
    }

    public int getTransportRating() {
        return transportRating;
    }
    public void setTransportRating(int transportRating) {
        this.transportRating = transportRating;
    }

    abstract public String vehicleSelection();
    abstract public float calculateTotalCharge();
}

class BrickTransport extends GoodsTransport {
    private float brickSize;
    private int brickQuantity;
    private float brickPrice;

    public BrickTransport(String transportId, String transportDate, int transportRating,
                          float brickSize, int brickQuantity, float brickPrice) {
        super(transportId, transportDate, transportRating);
        this.brickSize = brickSize;
        this.brickQuantity = brickQuantity;
        this.brickPrice = brickPrice;
    }

    public float getBrickSize() {
        return brickSize;
    }
    public void setBrickSize(float brickSize) {
        this.brickSize = brickSize;
    }

    public int getBrickQuantity() {
        return brickQuantity;
    }
    public void setBrickQuantity(int brickQuantity) {
        this.brickQuantity = brickQuantity;
    }

    public float getBrickPrice() {
        return brickPrice;
    }
    public void setBrickPrice(float brickPrice) {
        this.brickPrice = brickPrice;
    }

    public String vehicleSelection() {
        if (brickQuantity < 300) return "Truck";
        if (brickQuantity <= 500) return "Lorry";
        return "MonsterLorry";
    }

    private int getVehiclePrice(String vehicle) {
        if (vehicle.equalsIgnoreCase("Truck")) return 1000;
        if (vehicle.equalsIgnoreCase("Lorry")) return 1700;
        return 3000; // MonsterLorry
    }

    private float getDiscountPercentByRating(int rating) {
        if (rating == 5) return 20.0f;
        if (rating == 3 || rating == 4) return 10.0f;
        return 0.0f;
    }

    public float calculateTotalCharge() {
        float price = brickPrice * brickQuantity;
        float tax = price * 0.3f;

        String vehicle = vehicleSelection();
        int vehiclePrice = getVehiclePrice(vehicle);

        float discountPercent = getDiscountPercentByRating(this.transportRating);
        float discount = price * discountPercent / 100.0f;

        return (price + vehiclePrice + tax) - discount;
    }
}

class TimberTransport extends GoodsTransport {
    private float timberLength;
    private float timberRadius;
    private String timberType;
    private float timberPrice;

    public TimberTransport(String transportId, String transportDate, int transportRating,
                           float timberLength, float timberRadius, String timberType, float timberPrice) {
        super(transportId, transportDate, transportRating);
        this.timberLength = timberLength;
        this.timberRadius = timberRadius;
        this.timberType = timberType;
        this.timberPrice = timberPrice;
    }

    public float getTimberLength() {
        return timberLength;
    }
    public void setTimberLength(float timberLength) {
        this.timberLength = timberLength;
    }

    public float getTimberRadius() {
        return timberRadius;
    }
    public void setTimberRadius(float timberRadius) {
        this.timberRadius = timberRadius;
    }

    public String getTimberType() {
        return timberType;
    }
    public void setTimberType(String timberType) {
        this.timberType = timberType;
    }

    public float getTimberPrice() {
        return timberPrice;
    }
    public void setTimberPrice(float timberPrice) {
        this.timberPrice = timberPrice;
    }

    public String vehicleSelection() {
        float area = 2.0f * 3.147f * timberRadius * timberLength;

        if (area < 250.0f) return "Truck";
        if (area <= 400.0f) return "Lorry";
        return "MonsterLorry";
    }

    private int getVehiclePrice(String vehicle) {
        if (vehicle.equalsIgnoreCase("Truck")) return 1000;
        if (vehicle.equalsIgnoreCase("Lorry")) return 1700;
        return 3000; // MonsterLorry
    }

    private float getDiscountPercentByRating(int rating) {
        if (rating == 5) return 20.0f;
        if (rating == 3 || rating == 4) return 10.0f;
        return 0.0f;
    }

    private float getTimberTypeRate(String type) {
        if (type != null && type.equalsIgnoreCase("Premium")) return 0.25f;
        return 0.15f; // NonPremium
    }

    public float calculateTotalCharge() {
        float volume = 3.147f * timberRadius * timberRadius * timberLength;

        float rate = getTimberTypeRate(timberType);
        float price = volume * timberPrice * rate;

        float tax = price * 0.3f;

        String vehicle = vehicleSelection();
        int vehiclePrice = getVehiclePrice(vehicle);

        float discountPercent = getDiscountPercentByRating(this.transportRating);
        float discount = price * discountPercent / 100.0f;

        return (price + vehiclePrice + tax) - discount;
    }
}

class Utility {

    public GoodsTransport parseDetails(String input) {
        String[] parts = input.split(":");
        // transportId:transportDate:transportRating:transportType:...

        String transportId = parts[0];
        String transportDate = parts[1];
        int rating = Integer.parseInt(parts[2]);
        String transportType = parts[3];

        if (transportType.equalsIgnoreCase("BrickTransport")) {
            float brickSize = Float.parseFloat(parts[4]);
            int brickQuantity = Integer.parseInt(parts[5]);
            float brickPrice = Float.parseFloat(parts[6]);

            return new BrickTransport(transportId, transportDate, rating, brickSize, brickQuantity, brickPrice);
        } else { // TimberTransport
            float timberLength = Float.parseFloat(parts[4]);
            float timberRadius = Float.parseFloat(parts[5]);
            String timberType = parts[6];
            float timberPrice = Float.parseFloat(parts[7]);

            return new TimberTransport(transportId, transportDate, rating, timberLength, timberRadius, timberType, timberPrice);
        }
    }

    public boolean validateTransportId(String transportId) {
        // Must be: RTS + 3 digits + 1 uppercase letter
        // Example: RTS123A
        if (transportId == null || transportId.length() != 7) {
            System.out.println("Transport id " + transportId + " is invalid");
            return false;
        }

        if (!transportId.startsWith("RTS")) {
            System.out.println("Transport id " + transportId + " is invalid");
            return false;
        }

        char d1 = transportId.charAt(3);
        char d2 = transportId.charAt(4);
        char d3 = transportId.charAt(5);

        if (!(d1 >= '0' && d1 <= '9' && d2 >= '0' && d2 <= '9' && d3 >= '0' && d3 <= '9')) {
            System.out.println("Transport id " + transportId + " is invalid");
            return false;
        }

        char last = transportId.charAt(6);
        if (!(last >= 'A' && last <= 'Z')) {
            System.out.println("Transport id " + transportId + " is invalid");
            return false;
        }

        return true;
    }

    public String findObjectType(GoodsTransport goodsTransport) {
        if (goodsTransport instanceof TimberTransport) return "TimberTransport";
        return "BrickTransport";
    }
}

public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Goods Transport details");
        String input = sc.nextLine();

        Utility utility = new Utility();

        String[] parts = input.split(":");
        String transportId = parts[0];

        if (!utility.validateTransportId(transportId)) {
            System.out.println("Please provide a valid record");
            return; // no System.exit(0)
        }

        GoodsTransport gt = utility.parseDetails(input);
        String type = utility.findObjectType(gt);

        if (type.equals("BrickTransport")) {
            BrickTransport bt = (BrickTransport) gt;

            System.out.println();
            System.out.println("Transporter id : " + bt.getTransportId());
            System.out.println("Date of transport : " + bt.getTransportDate());
            System.out.println("Rating of the transport : " + bt.getTransportRating());
            System.out.println("Quantity of bricks : " + bt.getBrickQuantity());
            System.out.println("Brick price : " + bt.getBrickPrice());
            System.out.println("Vehicle for transport : " + bt.vehicleSelection());
            System.out.println("Total charge : " + bt.calculateTotalCharge());

        } else {
            TimberTransport tt = (TimberTransport) gt;

            System.out.println();
            System.out.println("Transporter id : " + tt.getTransportId());
            System.out.println("Date of transport : " + tt.getTransportDate());
            System.out.println("Rating of the transport : " + tt.getTransportRating());
            System.out.println("Type of the timber : " + tt.getTimberType());
            System.out.println("Timber price per kilo : " + tt.getTimberPrice());
            System.out.println("Vehicle for transport : " + tt.vehicleSelection());
            System.out.println("Total charge : " + tt.calculateTotalCharge());
        }

        sc.close();
    }
}
