import java.util.*;
import java.util.stream.Collectors;

public class AddressBookSystem {

    private Map<String, AddressBook> addressBooks = new HashMap<>();

    public void addAddressBook(String name) {
        if (!addressBooks.containsKey(name))
            addressBooks.put(name, new AddressBook(name));
        else
            System.out.println("AddressBook already exists!");
    }

    public AddressBook getAddressBook(String name) {
        return addressBooks.get(name);
    }

    // UC8 Search by City or State across all books
    public List<Contact> searchByCity(String city) {
        return addressBooks.values().stream()
                .flatMap(ab -> ab.getContacts().stream())
                .filter(c -> c.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    public List<Contact> searchByState(String state) {
        return addressBooks.values().stream()
                .flatMap(ab -> ab.getContacts().stream())
                .filter(c -> c.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());
    }

    // UC9 View persons by City/State
    public Map<String, List<Contact>> viewByCity() {
        Map<String, List<Contact>> map = new HashMap<>();
        for (AddressBook ab : addressBooks.values()) {
            for (Contact c : ab.getContacts()) {
                map.computeIfAbsent(c.getCity(), k -> new ArrayList<>()).add(c);
            }
        }
        return map;
    }

    public Map<String, List<Contact>> viewByState() {
        Map<String, List<Contact>> map = new HashMap<>();
        for (AddressBook ab : addressBooks.values()) {
            for (Contact c : ab.getContacts()) {
                map.computeIfAbsent(c.getState(), k -> new ArrayList<>()).add(c);
            }
        }
        return map;
    }

    // UC10 Count contacts by City/State
    public long countByCity(String city) {
        return searchByCity(city).size();
    }

    public long countByState(String state) {
        return searchByState(state).size();
    }
}