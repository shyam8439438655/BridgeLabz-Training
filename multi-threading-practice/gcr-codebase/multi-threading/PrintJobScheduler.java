class PrintJob implements Runnable {
    String jobName;
    int pages;
    int priority;

    public PrintJob(String jobName, int pages, int priority) {
        this.jobName = jobName;
        this.pages = pages;
        this.priority = priority;
    }

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        for (int i = 1; i <= pages; i++) {
            System.out.println("[" + t.getName() + "] Printing " + jobName +
                    " - Page " + i + " of " + pages);
            try { Thread.sleep(100); } catch (Exception e) {}
        }
    }
}

public class PrintJobScheduler {
    public static void main(String[] args) throws Exception {

        Thread j1 = new Thread(new PrintJob("Job1", 10, 5), "Priority-5");
        Thread j2 = new Thread(new PrintJob("Job2", 5, 8), "Priority-8");
        Thread j3 = new Thread(new PrintJob("Job3", 15, 3), "Priority-3");
        Thread j4 = new Thread(new PrintJob("Job4", 8, 6), "Priority-6");
        Thread j5 = new Thread(new PrintJob("Job5", 12, 7), "Priority-7");

        j1.setPriority(5);
        j2.setPriority(8);
        j3.setPriority(3);
        j4.setPriority(6);
        j5.setPriority(7);

        long start = System.currentTimeMillis();

        j1.start(); j2.start(); j3.start(); j4.start(); j5.start();

        j1.join(); j2.join(); j3.join(); j4.join(); j5.join();

        long end = System.currentTimeMillis();

        System.out.println("All jobs completed in " + (end - start) + "ms");
    }
}