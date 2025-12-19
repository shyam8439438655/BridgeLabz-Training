
public class SimpleInterest {
    public static void main(String[] args) {
        double principal = 1000; // Principal amount
        double rate = 5; // Annual interest rate in percentage
        double time = 3; // Time in years

        double simpleInterest = (principal * rate * time) / 100;
        System.out.println("The Simple Interest is: " + simpleInterest);
    }
}
