import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3,1,2,2,3,4);

        List<Integer> result = new ArrayList<>();
        for(Integer x : list){
            if(!result.contains(x)){
                result.add(x);
            }
        }

        System.out.println(result); 
    }
}
