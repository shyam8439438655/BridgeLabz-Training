import java.util.Objects;

public class Contact {

    private String firstName, lastName, address, city, state, zip, phone, email;

    public Contact(String firstName, String lastName, String address, String city,
                   String state, String zip, String phone, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    public String getFirstName() { return firstName; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZip() { return zip; }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Contact c) {
            return this.firstName.equalsIgnoreCase(c.firstName);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName.toLowerCase());
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " | " +
                city + ", " + state + " | ZIP: " + zip +
                " | Phone: " + phone + " | Email: " + email;
    }
}