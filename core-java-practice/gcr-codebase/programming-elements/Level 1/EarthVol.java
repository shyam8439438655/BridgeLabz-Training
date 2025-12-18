public class EarthVol {
    public static void main(String[] args) {
        double radiusKm = 6371.0; // Earth's radius in kilometers
        double volumeKm = (4.0 / 3.0) * 3.14 * radiusKm * radiusKm * radiusKm;
        double volumeMiles = volumeKm * Math.pow(0.621371, 3);

        System.out.println("The volume of earth in cubic kilometers is " 
                            + volumeKm + " and cubic miles is " + volumeMiles);
    }
}
