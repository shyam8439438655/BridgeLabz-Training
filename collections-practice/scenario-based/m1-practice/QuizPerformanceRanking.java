import java.util.*;

class Student {
    String name;
    String dept;
    int q1, q2, q3;

    Student(String n, String d, int a, int b, int c) {
        name = n;
        dept = d;
        q1 = a;
        q2 = b;
        q3 = c;
    }

    int total() {
        return q1 + q2 + q3;
    }
}

public class QuizPerformanceRanking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        List<Student> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();
            String[] p = line.split(" ");

            if (p[0].equals("Record")) {

                String name = p[1];
                String dept = p[2];
                int q1 = Integer.parseInt(p[3]);
                int q2 = Integer.parseInt(p[4]);
                int q3 = Integer.parseInt(p[5]);

                list.add(new Student(name, dept, q1, q2, q3));
                System.out.println("Record Added: " + name);
            }

            else if (p[0].equals("Top")) {

                if (list.isEmpty()) {
                    System.out.println("No Records Available");
                    continue;
                }

                String key = p[1];

                // Department Top
                if (!key.startsWith("Q")) {

                    int max = -1;
                    boolean found = false;

                    for (Student s : list) {
                        if (s.dept.equals(key)) {
                            found = true;
                            max = Math.max(max, s.total());
                        }
                    }

                    if (!found) {
                        System.out.println("Department Not Found");
                        continue;
                    }

                    for (Student s : list) {
                        if (s.dept.equals(key) && s.total() == max) {
                            System.out.println(s.name + " " + max);
                        }
                    }
                }

                // Quiz Top
                else {

                    int max = -1;

                    for (Student s : list) {

                        int val = 0;

                        if (key.equals("Q1")) val = s.q1;
                        else if (key.equals("Q2")) val = s.q2;
                        else if (key.equals("Q3")) val = s.q3;

                        max = Math.max(max, val);
                    }

                    for (Student s : list) {

                        int val = 0;

                        if (key.equals("Q1")) val = s.q1;
                        else if (key.equals("Q2")) val = s.q2;
                        else if (key.equals("Q3")) val = s.q3;

                        if (val == max) {
                            System.out.println(s.name + " " + max);
                        }
                    }
                }
            }
        }
    }
}