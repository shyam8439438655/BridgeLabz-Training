class BankAccount {
    // Public member
    public int accountNumber;

    // Protected member (accessible in subclasses)
    protected String accountHolder;

    // Private member (only accessible inside BankAccount class)
    private double balance;

    // Constructor
    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Public method to get balance
    public double getBalance() {
        return balance;
    }

    // Public method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }

    // Public method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }

    // Display account details
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}

// Subclass: SavingsAccount
class SavingsAccount extends BankAccount {
    private double interestRate;

    // Constructor
    public SavingsAccount(int accountNumber, String accountHolder, double balance, double interestRate) {
        // Call parent constructor
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    // Demonstrating access to public (accountNumber) and protected (accountHolder)
    public void displaySavingsInfo() {
        System.out.println("Savings Account Number (public): " + accountNumber);
        System.out.println("Savings Account Holder (protected): " + accountHolder);
        System.out.println("Balance (via getter): " + getBalance());
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// Main class to test
public class BankAccountManagement {
    public static void main(String[] args) {
        // Create a BankAccount object
        BankAccount acc1 = new BankAccount(1001, "Rahul Sharma", 5000.0);
        acc1.displayAccountInfo();

        // Deposit and withdraw
        acc1.deposit(2000);
        acc1.withdraw(1500);
        System.out.println("Updated Balance: " + acc1.getBalance());

        System.out.println("-----------------------------");

        // Create a SavingsAccount object
        SavingsAccount sav1 = new SavingsAccount(2001, "Priya Verma", 10000.0, 4.5);
        sav1.displaySavingsInfo();
    }
}