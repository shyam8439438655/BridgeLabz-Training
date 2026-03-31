import java.util.*;

public class KeyGeneration {

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++){

            String s=sc.nextLine();

            if(s.length()==0){
                System.out.println("Invalid Input (empty string)");
                continue;
            }

            if(s.length()<6){
                System.out.println("Invalid Input (length < 6)");
                continue;
            }

            if(s.contains(" ")){
                System.out.println("Invalid Input (contains space)");
                continue;
            }

            if(s.matches(".*[0-9].*")){
                System.out.println("Invalid Input (contains digits)");
                continue;
            }

            if(!s.matches("[A-Za-z]+")){
                System.out.println("Invalid Input (contains special character)");
                continue;
            }

            s=s.toLowerCase();

            StringBuilder temp=new StringBuilder();

            for(char c:s.toCharArray())
                if(c%2!=0) temp.append(c);

            temp.reverse();

            for(int j=0;j<temp.length();j++)
                if(j%2==0)
                    temp.setCharAt(j,Character.toUpperCase(temp.charAt(j)));

            System.out.println("The generated key is - "+temp);
        }
    }
}