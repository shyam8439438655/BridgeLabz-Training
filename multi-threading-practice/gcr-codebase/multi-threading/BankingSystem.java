class BankAccount {
    private int balance = 10000;

    public boolean withdraw(String customer, int amount) {

        System.out.println("[" + customer + "] Attempting to withdraw " + amount);

        if (balance >= amount) {
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            balance -= amount;

            System.out.println(
                "Transaction successful: " + customer +
                ", Amount: " + amount +
                ", Balance: " + balance
            );
            return true;
        } else {
            System.out.println(
                "Transaction failed: " + customer +
                ", Amount: " + amount +
                ", Balance: " + balance
            );
            return false;
        }
    }
}

class Transaction implements Runnable {
    private BankAccount account;
    private String customer;
    private int amount;

    Transaction(BankAccount account, String customer, int amount) {
        this.account = account;
        this.customer = customer;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(customer, amount);
    }
}

public class BankingSystem {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        Thread t1 = new Thread(new Transaction(account, "Customer-1", 3000), "Customer-1");
        Thread t2 = new Thread(new Transaction(account, "Customer-2", 4000), "Customer-2");
        Thread t3 = new Thread(new Transaction(account, "Customer-3", 2000), "Customer-3");
        Thread t4 = new Thread(new Transaction(account, "Customer-4", 5000), "Customer-4");
        Thread t5 = new Thread(new Transaction(account, "Customer-5", 1500), "Customer-5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
