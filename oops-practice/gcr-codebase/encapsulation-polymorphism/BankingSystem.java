interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// Abstract class BankAccount
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    // sensitive detail encapsulated
    private String secretPin;

    public BankAccount(String accountNumber, String holderName, double balance, String secretPin) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.secretPin = secretPin;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    // encapsulated sensitive info
    protected String getSecretPin() {
        return secretPin;
    }

    // concrete methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(holderName + " deposited: " + amount + ", New Balance: " + balance);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(holderName + " withdrew: " + amount + ", Remaining Balance: " + balance);
        } else {
            System.out.println("Withdrawal failed for " + holderName + ": Insufficient balance");
        }
    }

    // abstract method
    public abstract double calculateInterest();

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber +
                           ", Holder: " + holderName +
                           ", Balance: " + balance +
                           ", Interest: " + calculateInterest());
    }
}

// SavingsAccount class
class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(String accountNumber, String holderName, double balance, String secretPin) {
        super(accountNumber, holderName, balance, secretPin);
    }

    @Override
    public double calculateInterest() {
        // 4% interest for savings
        return getBalance() * 0.04;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Savings Account Loan Applied: " + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        // Eligible if balance > 5000
        return getBalance() > 5000;
    }
}

// CurrentAccount class
class CurrentAccount extends BankAccount implements Loanable {
    public CurrentAccount(String accountNumber, String holderName, double balance, String secretPin) {
        super(accountNumber, holderName, balance, secretPin);
    }

    @Override
    public double calculateInterest() {
        // Current accounts: 2% interest
        return getBalance() * 0.02;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Current Account Loan Applied: " + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        // Eligible if balance > 10000
        return getBalance() > 10000;
    }
}

// Main class
public class BankingSystem {
    public static void main(String[] args) {
        BankAccount acc1 = new SavingsAccount("SAV101", "Shyam", 8000, "1234");
        BankAccount acc2 = new CurrentAccount("CUR202", "Ravi", 15000, "5678");

        BankAccount[] accounts = {acc1, acc2};

        for (BankAccount acc : accounts) {
            acc.displayDetails();
            acc.deposit(2000);
            acc.withdraw(3000);

            if (acc instanceof Loanable) {
                Loanable loanAcc = (Loanable) acc;
                loanAcc.applyForLoan(50000);
                System.out.println("Loan Eligibility: " + loanAcc.calculateLoanEligibility());
            }
            System.out.println("-------------------------");
        }
    }
}