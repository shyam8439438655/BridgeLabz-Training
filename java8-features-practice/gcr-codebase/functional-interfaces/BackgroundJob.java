public class BackgroundJob {
    public static void main(String[] args) {

        Runnable job = () -> {
            System.out.println("Background job started");
            System.out.println("Job running...");
            System.out.println("Background job finished");
        };

        Thread t = new Thread(job);
        t.start();
    }
}
