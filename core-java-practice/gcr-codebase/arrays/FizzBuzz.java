import java.util.Scanner;
public class FizzBuzz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();
        if (number < 1) {
            System.out.println("Please enter a positive integer greater than 0.");
            scanner.close();
            return;
        }
        String[] fizzBuzzArray = new String[number];
        for (int i = 1; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                fizzBuzzArray[i - 1] = "FizzBuzz";
            } else if (i % 3 == 0) {
                fizzBuzzArray[i - 1] = "Fizz";
            } else if (i % 5 == 0) {
                fizzBuzzArray[i - 1] = "Buzz";
            } else {
                fizzBuzzArray[i - 1] = Integer.toString(i);
            }
        }
        System.out.println("FizzBuzz Results:");
        for (int i = 0; i < fizzBuzzArray.length; i++) {
            System.out.println("Position " + (i + 1) + " = " + fizzBuzzArray[i]);
        }
        scanner.close();
    }
}
