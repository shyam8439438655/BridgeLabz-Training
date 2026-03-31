import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program!");

        Scanner sc = new Scanner(System.in);
        AddressBookSystem system = new AddressBookSystem();

        while (true) {
            System.out.println("\n1 Add AddressBook");
            System.out.println("2 Add Contact");
            System.out.println("3 Edit Contact");
            System.out.println("4 Delete Contact");
            System.out.println("5 Show Contacts");
            System.out.println("6 Search by City");
            System.out.println("7 Search by State");
            System.out.println("8 Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter AddressBook name: ");
                    system.addAddressBook(sc.nextLine());
                }
                case 2 -> {
                    System.out.print("Enter AddressBook name: ");
                    AddressBook ab = system.getAddressBook(sc.nextLine());
                    if (ab == null) break;

                    System.out.print("First Name: "); String fn = sc.nextLine();
                    System.out.print("Last Name: "); String ln = sc.nextLine();
                    System.out.print("Address: "); String ad = sc.nextLine();
                    System.out.print("City: "); String city = sc.nextLine();
                    System.out.print("State: "); String state = sc.nextLine();
                    System.out.print("Zip: "); String zip = sc.nextLine();
                    System.out.print("Phone: "); String ph = sc.nextLine();
                    System.out.print("Email: "); String em = sc.nextLine();

                    ab.addContact(new Contact(fn, ln, ad, city, state, zip, ph, em));
                }
                case 3 -> {
                    System.out.print("Enter AddressBook name: ");
                    AddressBook ab = system.getAddressBook(sc.nextLine());
                    if (ab == null) break;

                    System.out.print("Enter First Name to Edit: ");
                    String fn = sc.nextLine();

                    System.out.print("New Address: "); String ad = sc.nextLine();
                    System.out.print("New City: "); String city = sc.nextLine();
                    System.out.print("New State: "); String state = sc.nextLine();
                    System.out.print("New Zip: "); String zip = sc.nextLine();
                    System.out.print("New Phone: "); String ph = sc.nextLine();
                    System.out.print("New Email: "); String em = sc.nextLine();

                    ab.editContact(fn, new Contact(fn, "", ad, city, state, zip, ph, em));
                }
                case 4 -> {
                    System.out.print("Enter AddressBook name: ");
                    AddressBook ab = system.getAddressBook(sc.nextLine());
                    if (ab == null) break;

                    System.out.print("Enter First Name to Delete: ");
                    ab.deleteContact(sc.nextLine());
                }
                case 5 -> {
                    System.out.print("Enter AddressBook name: ");
                    AddressBook ab = system.getAddressBook(sc.nextLine());
                    if (ab != null) ab.getContacts().forEach(System.out::println);
                }
                case 6 -> {
                    System.out.print("Enter city: ");
                    system.searchByCity(sc.nextLine()).forEach(System.out::println);
                }
                case 7 -> {
                    System.out.print("Enter state: ");
                    system.searchByState(sc.nextLine()).forEach(System.out::println);
                }
                case 8 -> System.exit(0);
            }
        }
    }
}