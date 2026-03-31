import java.io.FileWriter; 

public class WriteCSV {
    public static void main(String[] args) throws Exception {

        FileWriter fw = new FileWriter("employees.csv");

        // header
        fw.write("ID,Name,Department,Salary\n");

        // records
        fw.write("1,Ram,IT,50000\n");
        fw.write("2,Shyam,HR,45000\n");
        fw.write("3,Amit,Sales,40000\n");
        fw.write("4,Neha,Finance,55000\n");
        fw.write("5,Pooja,IT,60000\n");

        fw.close();
        System.out.println("CSV file created successfully");
    }
}
