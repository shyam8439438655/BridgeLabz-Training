import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.AddressBook;
import model.Contact;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class JSONService {

    private static final String JSON_PATH = "AddressBook.json";

    public static void writeJSON(AddressBook book) {
        try (Writer writer = new FileWriter(JSON_PATH)) {

            new Gson().toJson(book.getContacts(), writer);
            System.out.println("JSON written successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readJSON() {
        try (Reader reader = new FileReader("AddressBook.json")) {

            Type listType = new TypeToken<List<Contact>>(){}.getType();
            List<Contact> contacts = new Gson().fromJson(reader, listType);
            contacts.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}