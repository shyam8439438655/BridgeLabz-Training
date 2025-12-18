import java.util.Scanner;
public class AgeOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Birth Year: ");
        int birthYear = sc.nextInt();

        int cuurrentYear = 2024;
        int age = cuurrentYear - birthYear;
        System.out.println("Harry's age in 2024 is: " + age + " years");
        sc.close();
    }
}
