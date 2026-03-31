import java.util.Stack;

class StockSpan {

    static void stockSpan(int[] price) {
        int n = price.length;
        int[] span = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && price[st.peek()] <= price[i]) {
                st.pop();
            }

            span[i] = st.isEmpty() ? i + 1 : i - st.peek();

            // Push current index
            st.push(i);
        }

        // Print span
        for (int s : span) {
            System.out.print(s + " ");
        }
    }

    public static void main(String[] args) {
        int[] price = {100, 80, 60, 70, 60, 75, 85};
        stockSpan(price);
    }
}
