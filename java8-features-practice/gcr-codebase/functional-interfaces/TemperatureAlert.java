import java.util.function.Predicate;

public class TemperatureAlert {
    public static void main(String[] args) {

        Predicate<Double> isHighTemp = temp -> temp > 40.0;

        double temperature = 45.5;

        if (isHighTemp.test(temperature)) {
            System.out.println("Alert! Temperature crossed threshold");
        } else {
            System.out.println("Temperature is normal");
        }
    }
}
