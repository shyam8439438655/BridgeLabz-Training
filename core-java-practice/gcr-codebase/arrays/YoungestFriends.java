import java.util.Scanner;
public class YoungestFriends {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int FRIEND_COUNT = 3;
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[FRIEND_COUNT];
        double[] heights = new double[FRIEND_COUNT];
        for (int i = 0; i < FRIEND_COUNT; i++) {
            System.out.print("Enter age for " + names[i] + ": ");
            ages[i] = scanner.nextInt();
            System.out.print("Enter height for " + names[i] + ": ");
            heights[i] = scanner.nextDouble();
        }
        int youngestIndex = 0;
        int tallestIndex = 0;
        for (int i = 1; i < FRIEND_COUNT; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }
        System.out.println("Youngest friend is: " + names[youngestIndex]);
        System.out.println("Tallest friend is: " + names[tallestIndex]);
        scanner.close();
    }
}
