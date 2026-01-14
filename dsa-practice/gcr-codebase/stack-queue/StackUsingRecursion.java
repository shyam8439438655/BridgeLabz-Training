import java.util.Stack;

class SortStack {

    // Sort stack
    static void sortStack(Stack<Integer> st) {
        if (!st.isEmpty()) {
            int temp = st.pop();
            sortStack(st);
            insertSorted(st, temp);
        }
    }

    // Insert element at correct position
    static void insertSorted(Stack<Integer> st, int value) {
        if (st.isEmpty() || st.peek() <= value) {
            st.push(value);
            return;
        }
        int temp = st.pop();
        insertSorted(st, value);
        st.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        st.push(3);
        st.push(1);
        st.push(4);
        st.push(2);

        sortStack(st);

        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }
    }
}
