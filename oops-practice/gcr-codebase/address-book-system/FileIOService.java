import java.io.*;

public class FileIOService {

    private static final String FILE_PATH = "AddressBook.txt";

    public static void writeToFile(AddressBook book) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {

            for (Contact c : book.getContacts()) {
                writer.write(c.toString());
                writer.newLine();
            }

            System.out.println("Data written to text file successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("AddressBook.txt"))) {

            String line;
            while ((line = reader.readLine()) != null)
                System.out.println(line);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}