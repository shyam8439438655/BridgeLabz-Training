import java.util.Scanner;
public class DoubleOpt {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double result1 = a + b * c;
        double result2 = a * b + c;
        double result3 = c + a / b;
        double result4 = a % b + c;

        System.out.println("The results of Double Operations are "
                + result1 + ", " + result2 + ", " + result3 + ", and " + result4);
        scanner.close();
  }  
}
