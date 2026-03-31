import java.io.*;
import java.sql.*;

public class DbToCSV {
    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/company";
        String user = "root";
        String pass = "root";

        Connection con = DriverManager.getConnection(url, user, pass);
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("SELECT id, name, department, salary FROM employees");

        BufferedWriter bw = new BufferedWriter(new FileWriter("employee_report.csv"));
        bw.write("Employee ID,Name,Department,Salary");
        bw.newLine();

        while (rs.next()) {
            bw.write(rs.getInt("id") + "," +
                     rs.getString("name") + "," +
                     rs.getString("department") + "," +
                     rs.getDouble("salary"));
            bw.newLine();
        }

        bw.close();
        rs.close();
        st.close();
        con.close();

        System.out.println("CSV Report created: employee_report.csv");
    }
}
