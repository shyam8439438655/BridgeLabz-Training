import java.util.*;

public class SearchWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();    
        sc.nextLine();             

        String[] sentences = new String[n];

        for (int i = 0; i < n; i++) {
            sentences[i] = sc.nextLine();
        }

        String word = sc.nextLine();   
        String result = "Not Found";

        for (int i = 0; i < n; i++) {  
            if (sentences[i].contains(word)) {
                result = sentences[i];
                break;
            }
        }

        System.out.println(result);
    }
}
