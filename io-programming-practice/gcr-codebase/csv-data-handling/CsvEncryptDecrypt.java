import java.io.*;
import java.util.*;

public class CsvEncryptDecrypt {

    // change this key if you want
    static final String KEY = "mySecretKey";

    public static void main(String[] args) throws Exception {

        //Write CSV with encryption for Salary + Email
        List<String[]> data = new ArrayList<>();
        data.add(new String[]{"ID", "Name", "Email", "Salary"}); // header
        data.add(new String[]{"1", "Rahul", "rahul@gmail.com", "45000"});
        data.add(new String[]{"2", "Aman", "aman@yahoo.com", "60000"});
        data.add(new String[]{"3", "Neha", "neha@company.com", "75000"});

        writeEncryptedCsv("employees_encrypted.csv", data);

        // 2) Read CSV and decrypt Salary + Email
        readDecryptedCsv("employees_encrypted.csv");
    }

    // WRITE (Encrypt)
    static void writeEncryptedCsv(String fileName, List<String[]> rows) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

        // header same
        bw.write(String.join(",", rows.get(0)));
        bw.newLine();

        // encrypt Email (index 2) and Salary (index 3)
        for (int i = 1; i < rows.size(); i++) {
            String[] r = rows.get(i);

            String id = r[0];
            String name = r[1];
            String emailEnc = encrypt(r[2]);
            String salaryEnc = encrypt(r[3]);

            bw.write(id + "," + name + "," + emailEnc + "," + salaryEnc);
            bw.newLine();
        }

        bw.close();
        System.out.println("Encrypted CSV saved: " + fileName);
    }

    // READ (Decrypt) 
    static void readDecryptedCsv(String fileName) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String header = br.readLine(); // header
        System.out.println("\n--- Decrypted View ---");
        System.out.println(header);

        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",", -1);

            // expecting: ID,Name,EmailEnc,SalaryEnc
            String id = parts[0];
            String name = parts[1];
            String email = decrypt(parts[2]);
            String salary = decrypt(parts[3]);

            System.out.println(id + "," + name + "," + email + "," + salary);
        }

        br.close();
    }

    // Simple XOR-based encryption + Base64 encoding
    static String encrypt(String plain) throws Exception {
        if (plain == null) return "";
        char[] p = plain.toCharArray();
        char[] k = KEY.toCharArray();
        char[] out = new char[p.length];

        for (int i = 0; i < p.length; i++) {
            out[i] = (char) (p[i] ^ k[i % k.length]);
        }

        byte[] bytes = new String(out).getBytes("UTF-8");
        return Base64.getEncoder().encodeToString(bytes);
    }

    static String decrypt(String encrypted) throws Exception {
        if (encrypted == null || encrypted.isEmpty()) return "";

        byte[] decoded = Base64.getDecoder().decode(encrypted);
        char[] p = new String(decoded, "UTF-8").toCharArray();
        char[] k = KEY.toCharArray();
        char[] out = new char[p.length];

        for (int i = 0; i < p.length; i++) {
            out[i] = (char) (p[i] ^ k[i % k.length]);
        }

        return new String(out);
    }
}
