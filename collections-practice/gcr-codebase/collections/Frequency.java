import java.util.*;

public class Frequency {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple","banana","apple","orange");

        Map<String,Integer> map = new HashMap<>();

        for(String s : list){
            if(map.containsKey(s)){
                map.put(s, map.get(s) + 1);
            }else{
                map.put(s, 1);
            }
        }

        System.out.println(map); 
    }
}
