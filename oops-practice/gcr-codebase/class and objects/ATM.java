class BankAccount {
    // Attributes
    String accountHolder;
    String accountNumber;
    double balance;

    // Constructor to initialize account details
    BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to deposit money
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
        displayBalance();
    }

    // Method to withdraw money (only if sufficient balance exists)
    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdraw amount is : " + amount);
            displayBalance();
        } else {
            System.out.println("Insufficient balance");
        }
    }

    // Method to display current balance
    void displayBalance() {
        System.out.println("Current balance: " + balance);
    }
}

// Main class
public class ATM {
    public static void main(String[] args) {
        // Create a BankAccount object
        BankAccount account = new BankAccount("State of Chennai", "ACC001", 700.0);

        // Display initial balance
        System.out.println(account.accountHolder);
        account.displayBalance();

        // Deposit money
        account.deposit(200.0);

        // Withdraw money
        account.withdraw(100.0);

        // Try withdrawing more than balance
        account.withdraw(1000.0);
    }
}