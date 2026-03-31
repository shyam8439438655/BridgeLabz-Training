class TaskRunner extends Thread {
    public TaskRunner(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000); // TIMED_WAITING
            for (int i = 0; i < 1000000; i++) {} // RUNNABLE work
        } catch (Exception e) {}
    }
}

class StateMonitor extends Thread {
    private Thread t1, t2;

    public StateMonitor(Thread t1, Thread t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("[Monitor] " + t1.getName() + " is in " + t1.getState());
            System.out.println("[Monitor] " + t2.getName() + " is in " + t2.getState());

            if (t1.getState() == Thread.State.TERMINATED &&
                t2.getState() == Thread.State.TERMINATED)
                break;

            try { Thread.sleep(500); } catch (Exception e) {}
        }
    }
}

public class ThreadMonitoringSystem {
    public static void main(String[] args) {

        TaskRunner t1 = new TaskRunner("Task-1");
        TaskRunner t2 = new TaskRunner("Task-2");

        StateMonitor monitor = new StateMonitor(t1, t2);

        monitor.start();
        t1.start();
        t2.start();
    }
}