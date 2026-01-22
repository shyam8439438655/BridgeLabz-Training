import java.util.*;

public class NthFrom {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>(Arrays.asList("A","B","C","D","E"));
        int n = 2;

        Iterator<String> fast = list.iterator();
        Iterator<String> slow = list.iterator();

        for(int i = 0; i < n; i++){
            fast.next();
        }

        while(fast.hasNext()){
            fast.next();
            slow.next();
        }

        System.out.println(slow.next()); 
    }
}
