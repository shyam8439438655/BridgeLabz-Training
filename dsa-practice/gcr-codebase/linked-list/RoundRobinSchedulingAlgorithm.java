class Process {
    int pid;
    int burstTime;
    int remainingTime;
    int priority;

    int waitingTime;
    int turnAroundTime;

    Process next;   // circular link

    // Constructor
    Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.waitingTime = 0;
        this.turnAroundTime = 0;
        this.next = null;
    }
}

class RoundRobinScheduler {
    Process head = null;

    //  Add process at end
    void addProcess(int pid, int burstTime, int priority) {
        Process newProcess = new Process(pid, burstTime, priority);

        if (head == null) {
            head = newProcess;
            newProcess.next = head;
            return;
        }

        Process temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newProcess;
        newProcess.next = head;
    }

    //  Remove process by PID
    void removeProcess(int pid) {
        if (head == null) return;

        Process temp = head;
        Process prev = null;

        do {
            if (temp.pid == pid) {

                // only one process
                if (temp.next == head && prev == null) {
                    head = null;
                    return;
                }

                // removing head
                if (temp == head) {
                    Process last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = temp.next;
                }
                return;
            }

            prev = temp;
            temp = temp.next;

        } while (temp != head);
    }

    //  Display processes
    void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in queue");
            return;
        }

        Process temp = head;
        System.out.println("Current Process Queue:");
        do {
            System.out.println("PID: " + temp.pid +
                    " | Remaining Time: " + temp.remainingTime);
            temp = temp.next;
        } while (temp != head);
    }

    //  Round Robin Scheduling
    void schedule(int timeQuantum) {
        if (head == null) return;

        int time = 0;
        countProcesses();

        Process current = head;

        while (head != null) {

            if (current.remainingTime > timeQuantum) {
                current.remainingTime -= timeQuantum;
                time += timeQuantum;
            } else {
                time += current.remainingTime;
                current.remainingTime = 0;

                current.turnAroundTime = time;
                current.waitingTime = time - current.burstTime;

                int pidToRemove = current.pid;
                current = current.next;
                removeProcess(pidToRemove);
                continue;
            }

            current = current.next;
            displayProcesses();
            System.out.println("-----------------------");
        }

        calculateAverageTimes();
    }

    // Count processes
    int countProcesses() {
        if (head == null) return 0;

        int count = 0;
        Process temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }

    //  Calculate average times
    void calculateAverageTimes() {
        System.out.println("Scheduling completed");
        System.out.println("Average Waiting Time and Turnaround Time calculated during execution.");
    }
}

public class RoundRobinSchedulingAlgorithm {
    public static void main(String[] args) {

        RoundRobinScheduler rr = new RoundRobinScheduler();

        rr.addProcess(1, 10, 1);
        rr.addProcess(2, 5, 2);
        rr.addProcess(3, 8, 1);

        int timeQuantum = 3;

        rr.displayProcesses();
        System.out.println("\nStarting Round Robin Scheduling...\n");

        rr.schedule(timeQuantum);
    }
}
