import com.fasterxml.jackson.databind.ObjectMapper;

class Car {
    public String brand;
    public String model;
    public int year;

    public Car() {}
    public Car(String brand, String model, int year) {
        this.brand = brand; this.model = model; this.year = year;
    }
}

public class CarToJson {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Car car = new Car("Tata", "Nexon", 2024);

        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(car);
        System.out.println(json);
    }
}
