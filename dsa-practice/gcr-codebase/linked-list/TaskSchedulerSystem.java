class Task {
    int taskId;
    String taskName;
    String priority;
    String dueDate;

    Task next;   // points to next task (circular)

    // Constructor
    Task(int taskId, String taskName, String priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    Task head;   // first task
    Task current; // used to track current task

    //  Add task at beginning
    void addAtBeginning(int id, String name, String priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);

        if (head == null) {
            head = newTask;
            newTask.next = head;   // circular link
            current = head;
            return;
        }

        Task temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        newTask.next = head;
        temp.next = newTask;
        head = newTask;
    }

    //  Add task at end
    void addAtEnd(int id, String name, String priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);

        if (head == null) {
            head = newTask;
            newTask.next = head;
            current = head;
            return;
        }

        Task temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newTask;
        newTask.next = head;
    }

    //  Add task at specific position 
    void addAtPosition(int position, int id, String name, String priority, String dueDate) {

        if (position == 1) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }

        Task temp = head;
        for (int i = 1; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        Task newTask = new Task(id, name, priority, dueDate);
        newTask.next = temp.next;
        temp.next = newTask;
    }

    //  Remove task by ID
    void removeById(int id) {
        if (head == null) {
            System.out.println("Task list is empty");
            return;
        }

        Task temp = head;
        Task prev = null;

        do {
            if (temp.taskId == id) {

                // only one task
                if (temp.next == head && prev == null) {
                    head = null;
                    current = null;
                    System.out.println("Task removed");
                    return;
                }

                // removing head
                if (temp == head) {
                    Task last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                    current = head;
                } else {
                    prev.next = temp.next;
                }

                System.out.println("Task removed");
                return;
            }

            prev = temp;
            temp = temp.next;

        } while (temp != head);

        System.out.println("Task not found");
    }

    //  View current task and move to next
    void viewNextTask() {
        if (current == null) {
            System.out.println("No tasks available");
            return;
        }

        System.out.println("Current Task:");
        printTask(current);
        current = current.next;   // move to next task
    }

    //  Display all tasks
    void displayAll() {
        if (head == null) {
            System.out.println("No tasks to display");
            return;
        }

        Task temp = head;
        System.out.println("All Tasks:");
        do {
            printTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    //  Search task by priority
    void searchByPriority(String priority) {
        if (head == null) {
            System.out.println("No tasks available");
            return;
        }

        Task temp = head;
        boolean found = false;

        do {
            if (temp.priority.equalsIgnoreCase(priority)) {
                printTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No task found with this priority");
        }
    }

    void printTask(Task t) {
        System.out.println("         ");
        System.out.println("Task ID   : " + t.taskId);
        System.out.println("Task Name : " + t.taskName);
        System.out.println("Priority  : " + t.priority);
        System.out.println("Due Date  : " + t.dueDate);
    }
}

public class TaskSchedulerSystem {
    public static void main(String[] args) {

        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addAtEnd(1, "Assignment", "High", "10-02-2026");
        scheduler.addAtEnd(2, "Project", "Medium", "15-02-2026");
        scheduler.addAtBeginning(3, "Exam Prep", "High", "08-02-2026");

        scheduler.displayAll();

        scheduler.viewNextTask();
        scheduler.viewNextTask();

        scheduler.searchByPriority("High");

        scheduler.removeById(2);

        scheduler.displayAll();
    }
}
