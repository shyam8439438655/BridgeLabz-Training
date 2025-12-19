import java.util.Scanner;
public class AvgMarks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter marks for Maths: ");
        int maths = scanner.nextInt();
        System.out.print("Enter marks for Physics: ");
        int physics = scanner.nextInt();
        System.out.print("Enter marks for Chemistry: ");
        int chemistry = scanner.nextInt();
        int total = maths + physics + chemistry;
        double average = total / 3;
        System.out.println("The Average Marks is: " + average + "%");
        scanner.close();

    }
}
