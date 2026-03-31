class NestedTryCatch {
    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40};
        int index = 2;     // change to test invalid index
        int divisor = 0;   // change to test divide by zero

        try {
            // outer try for array index
            int value = arr[index];

            try {
                // inner try for division
                int result = value / divisor;
                System.out.println("Result = " + result);

            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        }
    }
}
