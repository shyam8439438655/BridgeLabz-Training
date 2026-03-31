import java.io.*;

public class UserInfo {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Name: ");
            String name = br.readLine();

            System.out.print("Age: ");
            int age = Integer.parseInt(br.readLine());

            System.out.print("Fav Language: ");
            String lang = br.readLine();

            FileWriter fw = new FileWriter("user_info.txt"); // creates file if not exists
            fw.write("Name: " + name + "\n");
            fw.write("Age: " + age + "\n");
            fw.write("Favorite Language: " + lang + "\n");
            fw.close();

            System.out.println("Saved in user_info.txt");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
