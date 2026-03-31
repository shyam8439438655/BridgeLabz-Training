class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String msg) {
        super(msg);
    }
}

// Interface
interface TransferService {
    void transfer(Wallet from, Wallet to, int amount) throws InsufficientBalanceException;
}

// User
class User {
    String name;

    User(String name) {
        this.name = name;
    }
}

// Transaction
class Transaction {
    String type;  // "Add", "Withdraw", "Transfer Sent", "Transfer Received"
    int amount;

    Transaction(String type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    void showTransaction() {
        System.out.println(type + ": " + amount);
    }
}

// Wallet
class Wallet {
    User user;
    int balance = 0;
    Transaction[] transactions = new Transaction[20]; // simple array for transaction history
    int txCount = 0;

    Wallet(User user) {
        this.user = user;
    }

    void addMoney(int amount) {
        balance += amount;
        transactions[txCount++] = new Transaction("Added", amount);
        System.out.println(amount + " added to " + user.name + "'s wallet");
    }

    void withdrawMoney(int amount) throws InsufficientBalanceException {
        if (balance < amount) throw new InsufficientBalanceException("Low Balance");
        balance -= amount;
        transactions[txCount++] = new Transaction("Withdrawn", amount);
        System.out.println(amount + " withdrawn from " + user.name + "'s wallet");
    }

    void showTransactions() {
        System.out.println("\nTransaction History for " + user.name + ":");
        for (int i = 0; i < txCount; i++) {
            transactions[i].showTransaction();
        }
    }
}

// Wallet Transfer
class WalletTransfer implements TransferService {
    public void transfer(Wallet from, Wallet to, int amount) throws InsufficientBalanceException {
        if (from.balance < amount) throw new InsufficientBalanceException("Not enough balance");

        from.balance -= amount;
        to.balance += amount;

        // Record transactions for both wallets
        from.transactions[from.txCount++] = new Transaction("Transfer Sent to " + to.user.name, amount);
        to.transactions[to.txCount++] = new Transaction("Transfer Received from " + from.user.name, amount);

        System.out.println(amount + " transferred from " + from.user.name + " to " + to.user.name);
    }
}

public class DigitalWalletSystem {
    public static void main(String[] args) {

        User u1 = new User("Rahul");
        User u2 = new User("Anita");

        Wallet w1 = new Wallet(u1);
        Wallet w2 = new Wallet(u2);

        TransferService ts = new WalletTransfer();

        try {
            w1.addMoney(500);
            w1.withdrawMoney(100);
            ts.transfer(w1, w2, 200);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nFinal Balances:");
        System.out.println(u1.name + ": " + w1.balance);
        System.out.println(u2.name + ": " + w2.balance);

        // Show Transaction History
        w1.showTransactions();
        w2.showTransactions();
    }
}
