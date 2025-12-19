import java.util.Scanner;
public class YoungestFriends {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Taking ages
        System.out.print("Enter Amar's age: ");
        int amarAge = scanner.nextInt();

        System.out.print("Enter Akbar's age: ");
        int akbarAge = scanner.nextInt();

        System.out.print("Enter Anthony's age: ");
        int anthonyAge = scanner.nextInt();

        // Taking heights
        System.out.print("Enter Amar's height: ");
        double amarHeight = scanner.nextDouble();

        System.out.print("Enter Akbar's height: ");
        double akbarHeight = scanner.nextDouble();

        System.out.print("Enter Anthony's height: ");
        double anthonyHeight = scanner.nextDouble();

        // Finding Youngest
        if (amarAge < akbarAge && amarAge < anthonyAge) {
            System.out.println("Youngest friend is: Amar");
        } else if (akbarAge < anthonyAge) {
            System.out.println("Youngest friend is: Akbar");
        } else {
            System.out.println("Youngest friend is: Anthony");
        }

        // Finding Tallest
        if (amarHeight > akbarHeight && amarHeight > anthonyHeight) {
            System.out.println("Tallest friend is: Amar");
        } else if (akbarHeight > anthonyHeight) {
            System.out.println("Tallest friend is: Akbar");
        } else {
            System.out.println("Tallest friend is: Anthony");
        }
        scanner.close();
    }
}
