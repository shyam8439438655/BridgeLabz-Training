import java.util.Scanner;
public class QuotientAndRemainder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);    
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();

        System.out.println("The Quotient is " + (n1 / n2) +  " and Reminder is " + (n1 % n2) +  " of two number " + n1 + " and " + n2);
        scanner.close();
    }
}
