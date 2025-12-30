/*Write a program SpringSeason that takes two int values month and day from the command line and prints "Its a Spring Season" otherwise prints "Not a Spring Season". 
Hint => 
Spring Season is from March 20 to June 20*/

import java.util.Scanner;

public class SpringSeason {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Enter day (1-31): ");
        int day = scanner.nextInt();
        // Spring season check karne ka easy way
        boolean isSpring = false;
        // Agar month 4 ya 5 hai, to pura month spring hai
        if (month == 4 || month == 5) {
            isSpring = true;
        }
        // Agar March hai aur day 20 se jyada hai
        else if (month == 3 && day >= 20) {
            isSpring = true;
        }
        // Agar June hai aur day 20 se kam ya equal hai
        else if (month == 6 && day <= 20) {
            isSpring = true;
        }   
        if(isSpring){
            System.out.println("Its a Spring Season");
        }
        else{
            System.out.println("Not a Spring Season");
        }
        scanner.close();
    }
}
