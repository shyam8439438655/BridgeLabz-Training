public class DscntFee{
    public static void main(String[] args) {
        int fee = 12500;
        int discount = 10;
        int discountedFee = fee - (fee * discount / 100);
        System.out.println("The discounted fee is: " + discountedFee);
        
    }
}