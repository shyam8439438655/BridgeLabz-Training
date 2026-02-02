import java.util.ArrayList;

public class Ex3_SuppressWarnings {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        // Raw ArrayList (no generics) -> normally gives unchecked warnings
        ArrayList list = new ArrayList();

        list.add("Rahul");
        list.add(123); // mixed types possible in raw list

        System.out.println(list);
    }
}
