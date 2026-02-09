import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {

    private String name;
    private List<Contact> contacts = new ArrayList<>();

    public AddressBook(String name) { this.name = name; }
    public String getName() { return name; }

    // UC1 Add Contact with duplicate check (UC6)
    public boolean addContact(Contact c) {
        if (contacts.contains(c)) {
            System.out.println("Duplicate Contact! Cannot add.");
            return false;
        }
        contacts.add(c);
        return true;
    }

    // UC2 Edit Contact
    public boolean editContact(String firstName, Contact newDetails) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getFirstName().equalsIgnoreCase(firstName)) {
                contacts.set(i, newDetails);
                return true;
            }
        }
        return false;
    }

    // UC3 Delete Contact
    public boolean deleteContact(String firstName) {
        return contacts.removeIf(c -> c.getFirstName().equalsIgnoreCase(firstName));
    }

    public List<Contact> getContacts() { return contacts; }

    // UC11 Sort by Name
    public List<Contact> sortByName() {
        return contacts.stream()
                .sorted(Comparator.comparing(Contact::getFirstName))
                .collect(Collectors.toList());
    }

    // UC12 Sort by City/State/Zip
    public List<Contact> sortByCity() {
        return contacts.stream()
                .sorted(Comparator.comparing(Contact::getCity))
                .collect(Collectors.toList());
    }

    public List<Contact> sortByState() {
        return contacts.stream()
                .sorted(Comparator.comparing(Contact::getState))
                .collect(Collectors.toList());
    }

    public List<Contact> sortByZip() {
        return contacts.stream()
                .sorted(Comparator.comparing(Contact::getZip))
                .collect(Collectors.toList());
    }
}