import java.io.*;
import java.util.*;

public class TopSalaryEmployees {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
        List<String[]> list = new ArrayList<>();

        br.readLine(); // skip header
        String line;

        while ((line = br.readLine()) != null) {
            list.add(line.split(","));
        }

        list.sort((a, b) -> Integer.parseInt(b[3]) - Integer.parseInt(a[3]));

        System.out.println("Top 5 Highest Paid Employees:");
        for (int i = 0; i < 5 && i < list.size(); i++) {
            System.out.println(
                list.get(i)[1] + " - " +
                list.get(i)[2] + " - " +
                list.get(i)[3]
            );
        }

        br.close();
    }
}
