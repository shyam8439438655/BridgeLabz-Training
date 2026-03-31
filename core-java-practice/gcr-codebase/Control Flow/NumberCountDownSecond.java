import java.util.Scanner;
public class NumberCountDownSecond {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter countdown start number: ");
        int n = scanner.nextInt();

        for (int i = n; i >= 1; i--) {
            System.out.println(i);
        }

        System.out.println("Rocket Launched!");
        scanner.close();
    }
}
