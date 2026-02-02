import java.lang.reflect.*;
import java.util.*;

public class DynamicMethodInvoke {

    static class MathOperations {
        public int add(int a, int b) { return a + b; }
        public int subtract(int a, int b) { return a - b; }
        public int multiply(int a, int b) { return a * b; }
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter method name: add / subtract / multiply");
        String methodName = sc.nextLine().trim();

        System.out.print("Enter a: ");
        int a = sc.nextInt();
        System.out.print("Enter b: ");
        int b = sc.nextInt();

        MathOperations obj = new MathOperations();

        // find method by name + parameter types
        Method m = MathOperations.class.getMethod(methodName, int.class, int.class);

        Object ans = m.invoke(obj, a, b);
        System.out.println("Answer: " + ans);

        sc.close();
    }
}
