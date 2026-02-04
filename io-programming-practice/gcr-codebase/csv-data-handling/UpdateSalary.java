import java.io.*;

public class UpdateSalary {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("updated_employees.csv"));

        String line;
        bw.write(br.readLine()); // write header
        bw.newLine();

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            if (data[2].equalsIgnoreCase("IT")) {
                double salary = Double.parseDouble(data[3]);
                salary = salary + (salary * 0.10);
                data[3] = String.valueOf((int) salary);
            }

            bw.write(String.join(",", data));
            bw.newLine();
        }

        br.close();
        bw.close();

        System.out.println("Updated file created");
    }
}
