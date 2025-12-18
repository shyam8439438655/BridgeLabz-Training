import java.util.Scanner;
public class QuotientAndRemainder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        System.out.println("The Quotient is " + (n1 / n2) +  " and Reminder is " + (n1 % n2) +  " of two number " + n1 + " and " + n2);
        sc.close();
    }
}
