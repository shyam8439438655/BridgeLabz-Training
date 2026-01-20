// Abstract class
abstract class BankAccount {

    // immutable core data
    private final String accountNumber;
    private final double balance;

    // constructor
    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    
    public double getBalance() {
        return balance;
    }

    // abstract method (polymorphism)
    abstract double calculateFee();
}

// SavingsAccount class
class SavingsAccount extends BankAccount {

    SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    // 0.5% of balance
    @Override
    double calculateFee() {
        return getBalance() * 0.005;
    }
}

// CheckingAccount class
class CheckingAccount extends BankAccount {

    CheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    // flat 1.0 if balance < 1000 else 0.0
    @Override
    double calculateFee() {
        if (getBalance() < 1000) {
            return 1.0;
        }
        return 0.0;
    }
}

// Test class
public class BankingAccountHierarchy {
    public static void main(String[] args) {

        BankAccount savings = new SavingsAccount("12345", 1000.0);
        System.out.printf("%.2f%n", savings.calculateFee()); // 5.00

        BankAccount savings2 = new SavingsAccount("11111", 500.0);
        System.out.printf("%.2f%n", savings2.calculateFee()); // 2.50

        BankAccount checking1 = new CheckingAccount("22222", 1500.0);
        System.out.printf("%.2f%n", checking1.calculateFee()); // 0.00

        BankAccount checking2 = new CheckingAccount("33333", 500.0);
        System.out.printf("%.2f%n", checking2.calculateFee()); // 1.00
    }
}
