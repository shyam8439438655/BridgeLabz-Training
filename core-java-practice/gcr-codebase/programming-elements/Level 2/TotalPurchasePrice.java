import java.util.Scanner;
public class TotalPurchasePrice {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
      double unitPrice = sc.nextDouble();// price of single unit
      int quantity = sc.nextInt();// number of units purchased

      double total = unitPrice * quantity;// total purchase price
      System.out.println("The total purchase price is INR " + total + " if the quantity " + quantity + " and unit price is INR " + unitPrice);
      sc.close();
  }  
}
