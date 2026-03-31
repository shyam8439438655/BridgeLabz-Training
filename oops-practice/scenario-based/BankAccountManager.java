public class BankAccountManager {
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccountManager(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Withdrew: " + amount);
            } else {
                System.out.println("Insufficient funds for withdrawal.");
            }
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    // Method to check balance
    public double checkBalance() {
        return balance;
    }

    // Main method for testing
    public static void main(String[] args) {
        BankAccountManager myAccount = new BankAccountManager("123456789");

        myAccount.deposit(500);
        System.out.println("Current Balance: " + myAccount.checkBalance());

        myAccount.withdraw(200);
        System.out.println("Current Balance: " + myAccount.checkBalance());

        myAccount.withdraw(400); // This should prevent overdraft
        System.out.println("Current Balance: " + myAccount.checkBalance());
    }
}
