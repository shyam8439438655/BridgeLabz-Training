// Interface
interface Payment {
    void pay(double amount);
}

// UPI
class UPI implements Payment {
    public void pay(double amount) {
        System.out.println("Paid" + amount + " via UPI");
    }
}

// Credit Card
class CreditCard implements Payment {
    public void pay(double amount) {
        System.out.println("Paid" + amount + " via Credit Card");
    }
}

// Wallet
class Wallet implements Payment {
    public void pay(double amount) {
        System.out.println("Paid" + amount + " via Wallet");
    }
}

// Main
public class PaymentMain {
    public static void main(String[] args) {
        Payment p1 = new UPI();
        Payment p2 = new CreditCard();
        Payment p3 = new Wallet();

        p1.pay(500);
        p2.pay(1200);
        p3.pay(300);
    }
}
