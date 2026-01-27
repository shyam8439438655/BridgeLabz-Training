class MultipleCatch {
    public static void main(String[] args) {

        // You can change this to null to test NullPointerException
        int[] arr = {10, 20, 30, 40, 50};

        int index = 2;   // You can change this to an invalid index like 10 to test ArrayIndexOutOfBoundsException
        try {
            int value = arr[index];
            System.out.println("Value at index " + index + ": " + value);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");

        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }
}
