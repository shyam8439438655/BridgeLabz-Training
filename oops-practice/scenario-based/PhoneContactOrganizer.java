import java.util.ArrayList;

class Contact {
    String name;
    long phoneNumber;

    public Contact(String name, long phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}

// Custom Exception
class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String msg) {
        super(msg);
    }
}

public class PhoneContactOrganizer {

    static ArrayList<Contact> contacts = new ArrayList<>();

    // ADD CONTACT (Exception handled inside)
    static void addContact(String name, long phoneNumber) {

        // check 10 digits
        if (String.valueOf(phoneNumber).length() != 10) {
            System.out.println("Error: Phone number must be exactly 10 digits");
            return;
        }

        // check duplicate
        for (Contact c : contacts) {
            if (c.phoneNumber == phoneNumber) {
                System.out.println("Duplicate contact not allowed");
                return;
            }
        }

        contacts.add(new Contact(name, phoneNumber));
        System.out.println("Contact added");
    }

    // DELETE CONTACT
    static void deleteContact(long phoneNumber) {

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).phoneNumber == phoneNumber) {
                contacts.remove(i);
                System.out.println("Contact deleted");
                return;
            }
        }

        System.out.println("Contact not found");
    }

    // SEARCH CONTACT
    static void searchContact(long phoneNumber) {

        for (Contact c : contacts) {
            if (c.phoneNumber == phoneNumber) {
                System.out.println("Name: " + c.name);
                System.out.println("Phone: " + c.phoneNumber);
                return;
            }
        }

        System.out.println("Contact not found");
    }

    // MAIN METHOD
    public static void main(String[] args) {

        addContact("Aman", 9876543210L);   // valid
        addContact("Ravi", 12345L);        // invalid
        addContact("Aman", 9876543210L);   // duplicate

        deleteContact(9876543210L);        // delete
        searchContact(9876543210L);        // search
    }
}
