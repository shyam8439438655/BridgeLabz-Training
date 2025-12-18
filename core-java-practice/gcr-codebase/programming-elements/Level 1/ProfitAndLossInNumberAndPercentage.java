import java.util.Scanner;
public class ProfitAndLossInNumberAndPercentage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Cost Price: ");
        int cp = sc.nextInt();
        System.out.print("Enter Selling Price: ");
        int sp = sc.nextInt();
        int profit = sp - cp;
        double profitPercentage = (profit * 100) / cp;
        System.out.println("the cost price is: " + cp  + " and selling price is: " + sp +
                " so the profit is INR: " + profit + " and profit percentage is: " + profitPercentage + "%");

        sc.close();
    }
}
 