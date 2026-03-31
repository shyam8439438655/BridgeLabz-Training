import java.util.*;

class FileBackupScheduler {

    // custom exception
    static class InvalidBackupPathException extends Exception {
        InvalidBackupPathException(String msg) { super(msg); }
    }

    // BackupTask class 
    static class BackupTask implements Comparable<BackupTask> {
        String path;
        int priority; 

        BackupTask(String path, int priority) {
            this.path = path;
            this.priority = priority;
        }

        @Override
        public int compareTo(BackupTask other) {
            // higher priority first
            return other.priority - this.priority;
        }
    }

    static PriorityQueue<BackupTask> pq = new PriorityQueue<>();

    // add task
    static void addBackupTask(String path, int priority) throws InvalidBackupPathException {
        if (path == null || path.trim().isEmpty() || !path.contains("/")) {
            throw new InvalidBackupPathException("Invalid backup path!");
        }
        pq.add(new BackupTask(path, priority));
    }

    // execute in priority order
    static void runBackups() {
        while (!pq.isEmpty()) {
            BackupTask t = pq.poll();
            System.out.println("Backup running: " + t.path + " (priority " + t.priority + ")");
        }
    }

    public static void main(String[] args) {

        try {
            addBackupTask("/users/photos", 2);
            addBackupTask("/system/config", 5);   // critical folder -> high priority
            addBackupTask("/docs", 1);

            // invalid -> exception
            addBackupTask("", 3);

        } catch (InvalidBackupPathException e) {
            System.out.println(e.getMessage());
        }

        runBackups();
    }
}
