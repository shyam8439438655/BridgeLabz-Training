import java.io.*;

public class DataStream {
    public static void main(String[] args) {

        String file = "student.dat";

        // WRITE data into binary file
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));

            dos.writeInt(101);          
            dos.writeUTF("Rahul");      
            dos.writeDouble(8.5);      
            dos.close();
            System.out.println("Student data saved");
        } catch (IOException e) {
            System.out.println("Error while saving");
        }

        // READ data from binary file
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(file));

            int roll = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();

            dis.close();

            System.out.println("Student Data from file:");
            System.out.println("Roll: " + roll);
            System.out.println("Name: " + name);
            System.out.println("GPA : " + gpa);

        } catch (IOException e) {
            System.out.println("Error while reading");
        }
    }
}
