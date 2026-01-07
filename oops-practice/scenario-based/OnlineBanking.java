import java.util.ArrayList;

class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String msg) {
        super(msg);
    }
}

// Abstraction 
interface BankService {
    void deposit(double amount);
    void withdraw(double amount) throws InsufficientBalanceException;
    double calculateInterest();
}

abstract class Account implements BankService {
    int accountNumber;
    String holderName;
    double balance;

    Account(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // synchronized → multithreading safe
    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited. Balance = " + balance);
    }

    public synchronized void withdraw(double amount)
            throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient Balance!");
        }
        balance -= amount;
        System.out.println(amount + " withdrawn. Balance = " + balance);
    }

    double getBalance() {
        return balance;
    }
}

class SavingsAccount extends Account {
    SavingsAccount(int accNo, String name, double bal) {
        super(accNo, name, bal);
    }

    // POLYMORPHISM
    public double calculateInterest() {
        return balance * 0.04; 
    }
}

class CurrentAccount extends Account {
    CurrentAccount(int accNo, String name, double bal) {
        super(accNo, name, bal);
    }

    // POLYMORPHISM
    public double calculateInterest() {
        return balance * 0.02; // 2% interest
    }
}

class Transaction {
    String type;
    double amount;

    Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
}

// CRUD
class BankManager {

    ArrayList<Account> accounts = new ArrayList<>();
    ArrayList<Transaction> transactions = new ArrayList<>();

    // CREATE
    void addAccount(Account acc) {
        accounts.add(acc);
    }

    // READ
    void showBalance(Account acc) {
        System.out.println("Balance = " + acc.getBalance());
    }

    // UPDATE - Transfer
    void transfer(Account from, Account to, double amount)
            throws InsufficientBalanceException {

        synchronized (this) {
            from.withdraw(amount);
            to.deposit(amount);
            transactions.add(new Transaction("Transfer", amount));
            System.out.println("Transfer Successful");
        }
    }

    // READ 
    void showTransactions() {
        for (Transaction t : transactions) {
            System.out.println(t.type + " : " + t.amount);
        }
    }

    // DELETE
    void deleteTransactions() {
        transactions.clear();
        System.out.println("All transactions cleared");
    }
}

class TransactionThread extends Thread {
    Account account;
    double amount;

    TransactionThread(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    public void run() {
        try {
            account.withdraw(amount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

public class OnlineBanking {
    public static void main(String[] args) throws InsufficientBalanceException {

        BankManager manager = new BankManager();

        Account acc1 = new SavingsAccount(101, "Shyam", 5000);
        Account acc2 = new CurrentAccount(102, "Amit", 3000);

        manager.addAccount(acc1);
        manager.addAccount(acc2);

        // CRUD operations
        manager.showBalance(acc1);
        manager.transfer(acc1, acc2, 1000);
        manager.showBalance(acc1);
        manager.showBalance(acc2);

        // POLYMORPHISM
        System.out.println("Savings Interest = " + acc1.calculateInterest());
        System.out.println("Current Interest = " + acc2.calculateInterest());

        // MULTITHREADING
        Thread t1 = new TransactionThread(acc1, 500);
        Thread t2 = new TransactionThread(acc1, 700);

        t1.start();
        t2.start();

        manager.showTransactions();
        manager.deleteTransactions();
    }
}
