import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import model.AddressBook;
import model.Contact;

import java.io.*;
import java.util.List;

public class CSVService {

    private static final String CSV_PATH = "AddressBook.csv";

    public static void writeCSV(AddressBook book) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_PATH))) {

            for (Contact c : book.getContacts()) {
                String[] data = {
                        c.getFirstName(), c.getCity(), c.getState(), c.getZip()
                };
                writer.writeNext(data);
            }

            System.out.println("CSV written successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readCSV() {
        try (CSVReader reader = new CSVReader(new FileReader(CSV_PATH))) {

            String[] line;
            while ((line = reader.readNext()) != null) {
                System.out.println("Name: " + line[0] + ", City: " + line[1] +
                        ", State: " + line[2] + ", Zip: " + line[3]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}