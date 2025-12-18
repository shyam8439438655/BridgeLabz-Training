import java.util.Scanner;
public class AvgMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks for Maths: ");
        int maths = sc.nextInt();
        System.out.print("Enter marks for Physics: ");
        int physics = sc.nextInt();
        System.out.print("Enter marks for Chemistry: ");
        int chemistry = sc.nextInt();
        int total = maths + physics + chemistry;
        double average = total / 3;
        System.out.println("The Average Marks is: " + average + "%");
        sc.close();

    }
}
