import java.util.Scanner;
public class ProfitAndLossInNumberAndPercentage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Cost Price: ");
        int costprice = scanner.nextInt();
        System.out.print("Enter Selling Price: ");
        int sellingprice = scanner.nextInt();
        int profit = sellingprice - costprice;
        double profitPercentage = (profit * 100) / costprice;
        System.out.println("the cost price is: " + costprice  + " and selling price is: " + sellingprice +
                " so the profit is INR: " + profit + " and profit percentage is: " + profitPercentage + "%");

        scanner.close();
    }
}
 