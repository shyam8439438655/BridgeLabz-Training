import java.io.*;

// Marker interface
interface Backupable {
}

// Class marked for backup
class UserData implements Backupable, Serializable {
    int id;
    String name;

    UserData(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class BackupTestMain {
    public static void main(String[] args) throws Exception {

        UserData user = new UserData(1, "Amit");

        if (user instanceof Backupable) {
            ObjectOutputStream out =
                    new ObjectOutputStream(new FileOutputStream("backup.dat"));
            out.writeObject(user);
            out.close();

            System.out.println("Data backed up successfully");
        }
    }
}
