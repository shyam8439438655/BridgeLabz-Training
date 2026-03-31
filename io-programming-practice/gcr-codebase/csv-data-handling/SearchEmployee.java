import java.io.*;
import java.util.Scanner;

public class SearchEmployee {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee name: ");
        String searchName = sc.nextLine();

        BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
        String line;

        br.readLine(); // skip header

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            if (data[1].equalsIgnoreCase(searchName)) {
                System.out.println("Department: " + data[2]);
                System.out.println("Salary: " + data[3]);
                break;
            }
        }

        br.close();
    }
}
