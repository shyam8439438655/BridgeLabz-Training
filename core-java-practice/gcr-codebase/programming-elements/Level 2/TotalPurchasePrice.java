import java.util.Scanner;
public class TotalPurchasePrice {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
      double unitPrice = scanner.nextDouble();// price of single unit
      int quantity = scanner.nextInt();// number of units purchased

      double total = unitPrice * quantity;// total purchase price
      System.out.println("The total purchase price is INR " + total + " if the quantity " + quantity + " and unit price is INR " + unitPrice);
      scanner.close();
  }  
}
