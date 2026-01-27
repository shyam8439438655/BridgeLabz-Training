// Custom Checked Exception
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}

class BankAccount {
    double balance = 5000;   // initial balance

    // withdraw method
    void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }

        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }

        balance = balance - amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }
}

class Bank {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();

        try {
            acc.withdraw(6000);   // change amount to test cases

        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
