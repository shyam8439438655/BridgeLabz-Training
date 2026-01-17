import java.io.*;

class ConsoleToFile {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file = br.readLine();

        FileWriter fw = new FileWriter(file);
        String line;

        while (true) {
            line = br.readLine();
            if (line.equals("exit")) break;
            fw.write(line + "\n");
        }
        fw.close();
    }
}
