import java.io.*;

public class PipedStreams {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos); 

            // Writer Thread
            Thread writer = new Thread(() -> {
                try {
                    String msg = "Hello from Writer Thread!\n";
                    pos.write(msg.getBytes());
                    pos.close(); // important: close so reader gets -1 end
                } catch (IOException e) {
                    System.out.println("Writer error: " + e.getMessage());
                }
            });

            // Reader Thread
            Thread reader = new Thread(() -> {
                try {
                    int ch;
                    while ((ch = pis.read()) != -1) {
                        System.out.print((char) ch);
                    }
                    pis.close();
                } catch (IOException e) {
                    System.out.println("Reader error: " + e.getMessage());
                }
            });

            writer.start();
            reader.start();

            writer.join();
            reader.join();

        } catch (Exception e) {
            System.out.println("Pipe error: " + e.getMessage());
        }
    }
}
