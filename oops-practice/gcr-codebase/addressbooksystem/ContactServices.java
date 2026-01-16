package AddressBookSystem;

import java.util.ArrayList;
import java.util.List;

public class ContactServices {

    private static List<AddressBook> Contactlist = new ArrayList<>();

    public void addContacts(AddressBook c) {
		Contactlist.add(c);
	}

}
