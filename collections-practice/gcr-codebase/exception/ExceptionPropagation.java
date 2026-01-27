class ExceptionPropagation {

    // method1 throws exception
    static void method1() {
        int a = 10 / 0;   // ArithmeticException
    }

    // method2 calls method1
    static void method2() {
        method1();
    }

    // main handles exception
    public static void main(String[] args) {
        try {
            method2();
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }
}