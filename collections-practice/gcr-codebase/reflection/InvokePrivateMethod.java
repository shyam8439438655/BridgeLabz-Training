import java.lang.reflect.*;

public class InvokePrivateMethod {

    static class Calculator {
        private int multiply(int a, int b) {
            return a * b;
        }
    }

    public static void main(String[] args) throws Exception {

        Calculator calc = new Calculator();

        Method m = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
        m.setAccessible(true); // allow private access

        Object result = m.invoke(calc, 6, 7);
        System.out.println("Result of private multiply(6,7): " + result);
    }
}
