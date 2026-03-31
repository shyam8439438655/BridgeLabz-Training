// Custom marker interface
interface SensitiveData {
}

// Class marked as sensitive
class BankAccount implements SensitiveData {
    String accountNumber;
    double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}

public class EncryptionCheck {
    public static void main(String[] args) {

        BankAccount acc = new BankAccount("1234-5678", 50000);

        if (acc instanceof SensitiveData) {
            System.out.println("Encrypt this data before storage");
        } else {
            System.out.println("No encryption needed");
        }
    }
}
