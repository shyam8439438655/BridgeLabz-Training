import java.io.*;
import java.util.regex.*;

public class ValidateCSV {
    public static void main(String[] args) throws Exception {

        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        Pattern phonePattern = Pattern.compile("^\\d{10}$");

        BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
        String header = br.readLine(); // header
        String line;

        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");

            String email = d[2];
            String phone = d[3];

            boolean emailOk = emailPattern.matcher(email).matches();
            boolean phoneOk = phonePattern.matcher(phone).matches();

            if (!emailOk || !phoneOk) {
                System.out.println("Invalid Row: " + line);
                if (!emailOk) System.out.println("  Error: Invalid Email");
                if (!phoneOk) System.out.println("  Error: Phone must be exactly 10 digits");
            }
        }

        br.close();
    }
}