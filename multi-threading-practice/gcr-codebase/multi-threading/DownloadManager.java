import java.util.Random;

// Thread Class Approach
class FileDownloaderThread extends Thread {
    private String fileName;
    private Random random = new Random();

    public FileDownloaderThread(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            for (int progress = 0; progress <= 100; progress += 25) {
                System.out.println("[" + Thread.currentThread().getName() +
                        "] Downloading " + fileName + ": " + progress + "%");
                Thread.sleep(200 + random.nextInt(300));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Runnable Interface Approach
class FileDownloaderRunnable implements Runnable {
    private String fileName;
    private Random random = new Random();

    public FileDownloaderRunnable(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            for (int progress = 0; progress <= 100; progress += 25) {
                System.out.println("[" + Thread.currentThread().getName() +
                        "] Downloading " + fileName + ": " + progress + "%");
                Thread.sleep(200 + random.nextInt(300));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class DownloadManager {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("=== Using Thread Class Approach ===");

        FileDownloaderThread t1 =
                new FileDownloaderThread("Document.pdf");
        FileDownloaderThread t2 =
                new FileDownloaderThread("Image.jpg");
        FileDownloaderThread t3 =
                new FileDownloaderThread("Video.mp4");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("All downloads complete!\n");

        System.out.println("=== Using Runnable Interface Approach ===");

        Thread r1 = new Thread(
                new FileDownloaderRunnable("Document.pdf"), "Thread-1");
        Thread r2 = new Thread(
                new FileDownloaderRunnable("Image.jpg"), "Thread-2");
        Thread r3 = new Thread(
                new FileDownloaderRunnable("Video.mp4"), "Thread-3");

        r1.start();
        r2.start();
        r3.start();

        r1.join();
        r2.join();
        r3.join();

        System.out.println("All downloads complete!");
    }
}
