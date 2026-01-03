class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void displayAccountType() {
        System.out.println("Account Type: Savings Account");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
class CheckingAccount extends BankAccount {
    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    public void displayAccountType() {
        System.out.println("Account Type: Checking Account");
        System.out.println("Withdrawal Limit: $" + withdrawalLimit);
    }
}
class FixedDepositAccount extends BankAccount {
    private int tenure; // in months

    public FixedDepositAccount(String accountNumber, double balance, int tenure) {
        super(accountNumber, balance);
        this.tenure = tenure;
    }

    public void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
        System.out.println("Tenure: " + tenure + " months");
    }
}
public class BankAccountTypes {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount("SA123", 5000.0, 3.5);
        savingsAccount.displayAccountInfo();
        savingsAccount.displayAccountType();
        System.out.println();

        CheckingAccount checkingAccount = new CheckingAccount("CA456", 3000.0, 1000.0);
        checkingAccount.displayAccountInfo();
        checkingAccount.displayAccountType();
        System.out.println();

        FixedDepositAccount fixedDepositAccount = new FixedDepositAccount("FDA789", 10000.0, 12);
        fixedDepositAccount.displayAccountInfo();
        fixedDepositAccount.displayAccountType();
    }
}
